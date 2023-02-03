package com.vsanto1.courses.resources;

import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.models.Category;
import com.vsanto1.courses.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }


    @PostMapping(value = "/categories")
    public ResponseEntity<Category> create(@RequestBody @Valid CategoryDTO categoryDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.execute(categoryDTO));
    }

    @PutMapping(value = "/categories/{category_id}")
    public ResponseEntity<Category> update(@PathVariable("category_id") Long id, @RequestBody @Valid CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(id, categoryDTO));
    }

    @DeleteMapping(value = "/categories/{category_id}")
    public ResponseEntity<Void> delete(@PathVariable("category_id") Long id) {

        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }
}
