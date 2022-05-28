const Router = require('express');
const router = Router();

const controller = require('../controllers/clientesController');

router.route('/')
    .get(controller.getClientes)
    .post(controller.createCliente);

router.route('/:id')
    .get(controller.getCliente)
    .put(controller.updateCliente)
    .delete(controller.deleteCliente);

module.exports = router;