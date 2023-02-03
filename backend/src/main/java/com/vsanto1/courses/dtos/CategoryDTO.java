package com.vsanto1.courses.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsanto1.courses.models.Course;

import java.util.List;

public class CategoryDTO {

    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
