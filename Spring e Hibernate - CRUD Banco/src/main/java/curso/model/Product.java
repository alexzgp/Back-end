package curso.model;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

//create table product (
//		id int(32) auto_increment,
//	    name varchar(255),
//	    long_desc text,
//	    short_desc varchar(255),
//	    price float,
//	    primary key (id)
//	);

@Entity
@Table(name = "product")
public class Product {
	private long id;
	private String name;
	private String long_desc;
	private String short_desc;
	private float price;
	
	public Product() {}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "long_desc")
	public String getLong_desc() {
		return this.long_desc;
	}

	public void setLong_desc(String long_desc) {
		this.long_desc = long_desc;
	}

	@Column(name = "short_desc")
	public String getShort_desc() {
		return this.short_desc;
	}

	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

}
