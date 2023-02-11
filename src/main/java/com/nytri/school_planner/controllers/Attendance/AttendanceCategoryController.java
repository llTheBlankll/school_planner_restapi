package com.nytri.school_planner.controllers.Attendance;

import com.nytri.school_planner.entities.AttendanceCategory;
import com.nytri.school_planner.repositories.AttendanceCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance/category")
public class AttendanceCategoryController {

    private final AttendanceCategoryRepository attendanceCategoryRepository;

    public AttendanceCategoryController(AttendanceCategoryRepository attendanceCategoryRepository) {
        this.attendanceCategoryRepository = attendanceCategoryRepository;
    }

    @GetMapping("/all")
    public List<AttendanceCategory> getAllAttendanceCategory() {
        return this.attendanceCategoryRepository.findAll();
    }

    @GetMapping("/search/name/{name}")
    public List<AttendanceCategory> searchAttendanceCategoryByName(@PathVariable("name") String name) {
        return this.attendanceCategoryRepository.findByCategoryNameContainsIgnoreCase(name);
    }

    @DeleteMapping("/delete")
    public void deleteAttendanceCategory(@RequestBody AttendanceCategory attendanceCategory) {
        this.attendanceCategoryRepository.delete(attendanceCategory);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteAttendanceCategoryById(@PathVariable("id") Long id) {
        if (this.attendanceCategoryRepository.existsById(id.intValue())) {
            this.attendanceCategoryRepository.deleteById(id.intValue());
        }
    }

    @PutMapping("/add")
    public void addAttendanceCategory(@RequestBody AttendanceCategory attendanceCategory) {
        if (!this.attendanceCategoryRepository.existsById(attendanceCategory.getId())) {
            this.attendanceCategoryRepository.save(attendanceCategory);
        }
    }

    @PutMapping("/update")
    public void updateAttendanceCategory(@RequestBody AttendanceCategory attendanceCategory) {
        if (this.attendanceCategoryRepository.existsById(attendanceCategory.getId())) {
            this.attendanceCategoryRepository.save(attendanceCategory);
        }
    }
}
