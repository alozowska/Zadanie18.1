package pl.javastart.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.javastart.springboot.entity.CategoryProduct;
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

//    @GetMapping("/lista")
//    public InfoProducts getAllProducts() {
//        return productRepository.allProducts();
//    }

    @GetMapping(value = "/lista")
    public InfoProducts getAllProductsFromCategory(@RequestParam(value = "kategoria", required = false)String category) {
        if (category != null) {

            return productRepository.findByCategory(category);
        } else
            return productRepository.allProducts();
    }

    @GetMapping  ("/add")
    public String addProduct(@RequestBody Product product) {
Product product=new Product();
 return "dodawanie"; //to jest źle! 
   }
}
