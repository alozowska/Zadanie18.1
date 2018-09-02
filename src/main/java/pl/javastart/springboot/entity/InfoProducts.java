package pl.javastart.springboot.entity;

import java.util.List;
import java.util.stream.DoubleStream;

public class InfoProducts {

    private List<Product> products;
    private double sum;

    public InfoProducts(List<Product> products){
        this.products = products;
        this.sum = products.stream()//
                .flatMapToDouble(p-> DoubleStream.of(p.getPrice())) //
        .sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "InfoProducts{" +
                "products=" + products +
                ", sum=" + sum +
                '}';
    }
}
