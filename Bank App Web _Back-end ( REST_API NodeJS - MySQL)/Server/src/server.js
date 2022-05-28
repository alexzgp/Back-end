// Exportar la librería de express 

const express = require('express');
const app = express();

// Con el cors odemos definir desde dónde pueden acceder al back-end

const cors = require('cors');
app.use(cors()); // Cualquier ubicación

// Hacemos que lo que pase por la API se combierta a JSON

app.use(express.json());
app.use(express.static('public'));

// Definición de puerto

const port = process.env.PORT || 3000;

// Middlewares

const morgan = require ('morgan');
app.use(morgan('dev'))

// Definición de las rutas
const gestoresRoutes = require('./routes/gestoresRoutes');
const clientesRoutes = require('./routes/clientesRoutes');
const transferenciasRoutes = require('./routes/transferenciasRoutes');
const mensajesRoutes = require('./routes/mensajesRoutes');
const prestamosRoutes = require('./routes/prestamosRoutes');

app.use('/gestores', gestoresRoutes)
app.use('/clientes', clientesRoutes)
app.use('/transferencias', transferenciasRoutes)
app.use('/mensajes', mensajesRoutes)
app.use('/prestamos', prestamosRoutes)

// Apertura del puerto

app.listen(port, () => {
    console.log(`Servidor del Gestor en el puerto ${port}`);
  });