package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}