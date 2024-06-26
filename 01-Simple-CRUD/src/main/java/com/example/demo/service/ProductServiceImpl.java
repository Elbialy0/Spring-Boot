package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.productDAO.ProductDAO;
import com.example.demo.productDAO.ProductDAOImpl;
import com.example.demo.rest.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO1){
        productDAO=productDAO1;
    }
    @Override
    public List<Product> findAll() {
       return productDAO.findAll();
    }

    @Override
    @Transactional
    public Product addProduct(Product theProduct) {

     Product product= productDAO.addProduct(theProduct);
     return product;
    }

    @Override
    @Transactional
    public Product updateProduct(Product theProduct) {
     return productDAO.updateProduct(theProduct);
    }

    @Override
    public Product findProductById(int theId) {
       Product product =productDAO.findProductById(theId);
       if (product==null) {
           throw new ProductNotFoundException("not found",new RuntimeException());
       }
       return product;
    }

    @Override
    @Transactional
    public void deleteProductById(int theId) {
        Product product =productDAO.findProductById(theId);
        if (product==null) {
            throw new ProductNotFoundException("not found",new RuntimeException());
        }
        productDAO.deleteProductById(theId);

    }
}
