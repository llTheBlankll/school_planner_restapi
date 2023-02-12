package com.nytri.school_planner.controllers.Agenda;

import com.nytri.school_planner.repositories.AgendaReminderRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agenda/reminder")
@CrossOrigin
public class AgendaReminderController {

    private final AgendaReminderRepository agendaReminderRepository;

    public AgendaReminderController(AgendaReminderRepository agendaReminderRepository) {
        this.agendaReminderRepository = agendaReminderRepository;
    }
}
