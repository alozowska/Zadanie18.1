package pl.javastart.springboot.entity;

public class Product {

    private String name;
    private double price;
    private CategoryProduct categoryProduct;

    public Product() {
    }

    public Product(String name, double price, CategoryProduct categoryProduct) {
        this.name = name;
        this.price = price;
        this.categoryProduct = categoryProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}
