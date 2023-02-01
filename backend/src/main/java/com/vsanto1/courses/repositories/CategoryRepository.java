package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
