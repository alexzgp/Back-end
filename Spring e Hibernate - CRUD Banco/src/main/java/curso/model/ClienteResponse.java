package curso.model;
import java.util.ArrayList;

public class ClienteResponse {
    private Cliente cliente;
    private ArrayList<Cliente> list;
    private Exception error;
    
    public ClienteResponse() {
    }

    public ClienteResponse(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteResponse(ArrayList<Cliente> list) {
        this.list = list;
      }

      public ArrayList<Cliente> getList() {
        return list;
      }
    
      public void setList(ArrayList<Cliente> list) {
        this.list = list;
      }
    
      public ClienteResponse(Exception error) {
        this.error = error;
      }
    
      public Cliente getCliente() {
        return cliente;
      }
    
      public void setCliente(Cliente cliente) {
        this.cliente = cliente;
      }
    
     
    
      public Exception getError() {
        return error;
      }
    
      public void setError(Exception error) {
        this.error = error;
      }
}
