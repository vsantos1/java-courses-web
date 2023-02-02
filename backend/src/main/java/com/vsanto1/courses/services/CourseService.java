package com.vsanto1.courses.services;

import com.vsanto1.courses.dtos.CourseDTO;
import com.vsanto1.courses.models.Course;
import com.vsanto1.courses.repositories.CourseRepository;
import com.vsanto1.courses.services.gateways.CourseGateway;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class CourseService implements CourseGateway {

    private final ModelMapper mapper;
    private final CourseRepository courseRepository;

    public CourseService(ModelMapper mapper, CourseRepository courseRepository) {
        this.mapper = mapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    @Override
    public Page<CourseDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CourseDTO execute(CourseDTO courseDTO) {
        return null;
    }

    @Override
    public CourseDTO update(UUID id, CourseDTO courseDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
