package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
