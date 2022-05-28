const connection = require('../database');

const conn = connection()

exports.getMensajes = (req,res) => {
        conn.query('SELECT * FROM mensaje', function (error, results, fields) {
        if (error) {
            res.json(error);
        } res.json(results);
        });
    }

exports.createMensaje = (req, res) => {
        try{
            conn.query(  
                'INSERT INTO mensaje SET ?', req.body, 
          function (error, results, fields) {
            if (error) {
              res.json(error);
              
            }
            res.json(results);
            
          });console.log('Mensaje creada exitosamente.')}catch{
            console.log('No se pudo agregar la mensaje.')}
      };

exports.getMensaje = (req, res) => {
    conn.query('SELECT * FROM mensaje where id=?', [req.params.id], function (error, results, fields) {
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

exports.updateMensaje = (req, res) => {
    const mensaje = req.body;
    const updateQuery = 'UPDATE mensaje SET id_ordenante=?, id_beneficiario=?, importe=?, concepto=? WHERE id=?';
    const updateValues =  [mensaje.id_ordenante, mensaje.id_beneficiario, mensaje.importe, mensaje.concepto, req.params.id];
    conn.query(updateQuery, updateValues, (error, results, rows, fields) => {
      if (error) {
        res.json(error);
      } else {
        res.json(results);
      }
    });
  };

exports.deleteMensaje = (req, res) => {
    conn.query('DELETE FROM mensaje where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      }
    });
  };