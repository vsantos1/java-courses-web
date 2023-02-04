package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    Optional<Course> findCourseBySlug(String slug);

    Page<Course> findCoursesByCategory_Name(Pageable pageable,String categoryName);
}
