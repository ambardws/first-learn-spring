package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.ResponeData;
import com.domain.models.entites.Product;
import com.domain.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponeData<Product>> create(@Valid @RequestBody Product product, Errors errors) {
        ResponeData<Product> responeData = new ResponeData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responeData.getMessages().add(error.getDefaultMessage());
            }
            responeData.setStatus(false);
            responeData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeData);
        }
        responeData.setStatus(true);
        responeData.setPayload(productService.save(product));
        return ResponseEntity.ok(responeData);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findaAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponeData<Product>> update(@Valid @RequestBody Product product, Errors errors) {
        ResponeData<Product> responeData = new ResponeData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responeData.getMessages().add(error.getDefaultMessage());
            }
            responeData.setStatus(false);
            responeData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeData);
        }
        responeData.setStatus(true);
        responeData.setPayload(productService.save(product));
        return ResponseEntity.ok(responeData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        productService.removeOne(id);
    }
}
