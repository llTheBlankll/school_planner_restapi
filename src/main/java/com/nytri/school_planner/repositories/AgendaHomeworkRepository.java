package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AgendaHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AgendaHomeworkRepository extends JpaRepository<AgendaHomework, Integer> {
    void deleteByHomeworkSubject_SubjectName(@NonNull String subjectName);
    boolean existsByHomeworkSubject_SubjectName(String subjectName);
    void deleteByHomeworkTitle(String homeworkTitle);
    boolean existsByHomeworkTitle(String homeworkTitle);
    List<AgendaHomework> findByHomeworkSubject_SubjectNameIgnoreCase(@NonNull String subjectName);
    List<AgendaHomework> findByHomeworkTitleLikeIgnoreCase(@NonNull String homeworkTitle);
}