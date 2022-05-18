package curso.model;

import java.util.ArrayList;

public class GestorUpdateRequest {
    private Gestor gestor;
    private ArrayList<Cliente> clientes;
    
    public GestorUpdateRequest() {}

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
