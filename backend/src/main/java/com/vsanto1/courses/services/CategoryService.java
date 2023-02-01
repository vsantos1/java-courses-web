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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
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
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO execute(CategoryDTO categoryDTO) {
        Category category = mapper.map(categoryDTO, Category.class);
        categoryRepository.save(category);
        return mapper.map(category, CategoryDTO.class);

    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Category category = this.findById(id);
        mapper.map(categoryDTO, category);
        categoryRepository.save(category);

        return mapper.map(category, CategoryDTO.class);

    }

    @Override
    public void deleteById(Long id) {
        Category category = this.findById(id);
        categoryRepository.deleteById(category.getId());
    }
}
