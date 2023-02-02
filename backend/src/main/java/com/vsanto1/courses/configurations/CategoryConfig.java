package com.vsanto1.courses.configurations;

import com.vsanto1.courses.repositories.CategoryRepository;
import com.vsanto1.courses.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryService categoryServiceBean(CategoryRepository categoryRepository, ModelMapper mapper) {
        return new CategoryService(mapper, categoryRepository);
    }
}
