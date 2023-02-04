package com.vsanto1.courses.repositories;

import com.vsanto1.courses.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
