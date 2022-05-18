package curso.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import curso.database.GestorManager;
import curso.model.Gestor;
import curso.model.GestorResponse;
import curso.model.GestorUpdateRequest;

@CrossOrigin(origins = "*")
@RestController
public class GestoresController {

  static GestorManager gestorManager;

  public GestoresController() {
    gestorManager = new GestorManager();
  }

  @GetMapping("/gestores")
  public List<Gestor> getGestores() {
    try {
      return gestorManager.read();
    } catch (Exception e) {
      return null;
    }
  }

  @GetMapping("/gestores/{id}")
  public Gestor getGestoresById(@PathVariable Long id) {
    try {
      return gestorManager.read(id);
    } catch (Exception e) {
      return null;
    }
  }

  @PostMapping("/gestores")
  public GestorResponse postGestores(@RequestBody Gestor gestor) {
    try {
      return new GestorResponse(gestorManager.create(gestor));
    } catch (Exception exception) {
      return new GestorResponse(exception);
    }
  }

  @PutMapping("/gestores")
  public GestorResponse putGestores(@RequestBody GestorUpdateRequest gestorRequest) {
    try {
      Gestor gestor = gestorRequest.getGestor();
      gestor.setClientes(gestorRequest.getClientes());
      return new GestorResponse(gestorManager.update(gestor));
    } catch (Exception exception) {
      return new GestorResponse(exception);
    }
  }

}

// ArrayList<Cliente> listClients = new ArrayList<Cliente>(Arrays.asList(
//   new Cliente("Bak", "1234", "ba@gmail.com"),
//   new Cliente("Bik", "1234", "b@gmail.com")));


// ArrayList<Cliente> listClients = new ArrayList<Cliente>(Arrays.asList(
//   new Cliente("Mak", "1234", "ma@gmail.com"),
//   new Cliente("Mik", "1234", "m@gmail.com")));

// gestor.setClientes(listClients);
