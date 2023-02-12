package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AgendaQuizRepository extends JpaRepository<AgendaQuiz, Integer> {
    List<AgendaQuiz> findByQuizSubject_SubjectNameIgnoreCase(@Nullable String subjectName);
    List<AgendaQuiz> findByQuizNameIgnoreCase(@Nullable String quizName);
}