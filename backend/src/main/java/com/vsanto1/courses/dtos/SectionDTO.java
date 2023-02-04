package com.vsanto1.courses.dtos;

import jakarta.validation.constraints.Max;

public class SectionDTO {

    private String title;

    @Max(value = 20)
    private Integer number;

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
}
