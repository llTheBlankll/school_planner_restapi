package com.nytri.school_planner.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "agenda_quiz")
public class AgendaQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id", nullable = false)
    private Integer id;

    @Column(name = "quiz_name", length = 128)
    private String quizName;

    @Column(name = "quiz_date")
    private LocalDate quizDate;

    @Column(name = "quiz_color", length = 48)
    private String quizColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_subject")
    private Subject quizSubject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public LocalDate getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(LocalDate quizDate) {
        this.quizDate = quizDate;
    }

    public String getQuizColor() {
        return quizColor;
    }

    public void setQuizColor(String quizColor) {
        this.quizColor = quizColor;
    }

    public Subject getQuizSubject() {
        return quizSubject;
    }

    public void setQuizSubject(Subject quizSubject) {
        this.quizSubject = quizSubject;
    }

}