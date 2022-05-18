package curso.database;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import curso.model.Transferencia;

public class TransferenciaManager {
    SessionFactory sessionFactory;
	
    public TransferenciaManager() {
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

	public List<Transferencia> read() {
		Session session = sessionFactory.openSession();
    	Query<Transferencia> query = session.createQuery("select t from Transferencia t", Transferencia.class);
		List<Transferencia> transferencias = query.getResultList();
    	session.close();
		return transferencias;
	}

	public Transferencia read(Long id) {
		Session session = sessionFactory.openSession();
	    Transferencia transferencia = session.get(Transferencia.class, id);
	    session.close();
	    return transferencia;
	}

    public Transferencia create(Transferencia transferencia) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(transferencia);
    	session.getTransaction().commit();
    	session.close();
    	transferencia.setId((long) id);
    	return transferencia;
    }

    public Transferencia update(Transferencia transferencia) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(transferencia);
    	session.getTransaction().commit();
    	session.close();
    	return transferencia;
    }

	public Transferencia delete(Transferencia transferencia) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(transferencia);
    	session.getTransaction().commit();
    	session.close();
    	return transferencia;
    }
}
