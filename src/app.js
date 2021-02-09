var express = require('express');
var app = express();
const cors = require('cors');
const fs = require('fs'); //0
const multer = require('multer'); //1
const path = require('path'); //1
const mime = require('mime');
const mapper = require('mybatis-mapper');

app.use(cors());

mapper.createMapper(['C:/vuejs2-project/VueFirst_Project/src/mapper/test.xml']);


var bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: false }));
var mysql = require('mysql');

// Connection 객체 생성 
var connection = mysql.createConnection({
    host: '127.0.0.1',
    port: 3306,
    user: 'root',
    password: 'alsgur1212',
    database: 'test_crud'
});
// Connect
connection.connect();

app.listen(4000, () => {
    console.log("server connect! port : 4000");
    var dir = './uploadedFiles';
    if (!fs.existsSync(dir)) fs.mkdirSync(dir); // 2

});


app.get('/users', function(req, res) { //게시판 목록 불러오기

    var seletbbs = mapper.getStatement('oracleMapper', 'selectbbsInfo', { language: 'sql', indent: ' ' });
    var query = connection.query(seletbbs, function(err, rows) {

        console.log(rows);
        res.json(rows);

    });

    console.log(query);

});

app.post('/bbs/insert', (req, res) => { //게시판 insert시켜주기
    var bbsid = req.body.n1;
    var bbstitle = req.body.n2;
    // var bbsdate = req.body.n3;

    // var sql = 'INSERT INTO test_crud.T_CM_BBS (bbs_id, bbs_title, bbs_date) VALUES (?,?,sysdate())';
    var insertbbs = mapper.getStatement('oracleMapper', 'insertbbs', { "bbsid": bbsid, "bbstitle": bbstitle }, { language: 'sql', indent: ' ' });
    connection.query(insertbbs, (err, result, fields) => {
        if (err) {
            console.log(err);
            res.status(500).send('Internal Server Error');
        } else {
            console.log('insert success');
            res.status(200).send('Success Insert');
        }
    });

});


app.post('/bbs/delete', (req, res) => { //게시글 삭제

    var bbsid = req.body.bbsid;

    var sql = 'delete from test_crud.T_CM_BBS where bbs_id = ?';

    connection.query(sql, [bbsid], (err, result, fields) => {
        if (err) {
            console.log(err);
            res.status(500).send('Internal Server Error');
        } else {
            console.log(result);
            console.log('insert success');
            res.status(200).send('Success Insert');
        }
    });

});

app.post('/bbs/detail', (req, res) => { //상세 페이지 들어정보 가져오기

    var bbsid = req.body.bbsid;

    var sql = 'SELECT bbs_id, bbs_title, DATE_FORMAT(bbs_date, "%Y-%m-%d") as bbs_date FROM test_crud.T_CM_BBS WHERE bbs_id = ?';

    connection.query(sql, [bbsid], (err, result, fields) => {
        if (err) {
            console.log(err);
            res.status(500).send('Internal Server Error');
        } else {
            console.log(result);
            res.json(result);
            console.log('insert success');

        }
    });
});

app.post('/bbs/update', (req, res) => { //게시물 업데이트(수정)

    var bbsid = req.body.bbsid;
    var bbstitle = req.body.bbstitle;

    var sql = 'update test_crud.T_CM_BBS set bbs_title = ? where bbs_id = ?';

    connection.query(sql, [bbstitle, bbsid], (err, result, fields) => {
        if (err) {
            console.log(err);
            res.status(500).send('Internal Server Error');
        } else {
            console.log(result);
            res.json(result);
            console.log('insert success');

        }
    });
});


var storage = multer.diskStorage({ // 2
    destination(req, file, cb) {
        cb(null, 'uploadedFiles/');
    },
    filename(req, file, cb) {
        cb(null, `${file.originalname}`);

        console.log('이미지 이름은 : ' + `${file.originalname}`);
    },
});
var upload = multer({ dest: 'uploadedFiles/' }); // 3-1
var uploadWithOriginalFilename = multer({ storage: storage }); // 3-2

app.post('/uploadFileWithOriginalFilename', uploadWithOriginalFilename.single('photo'), function(req, res) { // 5


    console.log('된건가???' + req);
    console.log('이미지가 들어갔습니다!');
    res.status(200).send('Success Insert');
});


app.route('/process/download').get(function(req, res) {
    console.log('/process/download 호출됨.');
    try {
        var paramFilepath = req.param('filepath');
        var filepath = __dirname + '\\uploadedFiles\\' + paramFilepath;
        // var filepath = 'C:/vuejs2-project/VueFirst_Project/src/uploadedFiles/chart.jpg';
        console.log("@@@@@@@@@@@@@@@@: " + filepath);
        var filename = path.basename(paramFilepath);
        var mimetype = 'image/png';
        console.log('파일 패스 : ' + filepath);
        console.log('파일 이름 : ' + filename);
        console.log('MIME 타입 : ' + mimetype);
        // 파일 크기 확인
        var stats = fs.statSync(filepath);
        var fileSize = stats["size"];
        console.log('파일 크기 : ' + fileSize);
        // 클라이언트에 응답 전송
        res.setHeader('Content-disposition', 'attachment; filename=' + filename);
        res.setHeader('Content-type', mimetype);
        res.setHeader('Content-Length', fileSize);
        var filestream = fs.createReadStream(filepath);
        filestream.pipe(res);
    } catch (err) {
        console.dir(err.stack);
        res.writeHead('400', { 'Content-Type': 'text/html;charset=utf8' });
        res.write('<h3>파일 다운로드 실패</h3>');
        res.end();
    }
});