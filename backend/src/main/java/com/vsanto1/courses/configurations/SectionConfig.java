package com.vsanto1.courses.configurations;

import com.vsanto1.courses.repositories.SectionRepository;
import com.vsanto1.courses.services.CourseService;
import com.vsanto1.courses.services.SectionService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SectionConfig {

    @Bean
    public SectionService sectionServiceBean(ModelMapper mapper, SectionRepository sectionRepository, CourseService courseService) {
        return new SectionService(mapper, sectionRepository, courseService);
    }
}
