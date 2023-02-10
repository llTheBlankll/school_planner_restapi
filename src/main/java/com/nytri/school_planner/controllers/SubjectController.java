package com.nytri.school_planner.controllers;

import com.nytri.school_planner.entities.Subject;
import com.nytri.school_planner.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/subject")
public class SubjectController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return this.subjectRepository.findAll();
    }

    @GetMapping("/search")
    public List<Subject> findSubjectsByName(@RequestParam("search") String search, @RequestParam("type") String type) {
        type = (type.equals("")) ? "name" : type;

        if (search.length() > 128) {
            logger.debug("Search query is too long.");
            return Collections.emptyList();
        }

        if (search.length() == 0) {
            logger.debug("Search query is empty.");
            return Collections.emptyList();
        }

        if (type.equals("name")) {
            return this.subjectRepository.findBySubjectNameContainsIgnoreCase(search);
        }

        if (type.equals("color")) {
            return this.subjectRepository.findBySubjectColorIgnoreCase(search);
        }

        if (type.equals("room name")) {
            return this.subjectRepository.findBySubjectRoom_RoomNameIgnoreCase(search);
        }

        return this.subjectRepository.findBySubjectNameContainsIgnoreCase(search);
    }

    @PutMapping("/merge")
    public void mergeSubject(@RequestBody Subject subject) {
        this.subjectRepository.save(subject);
    }

    @DeleteMapping("/delete")
    public void deleteSubject(@RequestBody Subject subject) {
        this.subjectRepository.delete(subject);
    }

    @DeleteMapping("/delete")
    public void deleteSubjectById(@RequestParam("id") Long id) {
        this.subjectRepository.deleteById(id.intValue());
    }
}
