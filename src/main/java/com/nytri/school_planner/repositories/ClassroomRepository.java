package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}