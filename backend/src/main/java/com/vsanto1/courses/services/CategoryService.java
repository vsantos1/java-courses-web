package com.vsanto1.courses.services;

import com.vsanto1.courses.configurations.MapperConfig;
import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.models.Category;
import com.vsanto1.courses.repositories.CategoryRepository;
import com.vsanto1.courses.services.gateways.CategoryGateway;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CategoryService implements CategoryGateway {

    private final ModelMapper mapper;
    private final CategoryRepository categoryRepository;

    public CategoryService(ModelMapper mapper, CategoryRepository categoryRepository) {
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new ResourceNotFoundException("Category not found");
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category execute(CategoryDTO categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return category;

    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category category = this.findById(id);
        mapper.map(categoryDTO, category);
        categoryRepository.save(category);

        return category;

    }

    @Override
    public void deleteById(Long id) {
        Category category = this.findById(id);
        categoryRepository.deleteById(category.getId());
    }
}
