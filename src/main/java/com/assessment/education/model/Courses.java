package com.assessment.education.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "courses")
public class Courses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_desc")
    private String courseDesc;
}
