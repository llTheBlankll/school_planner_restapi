package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AgendaQuizRepository extends JpaRepository<AgendaQuiz, Integer> {
    void deleteByQuizName(@NonNull String quizName);
    boolean existsByQuizName(@NonNull String quizName);
    List<AgendaQuiz> findByQuizSubject_SubjectNameIgnoreCase(@Nullable String subjectName);
    List<AgendaQuiz> findByQuizNameIgnoreCase(@Nullable String quizName);
}