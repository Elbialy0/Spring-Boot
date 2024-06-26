package com.example.demo.productDAO;

import com.example.demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    EntityManager entityManager ;
    @Autowired
    public ProductDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("from Product ", Product.class);
        List<Product> products = typedQuery.getResultList();
        return products;
    }

    @Override
    public Product addProduct(Product theProduct) {
        theProduct.setId(0);
       entityManager.persist(theProduct);
       return theProduct;
    }

    @Override
    public Product updateProduct(Product theProduct) {
        Product product = entityManager.merge(theProduct);
        return product;

    }

    @Override
    public Product findProductById(int theId) {

        Product product =entityManager.find( Product.class,theId);
        if (product==null){

        }
        return product;
    }

    @Override
    public void deleteProductById(int theId) {
        entityManager.remove(entityManager.find(Product.class,theId));

    }
}
