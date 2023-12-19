package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.ResponeData;
import com.domain.dto.SupplierData;
import com.domain.models.entites.Supplier;
import com.domain.services.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;

    public ResponseEntity<ResponeData<Supplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors) {

        ResponeData<Supplier> responeData = new ResponeData<>();
        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responeData.getMessages().add(error.getDefaultMessage());
            }
            responeData.setStatus(false);
            responeData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responeData);
        }
        supplierService.save()

    }

}
