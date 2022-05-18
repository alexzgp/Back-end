package curso.model;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_gestor", nullable = false)
    private Gestor gestor;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "correo")
    private String correo;
    @Column(name = "saldo")
    private double saldo;
    @OneToMany(targetEntity = Transferencia.class, mappedBy = "clienteOrigen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Transferencia> transferencias_hechas = new ArrayList<Transferencia>();
    @OneToMany(targetEntity = Transferencia.class, mappedBy = "clienteDestino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Transferencia> transferencias_recibidas = new ArrayList<Transferencia>();

    public Cliente() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addTransferenciaHecha(Transferencia transferencia) {
        transferencias_hechas.add(transferencia);
        transferencia.setClienteOrigen(this);
    }

    public List<Transferencia> getTransferenciasHechas() {
      return transferencias_hechas;
    }

    public void setTransferenciasHechas(ArrayList<Transferencia> transferencias_hechas) {
      this.transferencias_hechas = transferencias_hechas;
      for (int i = 0; i < transferencias_hechas.size(); i++) {
          transferencias_hechas.get(i).setClienteOrigen(this);
      }
    }

    public void addTransferenciaRecibida(Transferencia transferencia) {
        transferencias_recibidas.add(transferencia);
        transferencia.setClienteDestino(this);
    }

    public List<Transferencia> getTransferenciasRecibidas() {
      return transferencias_recibidas;
    }

    public void setTransferenciasRecibidas(ArrayList<Transferencia> transferencias_recibidas) {
      this.transferencias_recibidas = transferencias_recibidas;
      for (int i = 0; i < transferencias_recibidas.size(); i++) {
          transferencias_recibidas.get(i).setClienteOrigen(this);
      }
    }
}
