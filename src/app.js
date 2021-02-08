var express = require('express');
var app = express();
const cors = require('cors');
const mapper = require('mybatis-mapper');

mapper.createMapper(['C:/vuejs2-project/VueFirst_Project/src/mapper/test.xml']);
// let test = mapper.getStatement('oracleMapper', 'selectEmpInfo', { "test": "1" }, { language: 'sql', indent: ' ' });

// console.log("@@@@@@", test);
// var serch = require('url-search-params-polyfill');

var bodyParser = require('body-parser');

// app.use(serch);
app.use(cors());
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