package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findBySubjectRoom_RoomNameIgnoreCase(String roomName);
    List<Subject> findBySubjectColorIgnoreCase(@NonNull String subjectColor);
    List<Subject> findBySubjectNameContainsIgnoreCase(@NonNull String subjectName);
}