const Router = require('express');
const router = Router();

const controller = require('../controllers/mensajesController');

router.route('/')
    .get(controller.getMensajes)
    .post(controller.createMensaje);

router.route('/:id')
    .get(controller.getMensaje)
    .put(controller.updateMensaje)
    .delete(controller.deleteMensaje);

module.exports = router;