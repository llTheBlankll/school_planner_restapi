package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AttendanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceCategoryRepository extends JpaRepository<AttendanceCategory, Integer> {
}