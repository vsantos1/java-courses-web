package com.vsanto1.courses.services;

import com.github.slugify.Slugify;
import com.vsanto1.courses.dtos.CourseDTO;
import com.vsanto1.courses.models.Category;
import com.vsanto1.courses.models.Course;
import com.vsanto1.courses.repositories.CourseRepository;
import com.vsanto1.courses.services.gateways.CourseGateway;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

public class CourseService implements CourseGateway {

    private final ModelMapper mapper;
    private final CourseRepository courseRepository;

    private final CategoryService categoryService;

    public CourseService(ModelMapper mapper, CourseRepository courseRepository, CategoryService categoryService) {
        this.mapper = mapper;
        this.courseRepository = courseRepository;
        this.categoryService = categoryService;
    }

    public Course findBySlug(String slug) {
        Optional<Course> course = courseRepository.findCourseBySlug(slug);
        if (course.isPresent()) {
            return course.get();

        }
        throw new ResourceNotFoundException("Slug not found");
    }

    @Override
    public Course findById(UUID id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        }

        // TODO: Create custom exception for this

        throw new ResourceNotFoundException("Course not found");
    }

    public String generateSlug(String title) {
        final Slugify slug = Slugify.builder().locale(Locale.ENGLISH).build();

        return slug.slugify(title);

    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course execute(CourseDTO courseDTO) {

        try {
            String slug = generateSlug(courseDTO.getTitle());

            this.categoryService.findById(courseDTO.getCategory().getId());
            Course course = new Course();
            courseDTO.setCreatedAt(new Date());
            courseDTO.setSlug(slug);
            mapper.map(courseDTO, course);
            courseRepository.save(course);
            return course;
        } catch (DataIntegrityViolationException ex) {
            // TODO: Create custom exception for this
            throw new RuntimeException("Slug already exists");
        }


    }

    @Override
    public Course update(UUID id, CourseDTO courseDTO) {

        try {
            String slug = generateSlug(courseDTO.getTitle());
            Course course = this.findById(id);
            courseDTO.setSlug(slug);

            courseDTO.setUpdatedAt(new Date());
            mapper.map(courseDTO, course);
            courseRepository.save(course);
            return course;
        } catch (DataIntegrityViolationException ex) {
            // TODO: Create custom exception for this

            throw new RuntimeException("Slug already exists");
        }


    }

    @Override
    public void deleteById(UUID id) {
        Course course = this.findById(id);
        courseRepository.deleteById(course.getId());
    }
}
