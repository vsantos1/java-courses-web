package com.vsanto1.courses.resources;

import com.vsanto1.courses.dtos.VideoDTO;
import com.vsanto1.courses.models.Video;
import com.vsanto1.courses.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class VideoResource {

    private final VideoService videoService;


    public VideoResource(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(value = "/videos")
    public ResponseEntity<List<Video>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.findAll());
    }

    @GetMapping(value = "/videos/{video_id}")
    public ResponseEntity<Video> getById(@PathVariable("video_id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.findById(id));
    }

    @GetMapping(value = "/videos/sections/{section_id}")
    public ResponseEntity<List<Video>> getVideosBySection(@PathVariable("section_id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.findVideosBySection(id));
    }

    @PostMapping(value = "/videos")
    public ResponseEntity<Video> create(@RequestBody @Valid VideoDTO videoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(videoService.execute(videoDTO));
    }

    @PutMapping(value = "/videos/{video_id}")
    public ResponseEntity<Video> update(@PathVariable("video_id") UUID id, @RequestBody @Valid VideoDTO videoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(videoService.update(id, videoDTO));
    }

    @DeleteMapping(value = "/videos/{video_id}")
    public ResponseEntity<Video> delete(@PathVariable("video_id") UUID id) {
        videoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
