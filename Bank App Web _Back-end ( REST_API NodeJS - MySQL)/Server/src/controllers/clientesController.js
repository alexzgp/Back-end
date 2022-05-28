const connection = require('../database');

const conn = connection()

exports.getClientes = (req,res) => {
        conn.query('SELECT * FROM cliente', function (error, results, fields) {
        if (error) {
            res.json(error);
        } res.json(results);
        });
    }

exports.createCliente = (req, res) => {
        try{
            conn.query(  
                'INSERT INTO cliente SET ?', req.body, 
          function (error, results, fields) {
            if (error) {
              res.json(error);
              
            }
            res.json(results);
            
          });console.log('Cliente creado exitosamente.')}catch{
            console.log('No se pudo agregar al cliente.')}
      };

exports.getCliente = (req, res) => {
    conn.query('SELECT * FROM cliente where id=?', [req.params.id], function (error, results, fields) {
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

exports.updateCliente = (req, res) => {
    const cliente = req.body;
    const updateQuery = 'UPDATE cliente SET usuario=?, id_gestor=?, password=?, correo=?, saldo=? WHERE id=?';
    const updateValues =  [cliente.usuario, cliente.id_gestor, cliente.password, cliente.correo, cliente.saldo, req.params.id];
    conn.query(updateQuery, updateValues, (error, results, rows, fields) => {
      if (error) {
        res.json(error);
      } else {
        res.json(results);
      }
    });
  };

exports.deleteCliente = (req, res) => {
    conn.query('DELETE FROM cliente where id=?', [req.params.id], function (error, results, fields) {
      if (error) {
        res.json(error);
      }
    });
  };