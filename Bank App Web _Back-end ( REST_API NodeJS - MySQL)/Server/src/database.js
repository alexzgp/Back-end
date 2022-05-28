const mysql = require('mysql');

module.exports = () => {
    return mysql.createConnection({
      host: 'localhost',
      user: 'admin',
      password: '1234',
      database: 'banco'
    }); 
} 