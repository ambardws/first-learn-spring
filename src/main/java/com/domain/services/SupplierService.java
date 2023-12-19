package com.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entites.Supplier;
import com.domain.models.repos.SupplierRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier suplier) {
        return supplierRepo.save(suplier);
    }

    public Supplier findOne(Long id) {
        Optional<Supplier> suplier = supplierRepo.findById(id);
        if(!suplier.isPresent()) {
            return null;
        }
        return suplier.get();
    }

    public Iterable<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public void removeOne(Long id) {
        supplierRepo.deleteById(id);
    }



}
