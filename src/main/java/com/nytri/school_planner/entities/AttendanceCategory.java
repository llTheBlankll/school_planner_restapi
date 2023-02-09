package com.nytri.school_planner.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance_category")
public class AttendanceCategory {
    @Id
    @Column(name = "attendance_category_id", nullable = false)
    private Integer id;

    @Column(name = "category_name", length = 128)
    private String categoryName;

    @Lob
    @Column(name = "category_description")
    private String categoryDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}