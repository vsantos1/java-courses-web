package com.vsanto1.courses.dtos;

import com.vsanto1.courses.models.Course;
import jakarta.validation.constraints.Max;

import java.util.List;

public class SectionDTO {

    private String title;

    @Max(value = 20)
    private Integer number;

    private Course course;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
