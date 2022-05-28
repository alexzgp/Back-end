package curso.database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import curso.model.Gestor;

public class GestorManager {
    SessionFactory sessionFactory;
	
    public GestorManager() {
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

	public List<Gestor> read() {
		Session session = sessionFactory.openSession();
    	Query<Gestor> query = session.createQuery("select g from Gestor g", Gestor.class);
		List<Gestor> gestores = query.getResultList();
    	session.close();
		return gestores;
	}

	public Gestor read(Long id) {
		Session session = sessionFactory.openSession();
	    Gestor gestor = session.get(Gestor.class, id);
	    session.close();
	    return gestor;
	}

    public Gestor create(Gestor gestor) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(gestor);
    	session.getTransaction().commit();
    	session.close();
    	gestor.setId((long) id);
    	return gestor;
    }

    public Gestor update(Gestor gestor) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(gestor);
    	session.getTransaction().commit();
    	session.close();
    	return gestor;
    }

	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Gestor gestor = null;
	    gestor = session.get(Gestor.class, id);
		session.delete(gestor);
	    session.close();
	}
}
