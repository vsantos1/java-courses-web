package com.vsanto1.courses.resources;

import com.vsanto1.courses.dtos.SectionDTO;
import com.vsanto1.courses.models.Section;
import com.vsanto1.courses.services.SectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class SectionResource {

    private final SectionService sectionService;

    public SectionResource(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping(value = "/sections")
    public ResponseEntity<List<Section>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sectionService.findAll());
    }

    @GetMapping(value = "/sections/courses/{course_id}")
    public ResponseEntity<List<Section>> getSectionsByCourse(@PathVariable("course_id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(sectionService.findAllByCourseId(id));
    }

    @PostMapping(value = "/sections")
    public ResponseEntity<Section> create(@RequestBody @Valid SectionDTO sectionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.execute(sectionDTO));
    }

    @PutMapping(value = "/sections/{section_id}")
    public ResponseEntity<Section> update(@PathVariable("section_id") Long id, @RequestBody @Valid SectionDTO sectionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(sectionService.update(id, sectionDTO));
    }

    @DeleteMapping(value = "/sections/{section_id}")
    public ResponseEntity<Void> delete(@PathVariable("section_id") Long id) {
        sectionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
