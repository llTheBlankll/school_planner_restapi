package com.nytri.school_planner.controllers;

import com.nytri.school_planner.entities.Attendance;
import com.nytri.school_planner.repositories.AttendanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RequestMapping("/api/attendance")
@CrossOrigin
@RestController
public class AttendanceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AttendanceRepository attendanceRepository;

    private Boolean validateAttendance(Attendance attendance) {
        if (attendance.getAttendanceRemarks().length() >= 65536) {
            return false;
        }

        return true;
    }

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return this.attendanceRepository.findAll();
    }

    @PutMapping("/merge")
    public void saveAttendance(@RequestBody Attendance attendance) {
        if (validateAttendance(attendance)) {
            logger.debug("Attendance added " + attendance.getAttendanceCategory().getCategoryName());
            this.attendanceRepository.save(attendance);
        }
    }

    @DeleteMapping("/delete")
    public void deleteAttendance(@RequestBody Attendance attendance) {
        logger.debug("Attendance deleted " + attendance.getAttendanceCategory().getCategoryName());
        this.attendanceRepository.delete(attendance);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttendanceById(@PathVariable("id") Integer id) {
        logger.debug("Attendance with ID " + id + " was successfully deleted.");
        this.attendanceRepository.deleteById(id);
    }
}
