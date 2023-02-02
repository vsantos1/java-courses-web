package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.CategoryDTO;
import com.vsanto1.courses.dtos.CourseDTO;
import com.vsanto1.courses.models.Category;
import com.vsanto1.courses.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CourseGateway {

    Course findById(Long id);

    Page<CourseDTO> findAll(Pageable pageable);

    CourseDTO execute(CourseDTO courseDTO);

    CourseDTO update(UUID id, CourseDTO courseDTO);

    void deleteById(Long id);
}
