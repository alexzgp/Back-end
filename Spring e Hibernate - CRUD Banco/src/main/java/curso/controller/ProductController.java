package curso.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import curso.database.ProductManager;
import curso.model.Product;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {

  static ProductManager productManager;

  public ProductController() {
    productManager = new ProductManager();
    productManager.setup();
  }

  @GetMapping("/product/{id}")
  public Product getProduct(@PathVariable Long id) {
    try {
      return productManager.read(id);
    } catch (Exception e) {
      return null;
    }
  }

  @PostMapping("/product")
  public Product postProduct(@RequestBody Product product) {
    return productManager.create(product);
  }

  @PutMapping("/product/{id}")
  public Product putProduct(@RequestBody Product product, @PathVariable Long id) {
    product.setId(id);
    return productManager.update(id, product);
  }
}
