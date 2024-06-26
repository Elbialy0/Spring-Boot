package com.example.demo.productDAO;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product>findAll();
    Product addProduct(Product theProduct);
    Product updateProduct(Product theProduct);
    Product findProductById(int theId);
    void deleteProductById(int theId);
}
