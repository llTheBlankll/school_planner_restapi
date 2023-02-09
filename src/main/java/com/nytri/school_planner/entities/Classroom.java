package com.nytri.school_planner.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column(name = "room_id", nullable = false)
    private Integer id;

    @Column(name = "room_level", length = 128)
    private String roomLevel;

    @Column(name = "room_name", length = 128)
    private String roomName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(String roomLevel) {
        this.roomLevel = roomLevel;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}