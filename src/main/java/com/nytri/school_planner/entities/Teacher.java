package com.nytri.school_planner.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id", nullable = false)
    private Integer id;

    @Column(name = "teacher_name", nullable = false, length = 128)
    private String teacherName;

    @Column(name = "teacher_surname", length = 128)
    private String teacherSurname;

    @Column(name = "teacher_email", length = 128)
    private String teacherEmail;

    @Column(name = "teacher_phone", length = 128)
    private String teacherPhone;

    @Column(name = "teacher_website", length = 128)
    private String teacherWebsite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherWebsite() {
        return teacherWebsite;
    }

    public void setTeacherWebsite(String teacherWebsite) {
        this.teacherWebsite = teacherWebsite;
    }

}