const Router = require('express');
const router = Router();

const controller = require('../controllers/gestoresController');

router.route('/')
    .get(controller.getGestores)
    .post(controller.createGestor);

router.route('/:id')
    .get(controller.getGestor)
    .put(controller.updateGestor)
    .delete(controller.deleteGestor);

module.exports = router;