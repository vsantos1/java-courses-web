package com.vsanto1.courses.services;

import com.vsanto1.courses.dtos.VideoDTO;
import com.vsanto1.courses.exceptions.ResourceNotFoundException;
import com.vsanto1.courses.models.Section;
import com.vsanto1.courses.models.Video;
import com.vsanto1.courses.repositories.VideoRepository;
import com.vsanto1.courses.services.gateways.VideoGateway;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VideoService implements VideoGateway {

    private final ModelMapper mapper;
    private final SectionService sectionService;
    private final VideoRepository videoRepository;

    public VideoService(ModelMapper mapper, SectionService sectionService, VideoRepository videoRepository) {
        this.mapper = mapper;
        this.sectionService = sectionService;
        this.videoRepository = videoRepository;
    }


    @Override
    public Video findById(UUID id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent())
            return video.get();
        throw new ResourceNotFoundException("Video not found");

    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public List<Video> findVideosBySection(Long sectionId) {
        return videoRepository.findVideosBySection_Id(sectionId);
    }

    @Override
    public Video execute(VideoDTO videoDTO) {
        sectionService.findById(videoDTO.getSection().getId());
        Video video = new Video();

        mapper.map(videoDTO, video);

        return video;


    }

    @Override
    public Video update(UUID id, VideoDTO videoDTO) {
        Video video = this.findById(id);

        videoDTO.setSection(video.getSection());
        mapper.map(videoDTO, video);

        return video;

    }

    @Override
    public void deleteById(UUID id) {

        Video video = this.findById(id);
        videoRepository.deleteById(video.getId());
    }
}
