package curso.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gestor")
public class Gestor {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")	
    private long id;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "correo")
    private String correo;
    @OneToMany(targetEntity = Cliente.class, mappedBy = "gestor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public Gestor() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
        cliente.setGestor(this);
    }

    public List<Cliente> getClientes() {
      return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
      this.clientes = clientes;
      for (int i = 0; i < clientes.size(); i++) {
          clientes.get(i).setGestor(this);
      }
    }

}