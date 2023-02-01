package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.models.Category;

import java.util.List;

public interface CategoryGateway {

    Category findById(Long id);

    List<CategoryDTO> findAll();

    CategoryDTO execute(CategoryDTO categoryDTO);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    void deleteById(Long id);
}
