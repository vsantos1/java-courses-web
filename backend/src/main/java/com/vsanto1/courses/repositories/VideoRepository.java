package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {

    List<Video> findVideosBySection_Id(Long sectionId);
}
