var express = require('express');
var app = express();


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


app.get('/users', function(req, res) {

    var query = connection.query('SELECT * FROM test_crud.T_CM_BBS', function(err, rows) {

        console.log(rows);
        res.json(rows);

    });

    console.log(query);

});

// app.post('/regist', function(req, res) {
//     var user = {
//         'userid': req.body.userid,
//         'name': req.body.name,
//         'address': req.body.address
//     };
//     var query = connection.query('SELECT * FROM test_crud.T_CM_BBS', function(err, result) {
//         if (err) {
//             console.error(err);
//             throw err;
//         }
//         res.status(200).send('success');
//     });
// });