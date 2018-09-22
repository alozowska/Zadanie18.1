package pl.javastart.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.javastart.springboot.entity.CategoryProduct;
import pl.javastart.springboot.entity.InfoProducts;
import pl.javastart.springboot.entity.Product;
import pl.javastart.springboot.repository.ProductRepository;


@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

/*    @RequestMapping(value = {"/","","/index","czydziala"})
    public String getIndexPage(){
        System.out.println("test");
        return "index.html";
    }*/

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProductsFromCategory(@RequestParam(value = "kategoria", required = false) String category) {
        StringBuilder stringBuilder = new StringBuilder();
        InfoProducts products;
        double sum = 0;
        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.allProducts();
        }
        for (Product product : products.getProducts()) {
            sum += product.getPrice();
            stringBuilder.append(product.getName()).append("<br>");
        }
        stringBuilder.append("<br>").append(sum).append(" zł");
        return stringBuilder.toString();
    }


    @GetMapping(value = {"/add"})
    public String addProductForm() {
        return "dodawanie.html";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") Double price,
                             @RequestParam("category") String category) {
        productRepository.save(new Product(name, price, CategoryProduct.valueOf(category)));
        return "redirect:/";

//        Product product = new Product(name, price, CategoryProduct.valueOf(category));


//        product.setName(name);
//        product.setPrice(price);

/*        switch (category) {
            case "SPOZYWCZE":
                product.setCategoryProduct(CategoryProduct.SPOZYWCZE);
                break;
            case "DOMOWE":
                product.setCategoryProduct(CategoryProduct.DOMOWE);
                break;
            case "INNE":
                product.setCategoryProduct(CategoryProduct.INNE);
                break;
            default:
                product.setCategoryProduct(null);
                break;
        }*/

//        product.setCategoryProduct(CategoryProduct.valueOf(category));

    }
}
