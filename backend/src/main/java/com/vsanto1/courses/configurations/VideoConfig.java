package com.vsanto1.courses.configurations;

import com.vsanto1.courses.repositories.VideoRepository;
import com.vsanto1.courses.services.SectionService;
import com.vsanto1.courses.services.VideoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoConfig {

    @Bean
    public VideoService videoServiceBean(ModelMapper mapper, SectionService sectionService, VideoRepository videoRepository) {
        return new VideoService(mapper, sectionService, videoRepository);
    }
}
