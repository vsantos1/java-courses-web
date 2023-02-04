package com.vsanto1.courses.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_sections")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer number;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
