package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AgendaReminderRepository extends JpaRepository<AgendaReminder, Integer> {
    void deleteByReminderName(@NonNull String reminderName);
    boolean existsByReminderName(@Nullable String reminderName);
    List<AgendaReminder> findByReminderNameLikeIgnoreCase(@NonNull String reminderName);
}