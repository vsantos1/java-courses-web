package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SectionRepository extends JpaRepository<Section, Long> {

    List<Section> findSectionsByCourse_Id(UUID id);
}
