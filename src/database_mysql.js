var mysql = require('mysql');
var conn = mysql.createConnection({
    host: '127.0.0.1',
    user: 'root',
    password: 'alsgur1212',
    database: 'test_crud'

});
conn.connect((err) => {
    if (err) {
        throw err;
    }
    console.log('Mysql Connected...');
});

// var sql = 'SELECT * FROM test_crud.T_CM_BBS';
// conn.query(sql, (err, rows, fields) => {
//     if (err) {
//         console.log(err);
//     } else {
//         console.log('rows', rows);
//     }

// });

const app = express();

app.get('/numnum', (req, res) => {
    var sql = 'SELECT * FROM test_crud.T_CM_BBS';
    conn.query(sql, (err, rows, fields) => {
        if (err) {
            console.log(err);
        } else {
            console.log('rows', rows);
        }

    });

})

conn.end();