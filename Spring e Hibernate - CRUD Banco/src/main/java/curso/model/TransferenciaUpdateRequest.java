package curso.model;

import java.util.ArrayList;

public class TransferenciaUpdateRequest {
    private Transferencia transferencia;
    private ArrayList<Cliente> clientes;
    
    public TransferenciaUpdateRequest() {}

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
