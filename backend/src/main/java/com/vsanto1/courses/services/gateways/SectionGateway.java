package com.vsanto1.courses.services.gateways;

import com.vsanto1.courses.dtos.SectionDTO;
import com.vsanto1.courses.models.Section;

import java.util.List;

public interface SectionGateway {

    Section findById(Long id);

    List<Section> findAll();

    Section execute(SectionDTO sectionDTO);

    Section update(Long id, SectionDTO sectionDTO);

    void deleteById(Long id);

}
