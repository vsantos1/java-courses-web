package com.vsanto1.courses.configurations;

import com.vsanto1.courses.repositories.CourseRepository;
import com.vsanto1.courses.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    public CourseService courseServiceBean(ModelMapper mapper, CourseRepository courseRepository) {
        return new CourseService(mapper, courseRepository);
    }

}
