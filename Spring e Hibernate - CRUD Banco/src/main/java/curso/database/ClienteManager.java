package curso.database;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import curso.model.Cliente;

public class ClienteManager {
    SessionFactory sessionFactory;
	
    public ClienteManager() {
        this.setup();
    }

    public void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}    	
    }

	public List<Cliente> read() {
		System.out.println("clientemanager read");
		Session session = sessionFactory.openSession();
    	Query<Cliente> query = session.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> clientes = query.getResultList();
    	session.close();
		return clientes;
	}

	public Cliente read(Long id) {
		Session session = sessionFactory.openSession();
	    Cliente cliente = session.get(Cliente.class, id);
	    session.close();
	    return cliente;
	}

    public Cliente create(Cliente cliente) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(cliente);
    	session.getTransaction().commit();
    	session.close();
    	cliente.setId((long) id);
    	return cliente;
    }

    public Cliente update(Cliente cliente) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(cliente);
    	session.getTransaction().commit();
    	session.close();
    	return cliente;
    }
}
