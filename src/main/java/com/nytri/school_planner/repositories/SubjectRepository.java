package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}