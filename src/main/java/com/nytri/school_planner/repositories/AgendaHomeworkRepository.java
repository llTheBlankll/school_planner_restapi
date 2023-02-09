package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaHomework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaHomeworkRepository extends JpaRepository<AgendaHomework, Integer> {
}