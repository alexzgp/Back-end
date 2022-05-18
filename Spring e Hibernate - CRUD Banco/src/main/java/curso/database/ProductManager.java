package curso.database;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import curso.model.Product;

public class ProductManager {
	SessionFactory sessionFactory;
	
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
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    public Product create(Product newProduct) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(newProduct);
    	session.getTransaction().commit();
    	session.close();
    	newProduct.setId((long) id);
    	return newProduct;
    }
 
    public Product read(Long id) {
        // code to get a product
	   Session session = sessionFactory.openSession();
	    Product product = session.get(Product.class, id);
	    session.close();
	    return product;
    }
 
    public Product update(Long id, Product newProduct) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(newProduct);
    	session.getTransaction().commit();
    	session.close();
    	return newProduct;
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) {
        // code to run the program
    }

}
