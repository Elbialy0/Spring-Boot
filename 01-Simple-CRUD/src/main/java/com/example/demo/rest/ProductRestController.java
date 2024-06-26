package com.example.demo.rest;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductRestController {
    ProductService productService;
    public ProductRestController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/products")
    public List<Product> findProducts(){
        return  productService.findAll();
    }
    @GetMapping("/products/{productId}")
    public Product findProduct(@PathVariable int productId){
        return productService.findProductById(productId);
    }
    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productService.addProduct(product);
    }
     @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable int productId){
        productService.deleteProductById(productId);
     }

}
