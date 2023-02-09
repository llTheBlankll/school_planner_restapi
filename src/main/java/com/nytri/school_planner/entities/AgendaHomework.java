package com.nytri.school_planner.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "agenda_homework")
public class AgendaHomework {
    @Id
    @Column(name = "homework_id", nullable = false)
    private Integer id;

    @Column(name = "homework_title", length = 128)
    private String homeworkTitle;

    @Column(name = "homework_deadline")
    private LocalDate homeworkDeadline;

    @Column(name = "homework_reminder")
    private Instant homeworkReminder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homework_subject")
    private Subject homeworkSubject;

    @Lob
    @Column(name = "homework_notes")
    private String homeworkNotes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public LocalDate getHomeworkDeadline() {
        return homeworkDeadline;
    }

    public void setHomeworkDeadline(LocalDate homeworkDeadline) {
        this.homeworkDeadline = homeworkDeadline;
    }

    public Instant getHomeworkReminder() {
        return homeworkReminder;
    }

    public void setHomeworkReminder(Instant homeworkReminder) {
        this.homeworkReminder = homeworkReminder;
    }

    public Subject getHomeworkSubject() {
        return homeworkSubject;
    }

    public void setHomeworkSubject(Subject homeworkSubject) {
        this.homeworkSubject = homeworkSubject;
    }

    public String getHomeworkNotes() {
        return homeworkNotes;
    }

    public void setHomeworkNotes(String homeworkNotes) {
        this.homeworkNotes = homeworkNotes;
    }

}