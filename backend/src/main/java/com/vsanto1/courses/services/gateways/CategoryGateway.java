package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.models.Category;

import java.util.List;

public interface CategoryGateway {

    Category findById(Long id);

    List<Category> findAll();

    Category execute(CategoryDTO categoryDTO);

    Category update(Long id, CategoryDTO categoryDTO);

    void deleteById(Long id);
}
