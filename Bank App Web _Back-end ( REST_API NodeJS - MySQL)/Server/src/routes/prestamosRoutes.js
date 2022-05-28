const Router = require('express');
const router = Router();

const controller = require('../controllers/prestamosController');

router.route('/')
    .get(controller.getPrestamos)
    .post(controller.createPrestamo);

router.route('/:id')
    .get(controller.getPrestamo)
    .put(controller.updatePrestamo)
    .delete(controller.deletePrestamo);

module.exports = router;