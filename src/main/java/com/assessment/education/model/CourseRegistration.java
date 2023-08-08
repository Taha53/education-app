package com.assessment.education.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "course_registration")
public class CourseRegistration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

}
