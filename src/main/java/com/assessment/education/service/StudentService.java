package com.assessment.education.service;

import com.assessment.education.model.Student;

public interface StudentService {

    Student registerStudent(Student student);

    void deleteStudent(Long studentId);
}
