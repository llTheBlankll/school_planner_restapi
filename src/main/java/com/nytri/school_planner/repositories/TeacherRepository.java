package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}