package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public interface AgendaHomeworkRepository extends JpaRepository<AgendaHomework, Integer> {
    @NonNull
    AgendaHomework findByHomeworkTitleLikeIgnoreCaseAllIgnoreCase(@NonNull String homeworkTitle);
}