package curso.model;

import java.util.ArrayList;

public class GestorResponse {
  private Gestor gestor;
  private ArrayList<Gestor> list;
  private Exception error;

  public GestorResponse() {
  }

  public GestorResponse(Gestor gestor) {
    this.gestor = gestor;
  }

  public GestorResponse(ArrayList<Gestor> list) {
    this.list = list;
  }

  public ArrayList<Gestor> getList() {
    return list;
  }

  public void setList(ArrayList<Gestor> list) {
    this.list = list;
  }

  public GestorResponse(Exception error) {
    this.error = error;
  }

  public Gestor getGestor() {
    return gestor;
  }

  public void setGestor(Gestor gestor) {
    this.gestor = gestor;
  }

  

  public Exception getError() {
    return error;
  }

  public void setError(Exception error) {
    this.error = error;
  }

}
