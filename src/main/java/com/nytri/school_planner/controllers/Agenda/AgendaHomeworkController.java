package com.nytri.school_planner.controllers.Agenda;

import com.nytri.school_planner.entities.AgendaHomework;
import com.nytri.school_planner.repositories.AgendaHomeworkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/agenda/homework")
public class AgendaHomeworkController {

    private final AgendaHomeworkRepository agendaHomeworkRepository;

    public AgendaHomeworkController(AgendaHomeworkRepository agendaHomeworkRepository) {
        this.agendaHomeworkRepository = agendaHomeworkRepository;
    }

    @GetMapping("/all")
    public List<AgendaHomework> getAllAgendaHomeworks() {
        return this.agendaHomeworkRepository.findAll();
    }

    @GetMapping("/search/title/{title}")
    public List<AgendaHomework> searchByTitle(@PathVariable("title") String title) {
        return this.agendaHomeworkRepository.findByHomeworkTitleLikeIgnoreCase(title);
    }

    @GetMapping("/search/subject/{subject}")
    public List<AgendaHomework> searchBySubject(@PathVariable("subject") String subject) {
        return this.agendaHomeworkRepository.findByHomeworkSubject_SubjectNameIgnoreCase(subject);
    }

    @DeleteMapping("/delete")
    public void deleteAgendaHomework(@RequestBody AgendaHomework agendaHomework) {
        if (this.agendaHomeworkRepository.existsById(agendaHomework.getId())) {
            this.agendaHomeworkRepository.delete(agendaHomework);
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        if (this.agendaHomeworkRepository.existsById(id.intValue())) {
            this.agendaHomeworkRepository.deleteById(id.intValue());
        }
    }

    @DeleteMapping("/delete/title/{title}")
    public void deleteByHomeworkTitle(@PathVariable("title") String title) {
        if (this.agendaHomeworkRepository.existsByHomeworkTitle(title)) {
            this.agendaHomeworkRepository.deleteByHomeworkTitle(title);
        }
    }

    @DeleteMapping("/delete/subject_name/{name}")
    public void deleteBySubjectName(@PathVariable("name") String name) {
        if (this.agendaHomeworkRepository.existsByHomeworkSubject_SubjectName(name)) {
            this.agendaHomeworkRepository.deleteByHomeworkSubject_SubjectName(name);
        }
    }

    @PutMapping("/add")
    public void addAgendaHomework(@RequestBody AgendaHomework agendaHomework) {
        if (!this.agendaHomeworkRepository.existsById(agendaHomework.getId())) {
            this.agendaHomeworkRepository.save(agendaHomework);
        }
    }

    @PutMapping("/update")
    public void updateAgendaHomework(@RequestBody AgendaHomework agendaHomework) {
        if (this.agendaHomeworkRepository.existsById(agendaHomework.getId())) {
            this.agendaHomeworkRepository.save(agendaHomework);
        }
    }
}
