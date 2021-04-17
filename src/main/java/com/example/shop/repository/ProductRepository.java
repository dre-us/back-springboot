package com.example.shop.repository;

import com.example.shop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private final ArrayList<Product> products;

    public ProductRepository() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "shirt", 40000),
                new Product(2, "pants", 45000),
                new Product(3, "tie", 10000),
                new Product(4, "hat", 20000),
                new Product(5, "shoes", 50000),
                new Product(6, "bowtie", 25000)
        ));
    }

    public Product getProduct(int id) throws Exception {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        throw new Exception("Product doesn't exist.");
    }

    public List<Product> getAll() {
        return List.copyOf(products);
    }
}
