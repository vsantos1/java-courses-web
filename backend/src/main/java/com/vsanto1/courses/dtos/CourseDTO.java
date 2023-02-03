package com.vsanto1.courses.dtos;

import com.vsanto1.courses.enums.Language;
import com.vsanto1.courses.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public class CourseDTO {

    private UUID id;

    @NotNull
    private String title;

    private String slug;
    private String description;

    private Double price;

    private String imageUrl;

    private Language language;

    private Date createdAt;

    private Date updatedAt;

    private Category category;


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }


    public String getDescription() {
        return description;
    }


    public Double getPrice() {
        return price;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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


    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
