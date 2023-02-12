package com.nytri.school_planner.controllers.Agenda;

import com.nytri.school_planner.entities.AgendaQuiz;
import com.nytri.school_planner.repositories.AgendaQuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/agenda/quiz")
@CrossOrigin
public class AgendaQuizController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AgendaQuizRepository agendaQuizRepository;

    public AgendaQuizController(AgendaQuizRepository agendaQuizRepository) {
        this.agendaQuizRepository = agendaQuizRepository;
    }

    private boolean validateQuiz(AgendaQuiz agendaQuiz) {
        if (agendaQuiz.getQuizName().length() > 128) {
            logger.debug("Quiz Name is too long.");
            return false;
        }

        if (agendaQuiz.getQuizSubject().getSubjectName().length() > 128) {
            logger.debug("Quiz Subject Name is too long.");
            return false;
        }

        if (agendaQuiz.getQuizColor().length() > 48) {
            logger.debug("Quiz Color is too long.");
            return false;
        }

        return true;
    }

    @GetMapping("/all")
    public List<AgendaQuiz> getAllAgendaQuiz() {
        return this.agendaQuizRepository.findAll();
    }
    @GetMapping("/search/title/{title}")
    public List<AgendaQuiz> searchByTitle(@PathVariable("title") String title) {
        if (title.length() > 128) {
            logger.debug("Quiz Title is too long.");
            return Collections.emptyList();
        }

        return this.agendaQuizRepository.findByQuizNameIgnoreCase(title);
    }

    @GetMapping("/search/subject/{subject}")
    public List<AgendaQuiz> searchBySubjectName(@PathVariable("subject") String subject) {
        if (subject.length() > 128) {
            logger.debug("Quiz Subject Name is too long.");
            return Collections.emptyList();
        }

        return this.agendaQuizRepository.findByQuizSubject_SubjectNameIgnoreCase(subject);
    }

    @PutMapping("/add")
    public void addAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (validateQuiz(agendaQuiz)) {
            if (!this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
                this.agendaQuizRepository.save(agendaQuiz);
            }
        }

    }

    @PutMapping("/update")
    public void updateAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (validateQuiz(agendaQuiz)) {
            if (this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
                this.agendaQuizRepository.save(agendaQuiz);
            }
        }
    }

    @DeleteMapping("/delete")
    public void deleteAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (validateQuiz(agendaQuiz)) {
            if (this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
                this.agendaQuizRepository.delete(agendaQuiz);
            }
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteAgendaQuizById(@PathVariable("id") Long id) {
        if (this.agendaQuizRepository.existsById(id.intValue())) {
            this.agendaQuizRepository.deleteById(id.intValue());
        }
    }

    @DeleteMapping("/delete/name/{name}")
    public void deleteAgendaQuizByName(@PathVariable("name") String name) {
        if (this.agendaQuizRepository.existsByQuizName(name)) {
            this.agendaQuizRepository.deleteByQuizName(name);
        }
    }
}
