package com.domain.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entites.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    
}
