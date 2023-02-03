package com.vsanto1.courses.resources;

import com.vsanto1.courses.dtos.CourseDTO;
import com.vsanto1.courses.models.Course;
import com.vsanto1.courses.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class CourseResource {

    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<Page<Course>> getAllPaginated(@PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll(pageable));
    }

    @GetMapping(value = "/courses/{slug}")
    public ResponseEntity<Course> getBySlug(@PathVariable("slug") String slug) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findBySlug(slug));
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> create(@RequestBody @Valid CourseDTO courseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.execute(courseDTO));
    }

    @PutMapping(value = "/courses/{course_id}")
    public ResponseEntity<Course> update(@PathVariable("course_id") UUID id, @RequestBody @Valid CourseDTO courseDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update(id, courseDTO));
    }

    @DeleteMapping(value = "/courses/{course_id}")
    public ResponseEntity<Void> delete(@PathVariable("course_id") UUID id) {
        courseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
