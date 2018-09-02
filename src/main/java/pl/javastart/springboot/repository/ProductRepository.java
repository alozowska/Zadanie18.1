package pl.javastart.springboot.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.springboot.entity.InfoProducts;
import pl.javastart.springboot.entity.Product;

@Repository
public interface ProductRepository {
    InfoProducts allProducts();
    Product save(Product product);
    InfoProducts findByCategory(String category);
}
