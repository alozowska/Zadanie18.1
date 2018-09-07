package pl.javastart.springboot.repository;

import org.springframework.stereotype.Service;
import pl.javastart.springboot.entity.CategoryProduct;
import pl.javastart.springboot.entity.InfoProducts;
import pl.javastart.springboot.entity.Product;
import pl.javastart.springboot.exception.ProductException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> products;

    {
        prepareData();
    }

    @Override
    public InfoProducts allProducts() {
        return map(products);
    }

    @Override
    public Product save(Product product) {
        if (Objects.isNull(product)) {
            throw new ProductException("Product is null");
        }
        products.add(product);
        return product;
    }

    @Override
    public InfoProducts findByCategory(String category) {
        List<Product> searchProducts = products.stream() //
                .filter(p -> p.getCategoryProduct().name().equals(category)) //
                .collect(Collectors.toList());

        return map(searchProducts);
    }


    private static void prepareData() {
        products = new ArrayList<>();
        Product product1 = new Product("mleko", 2.5, CategoryProduct.SPOZYWCZE);
        Product product2 = new Product("doniczka", 3, CategoryProduct.DOMOWE);
        Product product3 = new Product("skarpetki", 4.6, CategoryProduct.INNE);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    private InfoProducts map(List<Product> products) {
        return new InfoProducts(products);
    }
}
