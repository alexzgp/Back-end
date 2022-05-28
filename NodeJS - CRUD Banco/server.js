const express = require('express');
const app = express();
const cors = require('cors');
const fs = require('fs');
const mysql = require('mysql2');


app.use(cors());
app.use(express.json());
app.use(express.static('public'));
const port = 3000;

function getConnection() {
  return mysql.createConnection({
    host: 'localhost',
    user: 'admin',
    password: '1234',
    database: 'banco'
  });  
}



app.get('/product', (req, res) => {
  const connection = getConnection();
  connection.connect();
  connection.query('SELECT * FROM product', function (error, results, fields) {
    if (error) {
      res.json(error);
    }
    res.json(results);
  });
  connection.end();
});

app.get('/product/:id', (req, res) => {
  const connection = getConnection();
  connection.connect();
  connection.query('SELECT * FROM product where id=?', [req.params.id], function (error, results, fields) {
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
  connection.end();
});


/*
{
	"name": "Muñeca Barbie",
	"long_desc": "Tía molona en la playa con descapotable y piernas muy largas",
  "short_desc": "Barbie Vietnamita",
  "price": 100
}
*/
app.put('/product/:id', (req, res) => {
  const product = req.body;
  const updateQuery = 'UPDATE product SET name=?, long_desc=?, short_desc=?, price=? WHERE id=?';
  const updateValues =  [product.name, product.long_desc, product.short_desc, product.price, req.params.id];
  const connection = getConnection();
  connection.connect();
  connection.query(updateQuery, updateValues, (error, results, rows, fields) => {
    if (error) {
      res.json(error);
    } else {
      res.json(results);
    }
  });
  connection.end();
});
  

/*
{
	"name": "Muñeca Barbie",
	"long_desc": "Tía molona en la playa con descapotable y piernas muy largas",
  "short_desc": "Barbie Vietnamita",
  "price": 100
}
*/
app.post('/product', (req, res) => {
  const connection = getConnection();
  connection.connect();
  connection.query(
    'INSERT INTO product SET ?', 
    req.body, 
    function (error, results, fields) {
      if (error) {
        res.json(error);
      }
      res.json(results);
    });
  connection.end();
});


app.get('/travel', (request, response) => {
  response.json([
    {
      name: 'Barcelona',
      price: 500,
      img: 'https://wp-growpro.s3-eu-west-1.amazonaws.com/media/2020/03/Que-llevar-a-un-viaje.jpg',
    },
    {
      name: 'Londres',
      price: 400,
      img: 'https://cienciaybiologia.com/wp-content/uploads/2017/06/panda-rojo-4.jpg',
    },
    {
      name: 'París',
      price: 2300,
      img: 'https://wp-growpro.s3-eu-west-1.amazonaws.com/media/2020/03/Que-llevar-a-un-viaje.jpg',
    },
    {
      name: 'Barcelona',
      price: 500,
      img: 'https://wp-growpro.s3-eu-west-1.amazonaws.com/media/2020/03/Que-llevar-a-un-viaje.jpg',
    },
    {
      name: 'Londres',
      price: 400,
      img: 'https://wp-growpro.s3-eu-west-1.amazonaws.com/media/2020/03/Que-llevar-a-un-viaje.jpg',
    },
    {
      name: 'París',
      price: 2300,
      img: 'https://wp-growpro.s3-eu-west-1.amazonaws.com/media/2020/03/Que-llevar-a-un-viaje.jpg',
    },
  ]);
});

// post y get siempre se usan con dos parámetros:
// el primero es el PATH y el segundo es la función que resuelve la REQUEST (petición)
app.post('/travel', (request, response) => {
  console.log(request.body);
  response.json({ msg: 'Travel creado con éxito' });
});

// Llamando a la función listen iniciamos el servidor
// El primer parámetro de la función es el PUERTO
app.listen(port, () => {
  console.log(`Servidor del Gestor en el puerto ${port}`);
});

// app.get('/travel', (request, response) => {
//   fs.readFile('travelDB.json', 'utf8', function (err, contents) {
//     response.json(JSON.parse(contents));
//   });
// });
