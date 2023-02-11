package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.AttendanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AttendanceCategoryRepository extends JpaRepository<AttendanceCategory, Integer> {
    List<AttendanceCategory> findByCategoryNameContainsIgnoreCase(@Nullable String categoryName);

    @Override
    boolean existsById(@NonNull Integer integer);
}