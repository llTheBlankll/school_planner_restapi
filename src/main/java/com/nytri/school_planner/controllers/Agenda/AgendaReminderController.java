package com.nytri.school_planner.controllers.Agenda;

import com.nytri.school_planner.entities.AgendaReminder;
import com.nytri.school_planner.repositories.AgendaReminderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/agenda/reminder")
@CrossOrigin
public class AgendaReminderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AgendaReminderRepository agendaReminderRepository;

    private boolean validateAgendaReminder(AgendaReminder agendaReminder) {
        if (agendaReminder.getReminderName().length() > 128) {
            logger.debug("Agenda Reminder Name is too long.");
            return false;
        }

        if (agendaReminder.getReminderColor().length() > 48) {
            logger.debug("Agenda Reminder Color is too long.");
            return false;
        }

        if (agendaReminder.getReminderNote().length() > 65535) {
            logger.debug("Agenda Note is too long.");
            return false;
        }

        return true;
    }

    public AgendaReminderController(AgendaReminderRepository agendaReminderRepository) {
        this.agendaReminderRepository = agendaReminderRepository;
    }

    @GetMapping("/all")
    public List<AgendaReminder> getAllReminder() {
        return this.agendaReminderRepository.findAll();
    }

    @GetMapping("/search/{name}")
    public List<AgendaReminder> searchByName(@PathVariable("name") String name) {
        if (name.length() > 128) {
            logger.debug("Name provided is too long.");
            return Collections.emptyList();
        }

        return this.agendaReminderRepository.findByReminderNameLikeIgnoreCase(name);
    }

    @PutMapping("/add")
    public void addReminder(@RequestBody AgendaReminder agendaReminder) {
        if (validateAgendaReminder(agendaReminder)) {
            if (!this.agendaReminderRepository.existsById(agendaReminder.getId())) {
                this.agendaReminderRepository.save(agendaReminder);
            }
        }
    }

    @PutMapping("/update")
    public void updateReminder(@RequestBody AgendaReminder agendaReminder) {
        if (validateAgendaReminder(agendaReminder)) {
            if (this.agendaReminderRepository.existsById(agendaReminder.getId())) {
                this.agendaReminderRepository.save(agendaReminder);
            }
        }
    }

    @DeleteMapping("/delete")
    public void deleteReminder(@RequestBody AgendaReminder agendaReminder) {
        if (validateAgendaReminder(agendaReminder)) {
            if (this.agendaReminderRepository.existsById(agendaReminder.getId())) {
                this.agendaReminderRepository.delete(agendaReminder);
            }
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public void deleteReminderById(@PathVariable("id") Long id) {
        if (id > Integer.MAX_VALUE) {
            logger.debug("ID value is TOO HIGH");
            return;
        }

        if (this.agendaReminderRepository.existsById(id.intValue())) {
            this.agendaReminderRepository.deleteById(id.intValue());
        }
    }

    @DeleteMapping("/delete/name/{name}")
    public void deleteReminderByName(@PathVariable("name") String name) {
        if (name.length() > 128) {
            logger.warn("Name exceeds 128 characters.");
            return;
        }

        if (this.agendaReminderRepository.existsByReminderName(name)) {
            this.agendaReminderRepository.deleteByReminderName(name);
        }
    }
}
