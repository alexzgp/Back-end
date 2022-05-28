const connection = require('../database');

const conn = connection()

exports.getGestores = (req,res) => {
        conn.query('SELECT * FROM gestor', function (error, results, fields) {
        if (error) {
            res.json(error);
        } res.json(results);
        });
    }

exports.createGestor = (req, res) => {
        try{
            conn.query(  
                'INSERT INTO gestor SET ?', req.body, 
          function (error, results, fields) {
            if (error) {
              res.json(error);
              
            }
            res.json(results);
            
          });console.log('Gestor creado exitosamente.')}catch{
            console.log('No se pudo agregar al gestor.')}
      };

exports.getGestor = (req, res) => {
    conn.query('SELECT * FROM gestor where id=?', [req.params.id], function (error, results, fields) {
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

exports.updateGestor = (req, res) => {
    const gestor = req.body;
    const updateQuery = 'UPDATE gestor SET usuario=?, password=?, correo=? WHERE id=?';
    const updateValues =  [gestor.usuario, gestor.password, gestor.correo, req.params.id];
    conn.query(updateQuery, updateValues, (error, results, rows, fields) => {
      if (error) {
        res.json(error);
      } else {
        res.json(results);
      }
    });
  };

exports.deleteGestor = (req, res) => {
    conn.query('DELETE FROM gestor where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      }
    });
  };