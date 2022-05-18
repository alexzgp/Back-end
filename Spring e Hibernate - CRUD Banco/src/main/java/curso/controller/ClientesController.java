package curso.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import curso.database.ClienteManager;
import curso.model.Cliente;
import curso.model.ClienteResponse;
import curso.model.ClienteUpdateRequest;

@CrossOrigin(origins = "*")
@RestController
public class ClientesController {
  
    static ClienteManager clienteManager;

  public ClientesController() {
    clienteManager = new ClienteManager();
  }

  @GetMapping("/clientes")
  public List<Cliente> getClientes() {
    try {
      return clienteManager.read();
    } catch (Exception e) {
      return null;
    }
  }

  @GetMapping("/clientes/{id}")
  public Cliente getClientesById(@PathVariable Long id) {
    try {
      return clienteManager.read(id);
    } catch (Exception e) {
      return null;
    }
  }

  @PostMapping("/clientes")
  public ClienteResponse postClientes(@RequestBody Cliente cliente) {
    try {
      return new ClienteResponse(clienteManager.create(cliente));
    } catch (Exception exception) {
      return new ClienteResponse(exception);
    }
  }

  @PutMapping("/clientes")
  public ClienteResponse putClientes(@RequestBody ClienteUpdateRequest clienteRequest) {
    try {
      Cliente cliente = clienteRequest.getCliente();
      return new ClienteResponse(clienteManager.update(cliente));
    } catch (Exception exception) {
      return new ClienteResponse(exception);
    }
  }

}
