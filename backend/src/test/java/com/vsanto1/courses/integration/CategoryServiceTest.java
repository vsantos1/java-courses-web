package com.vsanto1.courses.integration;

import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.exceptions.ResourceNotFoundException;
import com.vsanto1.courses.models.Category;
import com.vsanto1.courses.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    @DisplayName("Should return an object because te entity is valid")
    public void whenGivenCategoryShouldReturnAnEntity() {
        CategoryDTO category = new CategoryDTO();
        category.setName("Development");
        Category saved = categoryService.execute(category);
        Assertions.assertNotNull(saved.getId());

    }

    @Test
    @DisplayName("Should return an entity exception if not found")
    public void whenGivenIdShouldReturnAnException() {
        Long givenId = 10000L;


        Assertions.assertThrows(ResourceNotFoundException.class, () -> categoryService.findById(givenId));
    }

    @Test
    @DisplayName("Should return an CategoryDTO because exists")
    public void shouldSaveTheEntity() {
        Long givenId = 1L;

        Category category = categoryService.findById(givenId);
        Assertions.assertNotNull(category);
    }

    @Test
    @DisplayName("Should update the existing entity")
    public void shouldUpdateTheEntity() {
        Long givenId = 1L;
        String givenName = "Business";

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(givenName);

        Category saved = categoryService.update(givenId, categoryDTO);

        Assertions.assertEquals(saved.getName(), givenName);

    }

    @Test
    @DisplayName("Should throw exception because the id doesnt exists")
    public void shouldThrowAnException() {
        Long givenId = 123456789L;

        Assertions.assertThrows(ResourceNotFoundException.class, () -> categoryService.deleteById(givenId));
    }
}
