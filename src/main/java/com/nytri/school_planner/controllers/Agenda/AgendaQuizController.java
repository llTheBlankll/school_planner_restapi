package com.nytri.school_planner.controllers.Agenda;

import com.nytri.school_planner.entities.AgendaQuiz;
import com.nytri.school_planner.repositories.AgendaQuizRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/api/agenda/quiz")
@CrossOrigin
public class AgendaQuizController {

    private final AgendaQuizRepository agendaQuizRepository;

    public AgendaQuizController(AgendaQuizRepository agendaQuizRepositoryn) {
        this.agendaQuizRepository = agendaQuizRepositoryn;
    }

    @GetMapping("/all")
    public List<AgendaQuiz> getAllAgendaQuiz() {
        return this.agendaQuizRepository.findAll();
    }
    @GetMapping("/search/title/{title}")
    public List<AgendaQuiz> searchByTitle(@PathVariable("title") String title) {
        return this.agendaQuizRepository.findByQuizNameIgnoreCase(title);
    }

    @GetMapping("/search/subject/{subject}")
    public List<AgendaQuiz> searchBySubjectName(@PathVariable("subject") String subject) {
        return this.agendaQuizRepository.findByQuizSubject_SubjectNameIgnoreCase(subject);
    }

    @PutMapping("/add")
    public void addAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (!this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
            this.agendaQuizRepository.save(agendaQuiz);
        }
    }

    @PutMapping("/update")
    public void updateAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
            this.agendaQuizRepository.save(agendaQuiz);
        }
    }

    @DeleteMapping("/delete")
    public void deleteAgendaQuiz(@RequestBody AgendaQuiz agendaQuiz) {
        if (this.agendaQuizRepository.existsById(agendaQuiz.getId())) {
            this.agendaQuizRepository.delete(agendaQuiz);
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteAgendaQuizById(@PathVariable("id") Long id) {
        if (this.agendaQuizRepository.existsById(id.intValue())) {
            this.agendaQuizRepository.deleteById(id.intValue());
        }
    }
}
