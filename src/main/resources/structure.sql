-- Create database
DROP DATABASE IF EXISTS school_planner;
CREATE DATABASE school_planner;

-- Create own database user.
FLUSH PRIVILEGES;
CREATE USER 'schoolplanner'@'localhost' IDENTIFIED WITH "public";
GRANT SELECT, INSERT, DELETE, UPDATE ON school_planner.* TO 'schoolplanner'@'localhost';
FLUSH PRIVILEGES;

-- Use database
use school_planner;

-- Create database structure

CREATE TABLE classroom (
    room_id INT NOT NULL AUTO_INCREMENT,
    room_level VARCHAR(128),
    room_name VARCHAR(128),
    PRIMARY KEY (room_id)
);

CREATE TABLE teacher (
    teacher_id INT NOT NULL AUTO_INCREMENT,
    teacher_name VARCHAR(128) NOT NULL,
    teacher_surname VARCHAR(128) NULL,
    teacher_email VARCHAR(128) NULL,
    teacher_phone VARCHAR(128) NULL,
    teacher_website VARCHAR(128) NULL,
    PRIMARY KEY (teacher_id)
);

CREATE TABLE subjects (
    subject_id INT AUTO_INCREMENT NOT NULL,
    subject_name VARCHAR(128),
    subject_color VARCHAR(128),
    subject_room INT,
    subject_teacher INT,
    subject_notes TEXT,
    PRIMARY KEY (subject_id),
    CONSTRAINT fk_subject_teacher FOREIGN KEY (subject_teacher) REFERENCES teacher (teacher_id),
    CONSTRAINT fk_subject_room FOREIGN KEY (subject_room) REFERENCES classroom (room_id)
);

CREATE TABLE attendance_category (
    attendance_category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(128),
    category_description TEXT,
    PRIMARY KEY (attendance_category_id)
);

CREATE TABLE attendance (
    attendance_id INT AUTO_INCREMENT NOT NULL ,
    attendance_category INT,
    attendance_date DATE NOT NULL,
    attendance_time TIME NOT NULL,
    attendance_excuse BOOLEAN,
    attendance_remarks TEXT,
    PRIMARY KEY (attendance_id),
    CONSTRAINT fk_attendance_category FOREIGN KEY (attendance_category) REFERENCES attendance_category (attendance_category_id)
);

CREATE TABLE agenda_homework (
    homework_id INT AUTO_INCREMENT NOT NULL ,
    homework_title VARCHAR(128),
    homework_deadline DATE,
    homework_reminder DATETIME, homework_subject INT,
    homework_notes TEXT,
    PRIMARY KEY (homework_id),
    CONSTRAINT fk_homework_subject FOREIGN KEY (homework_subject) REFERENCES subjects (subject_id)
);

CREATE TABLE agenda_reminder (
    reminder_id INT AUTO_INCREMENT NOT NULL ,
    reminder_name VARCHAR(128)
)