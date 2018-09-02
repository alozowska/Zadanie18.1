package pl.javastart.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javastart.springboot.entity.InfoProducts;
import pl.javastart.springboot.entity.Product;
import pl.javastart.springboot.repository.ProductRepository;



@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public InfoProducts getAllProducts() {
        return productRepository.allProducts();
    }

    @GetMapping(value = "/{category}")
    public InfoProducts getAllProductsFromCategory(@PathVariable(value = "category")String category){
        return productRepository.findByCategory(category);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
