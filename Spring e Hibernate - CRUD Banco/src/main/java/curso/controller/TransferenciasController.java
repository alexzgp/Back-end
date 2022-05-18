package curso.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import curso.database.TransferenciaManager;
import curso.model.Transferencia;
import curso.model.TransferenciaResponse;
import curso.model.TransferenciaUpdateRequest;

@CrossOrigin(origins = "*")
@RestController
public class TransferenciasController {

  static TransferenciaManager transferenciaManager;

  public TransferenciasController() {
    transferenciaManager = new TransferenciaManager();
  }

  @GetMapping("/transferencias")
  public List<Transferencia> getTransferencias() {
    try {
      return transferenciaManager.read();
    } catch (Exception e) {
      return null;
    }
  }

  @GetMapping("/transferencias/{id}")
  public Transferencia getTransferenciasById(@PathVariable Long id) {
    try {
      return transferenciaManager.read(id);
    } catch (Exception e) {
      return null;
    }
  }

  @PostMapping("/transferencias")
  public TransferenciaResponse postTransferencias(@RequestBody Transferencia transferencia) {
    try {
      return new TransferenciaResponse(transferenciaManager.create(transferencia));
    } catch (Exception exception) {
      return new TransferenciaResponse(exception);
    }
  }

  @PutMapping("/transferencias")
  public TransferenciaResponse putTransferencias(@RequestBody TransferenciaUpdateRequest transferenciaRequest) {
    try {
      Transferencia transferencia = transferenciaRequest.getTransferencia();
      return new TransferenciaResponse(transferenciaManager.update(transferencia));
    } catch (Exception exception) {
      return new TransferenciaResponse(exception);
    }
  }

}