package com.nytri.school_planner.repositories;

import com.nytri.school_planner.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findByRoomNameContains(String name);
    List<Classroom> findByRoomLevelContains(String level);

    boolean existsByRoomName(String room_name);
}