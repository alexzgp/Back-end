const connection = require('../database');

const conn = connection()

exports.getTransferencias = (req,res) => {
        conn.query('SELECT * FROM transferencia', function (error, results, fields) {
        if (error) {
            res.json(error);
        } res.json(results);
        });
    }

exports.createTransferencia = (req, res) => {
        try{
            conn.query(  
                'INSERT INTO transferencia SET ?', req.body, 
          function (error, results, fields) {
            if (error) {
              res.json(error);
              
            }
            res.json(results);
            
          });console.log('Transferencia creada exitosamente.')}catch{
            console.log('No se pudo agregar la transferencia.')}
      };

exports.getTransferencia = (req, res) => {
    conn.query('SELECT * FROM transferencia where id=?', [req.params.id], function (error, results, fields) {
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

exports.updateTransferencia = (req, res) => {
    const transferencia = req.body;
    const updateQuery = 'UPDATE transferencia SET id_ordenante=?, id_beneficiario=?, importe=?, concepto=? WHERE id=?';
    const updateValues =  [transferencia.id_ordenante, transferencia.id_beneficiario, transferencia.importe, transferencia.concepto, req.params.id];
    conn.query(updateQuery, updateValues, (error, results, rows, fields) => {
      if (error) {
        res.json(error);
      } else {
        res.json(results);
      }
    });
  };

exports.deleteTransferencia = (req, res) => {
    conn.query('DELETE FROM transferencia where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      }
    });
  };