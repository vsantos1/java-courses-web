package com.vsanto1.courses.dtos;

import com.vsanto1.courses.enums.Language;
import com.vsanto1.courses.models.Category;

import java.util.Date;
import java.util.UUID;

public class CourseDTO {

    private UUID id;

    private String title;

    private String description;
    private String slug;

    private Double price;

    private String imageUrl;

    private Language language;

    private Date createdAt;

    private final Date updatedAt = new Date();

    private Category category;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSlug() {
        return slug;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Language getLanguage() {
        return language;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Category getCategory() {
        return category;
    }
}
