package com.assessment.education.service.impl;

import com.assessment.education.exception.StudentNotFoundException;
import com.assessment.education.model.Student;
import com.assessment.education.repository.StudentRepository;
import com.assessment.education.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student registerStudent(Student student) {
        log.info("Register Student");
        return studentRepository.saveAndFlush(student);
    }


    @Override
    public void deleteStudent(Long studentId) {
        log.info("Delete student Id {}", studentId);
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
        } else {
            throw new StudentNotFoundException("StudentId not found");
        }
    }
}
