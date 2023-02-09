package com.nytri.school_planner.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @Column(name = "attendance_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_category")
    private AttendanceCategory attendanceCategory;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Column(name = "attendance_time", nullable = false)
    private LocalTime attendanceTime;

    @Column(name = "attendance_excuse")
    private Boolean attendanceExcuse;

    @Lob
    @Column(name = "attendance_remarks")
    private String attendanceRemarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AttendanceCategory getAttendanceCategory() {
        return attendanceCategory;
    }

    public void setAttendanceCategory(AttendanceCategory attendanceCategory) {
        this.attendanceCategory = attendanceCategory;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public LocalTime getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(LocalTime attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Boolean getAttendanceExcuse() {
        return attendanceExcuse;
    }

    public void setAttendanceExcuse(Boolean attendanceExcuse) {
        this.attendanceExcuse = attendanceExcuse;
    }

    public String getAttendanceRemarks() {
        return attendanceRemarks;
    }

    public void setAttendanceRemarks(String attendanceRemarks) {
        this.attendanceRemarks = attendanceRemarks;
    }

}