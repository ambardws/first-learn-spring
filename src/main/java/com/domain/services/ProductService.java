package com.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entites.Product;
import com.domain.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        return productRepo.save(product);
    }

    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findaAll() {
        return productRepo.findAll();
    }

    public void removeOne(long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findbyName(String name) {
        return productRepo.findByNameContains((name));
    }
}
