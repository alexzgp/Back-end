const Router = require('express');
const router = Router();

const controller = require('../controllers/transferenciasController');

router.route('/')
    .get(controller.getTransferencias)
    .post(controller.createTransferencia);

router.route('/:id')
    .get(controller.getTransferencia)
    .put(controller.updateTransferencia)
    .delete(controller.deleteTransferencia);

module.exports = router;