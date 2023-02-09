package com.nytri.school_planner.controllers;

import com.nytri.school_planner.entities.Attendance;
import com.nytri.school_planner.repositories.AttendanceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@RequestMapping("/api/attendance")
@CrossOrigin
@RestController
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return this.attendanceRepository.findAll();
    }

}
