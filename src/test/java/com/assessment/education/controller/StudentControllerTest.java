package com.assessment.education.controller;

import com.assessment.education.model.Student;
import com.assessment.education.service.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        studentController = null;
        studentService = null;
    }

    @Test
    public void createStudent() {
        Student student = new Student();
        student.setStudentId(1L);
        when(studentService.registerStudent(any())).thenReturn(student);
        ResponseEntity<Student> studentResponseEntity = studentController.createStudent(student);
        Assert.assertNotNull(studentResponseEntity);
    }

    @Test
    public void deleteStudent() {

        doNothing().when(studentService).deleteStudent(1L);
        HttpStatus deleteStudent = studentController.deleteStudent(1L);
        Assert.assertNotNull(deleteStudent);
        Assert.assertEquals(200, deleteStudent.value());
    }
}