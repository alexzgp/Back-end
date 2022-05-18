package curso.model;


public class TransferenciaResponse {
  private Transferencia transferencia;
  private Exception error;

  public TransferenciaResponse() {
  }

  public TransferenciaResponse(Transferencia transferencia) {
    this.transferencia = transferencia;
  }

  public TransferenciaResponse(Exception error) {
    this.error = error;
  }

  public Transferencia getTransferencia() {
    return transferencia;
  }

  public void setTransferencia(Transferencia transferencia) {
    this.transferencia = transferencia;
  }

  

  public Exception getError() {
    return error;
  }

  public void setError(Exception error) {
    this.error = error;
  }

}
