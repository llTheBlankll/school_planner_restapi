package com.nytri.school_planner.controllers;

import com.nytri.school_planner.entities.Teacher;
import com.nytri.school_planner.repositories.TeacherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeacher() {
        return this.teacherRepository.findAll();
    }

    @GetMapping("/search/name/{name}")
    public List<Teacher> searchTeacherByName(@PathVariable("name") String name) {
        if (name.length() > 128) {
            return Collections.emptyList();
        }

        return (!name.equals("")) ? this.teacherRepository.findByTeacherNameLikeIgnoreCase(name) : Collections.emptyList();
    }

    @GetMapping("/search/surname/{surname}")
    public List<Teacher> searchTeacherBySurName(@PathVariable("surname") String surname) {
        if (surname.length() > 128) {
            return Collections.emptyList();
        }

        return (!surname.equals("")) ? this.teacherRepository.findByTeacherSurnameLikeIgnoreCase(surname) : Collections.emptyList();
    }

    @PutMapping("/add")
    public void addTeacher(@RequestBody Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @DeleteMapping("/delete")
    public void deleteTeacher(@RequestBody Teacher teacher) {
        this.teacherRepository.delete(teacher);
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteTeacherById(@PathVariable("id") Long id) {
        this.teacherRepository.deleteById(id.intValue());
    }

    @PutMapping("/update")
    public void updateTeacher(@RequestBody Teacher teacher) {
        this.teacherRepository.save(teacher);
    }
}
