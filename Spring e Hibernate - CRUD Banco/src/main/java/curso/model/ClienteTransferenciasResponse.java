package curso.model;

import java.util.ArrayList;

public class ClienteTransferenciasResponse {
  private ArrayList<Transferencia> transferencias_hechas;
  private ArrayList<Transferencia> transferencias_recibidas;
  private Exception error;

public ArrayList<Transferencia> getTransferencias_hechas() {
    return transferencias_hechas;
}
public void setTransferencias_hechas(ArrayList<Transferencia> transferencias_hechas) {
    this.transferencias_hechas = transferencias_hechas;
}
public ArrayList<Transferencia> getTransferencias_recibidas() {
    return transferencias_recibidas;
}
public void setTransferencias_recibidas(ArrayList<Transferencia> transferencias_recibidas) {
    this.transferencias_recibidas = transferencias_recibidas;
}
public Exception getError() {
    return error;
}
public void setError(Exception error) {
    this.error = error;
}
public void setTransferencias_hechas(Exception error) {
    this.error = error;
}
public void setTransferencias_recibidas(Exception error) {
    this.error = error;
}

}