package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product addProduct(Product theProduct);
    Product updateProduct(Product theProduct);
    Product findProductById(int theId);
    void deleteProductById(int theId);
}
