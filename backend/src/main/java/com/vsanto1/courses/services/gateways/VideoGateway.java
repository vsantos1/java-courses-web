package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.VideoDTO;
import com.vsanto1.courses.models.Video;

import java.util.List;
import java.util.UUID;

public interface VideoGateway {

    Video findById(UUID id);

    List<Video> findAll();

    List<Video> findVideosBySection(Long sectionId);

    Video execute(VideoDTO videoDTO);

    Video update(UUID id, VideoDTO videoDTO);

    void deleteById(UUID id);
}
