package com.vsanto1.courses.services;

import com.vsanto1.courses.dtos.SectionDTO;
import com.vsanto1.courses.exceptions.ResourceNotFoundException;
import com.vsanto1.courses.models.Section;
import com.vsanto1.courses.repositories.SectionRepository;
import com.vsanto1.courses.services.gateways.SectionGateway;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SectionService implements SectionGateway {


    private final ModelMapper mapper;
    private final SectionRepository sectionRepository;

    public SectionService(ModelMapper mapper, SectionRepository sectionRepository) {
        this.mapper = mapper;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section findById(Long id) {
        Optional<Section> section = sectionRepository.findById(id);

        if (section.isPresent()) {
            return section.get();
        }
        throw new ResourceNotFoundException("Section not found");
    }

    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Section execute(SectionDTO sectionDTO) {
        Section section = new Section();

        mapper.map(sectionDTO, section);

        sectionRepository.save(section);
        return section;
    }

    @Override
    public Section update(Long id, SectionDTO sectionDTO) {
        Section section = this.findById(id);

        mapper.map(sectionDTO, section);

        return sectionRepository.save(section);
    }

    @Override
    public void deleteById(Long id) {

        Section section = this.findById(id);

        sectionRepository.deleteById(section.getId());
    }
}
