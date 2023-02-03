package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.CourseDTO;
import com.vsanto1.courses.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CourseGateway {

    Course findById(UUID id);

    Page<Course> findAll(Pageable pageable);

    Course execute(CourseDTO courseDTO);

    Course update(UUID id, CourseDTO courseDTO);

    void deleteById(UUID id);
}
