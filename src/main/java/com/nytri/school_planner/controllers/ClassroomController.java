package com.nytri.school_planner.controllers;

import com.nytri.school_planner.entities.Classroom;
import com.nytri.school_planner.repositories.ClassroomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/api/classroom")
@CrossOrigin
@RestController
public class ClassroomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ClassroomRepository classroomRepository;

    public ClassroomController(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @GetMapping("/all")
    public List<Classroom> getAllClassrooms() {
        return this.classroomRepository.findAll();
    }

    @GetMapping("/search")
    public List<Classroom> searchClassroom_by(@RequestParam("by") String by, @RequestParam("value") String value) {
        if (by.length() > 128 || value.length() > 128) {
            return Collections.emptyList();
        }

        if (by.equals("name")) {
            return this.classroomRepository.findByRoomNameContains(value);
        } else if (by.equals("level")) {
            return this.classroomRepository.findByRoomLevelContains(value);
        }

        return Collections.emptyList();
    }

    @PutMapping("/merge")
    public boolean addClassroom(@RequestBody Classroom classroom) {
        if (this.classroomRepository.existsByRoomName(classroom.getRoomName())) {
            logger.debug("Classroom with name " + classroom.getRoomName() + " already exists.");
            return false;
        }

        this.classroomRepository.save(classroom);

        return true;
    }

    @DeleteMapping("/delete")
    public void deleteClassroom(@RequestBody Classroom classroom) {
        logger.debug("Classroom " + classroom.getRoomName() + " was deleted successfully.");
        this.classroomRepository.delete(classroom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassroomById(@PathVariable("id") Long id) {
        logger.debug("Classroom with ID " + id + " was successfully deleted!");
        this.classroomRepository.deleteById(id.intValue());
    }
}
