package pl.javastart.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/lista")
    public InfoProducts getAllProductsFromCategory(@RequestParam(value = "kategoria", required = false)String category) {
        if (category != null) {

            return productRepository.findByCategory(category);
        } else
            return productRepository.allProducts();
    }

    @RequestMapping(value = "/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam CategoryProduct categoryProduct) {

      //  Product product = new Product(name, price, categoryProduct);
        return "dodawanie.html";
    }

        @PostMapping("/add")

    public Product saveProduct(@RequestBody Product product) {

        return productRepository.save(product);
   }
}
