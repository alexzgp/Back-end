const connection = require('../database');

const conn = connection()

exports.getPrestamos = (req,res) => {
        conn.query('SELECT * FROM prestamo', function (error, results, fields) {
        if (error) {
            res.json(error);
        } res.json(results);
        });
    }

exports.createPrestamo = (req, res) => {
        try{
            conn.query(  
                'INSERT INTO prestamo SET ?', req.body, 
          function (error, results, fields) {
            if (error) {
              res.json(error);
              
            }
            res.json(results);
            
          });console.log('prestamo creada exitosamente.')}catch{
            console.log('No se pudo agregar la prestamo.')}
      };

exports.getPrestamo = (req, res) => {
    conn.query('SELECT * FROM prestamo where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      } else {
        if (results.length > 0) {
          res.json(results[0]);
        } else {
          res.json({});
        }
      }
    });
  };

exports.updatePrestamo = (req, res) => {
    const prestamo = req.body;
    const updateQuery = 'UPDATE prestamo SET id_ordenante=?, id_beneficiario=?, importe=?, concepto=? WHERE id=?';
    const updateValues =  [prestamo.id_ordenante, prestamo.id_beneficiario, prestamo.importe, prestamo.concepto, req.params.id];
    conn.query(updateQuery, updateValues, (error, results, rows, fields) => {
      if (error) {
        res.json(error);
      } else {
        res.json(results);
      }
    });
  };

exports.deletePrestamo = (req, res) => {
    conn.query('DELETE FROM prestamo where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      }
    });
  };