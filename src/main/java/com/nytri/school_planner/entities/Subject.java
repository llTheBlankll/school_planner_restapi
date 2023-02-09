package com.nytri.school_planner.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "subject_id", nullable = false)
    private Integer id;

    @Column(name = "subject_name", length = 128)
    private String subjectName;

    @Column(name = "subject_color", length = 128)
    private String subjectColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_room")
    private Classroom subjectRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_teacher")
    private Teacher subjectTeacher;

    @Lob
    @Column(name = "subject_notes")
    private String subjectNotes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectColor() {
        return subjectColor;
    }

    public void setSubjectColor(String subjectColor) {
        this.subjectColor = subjectColor;
    }

    public Classroom getSubjectRoom() {
        return subjectRoom;
    }

    public void setSubjectRoom(Classroom subjectRoom) {
        this.subjectRoom = subjectRoom;
    }

    public Teacher getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(Teacher subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public String getSubjectNotes() {
        return subjectNotes;
    }

    public void setSubjectNotes(String subjectNotes) {
        this.subjectNotes = subjectNotes;
    }

}