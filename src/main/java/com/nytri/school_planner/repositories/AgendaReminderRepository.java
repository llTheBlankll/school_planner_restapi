package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaReminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaReminderRepository extends JpaRepository<AgendaReminder, Integer> {
}