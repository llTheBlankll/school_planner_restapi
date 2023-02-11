package com.nytri.school_planner.controllers.Agenda;

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
    public List<AgendaHomeworkController> getAllAgendaHomeworks() {
        return this.agendaHomeworkRepository.findAll();
    }

    @GetMapping("/search/title/{title}")
    public List<AgendaHomework> searchByTitle(@PathVariable("title") String title) {
        return this.agendaHomeworkRepository.findByHomeworkTitleLikeIgnoreCaseAllIgnoreCase(title);
    }

}
