package com.assessment.education.service.impl;

import com.assessment.education.model.Student;
import com.assessment.education.repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        studentService = null;
        studentRepository = null;
    }

    @Test
    public void registerStudent() {

        Student student = new Student();
        student.setStudentId(1L);
        when(studentRepository.saveAndFlush(any())).thenReturn(student);
        student = studentService.registerStudent(student);
        Assert.assertNotNull(student);
    }
}