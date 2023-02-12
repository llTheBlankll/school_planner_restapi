package com.nytri.school_planner.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "agenda_reminder")
public class AgendaReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id", nullable = false)
    private Integer id;

    @Column(name = "reminder_name", length = 128)
    private String reminderName;

    @Column(name = "reminder_datetime")
    private Instant reminderDatetime;

    @Column(name = "reminder_color", length = 48)
    private String reminderColor;

    @Lob
    @Column(name = "reminder_note")
    private String reminderNote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReminderName() {
        return reminderName;
    }

    public void setReminderName(String reminderName) {
        this.reminderName = reminderName;
    }

    public Instant getReminderDatetime() {
        return reminderDatetime;
    }

    public void setReminderDatetime(Instant reminderDatetime) {
        this.reminderDatetime = reminderDatetime;
    }

    public String getReminderColor() {
        return reminderColor;
    }

    public void setReminderColor(String reminderColor) {
        this.reminderColor = reminderColor;
    }

    public String getReminderNote() {
        return reminderNote;
    }

    public void setReminderNote(String reminderNote) {
        this.reminderNote = reminderNote;
    }

}