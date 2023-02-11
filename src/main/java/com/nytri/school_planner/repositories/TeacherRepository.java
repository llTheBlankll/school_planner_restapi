package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByTeacherSurnameLikeIgnoreCase(@NonNull String teacherSurname);
    List<Teacher> findByTeacherNameLikeIgnoreCase(String teacherName);
}