package com.vsanto1.courses.dtos;

import com.vsanto1.courses.models.Section;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class VideoDTO {

    private String videoUrl;

    private Double length;


    private Section section;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
