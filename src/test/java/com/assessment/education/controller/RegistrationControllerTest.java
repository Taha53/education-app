package com.assessment.education.controller;

import com.assessment.education.model.CourseRegistration;
import com.assessment.education.service.RegistrationCourseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RegistrationControllerTest {

    @Mock
    private RegistrationCourseService registrationCourseService;

    @InjectMocks
    private RegistrationController registrationController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        registrationController = null;
        registrationCourseService = null;
    }

    @Test
    public void allocateCourse() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(1L);
        when(registrationCourseService.allocateCourse(any())).thenReturn(courseRegistration);
        ResponseEntity<CourseRegistration> allocateCourses = registrationController.allocateCourse(courseRegistration);
        Assert.assertNotNull(allocateCourses);
    }

    @Test
    public void getCourseRegistered() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(1L);
        List<CourseRegistration> courseRegistrationList = new ArrayList<>();
        courseRegistrationList.add(courseRegistration);
        when(registrationCourseService.getStudentSelectedCourse()).thenReturn(courseRegistrationList);
        ResponseEntity<List<CourseRegistration>> courseRegistered = registrationController.getCourseRegistered();
        Assert.assertNotNull(courseRegistered);
    }

    @Test
    public void updateCourseRegistration() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(1L);
        when(registrationCourseService.updateCourseOfStudent(any())).thenReturn(courseRegistration);
        ResponseEntity<CourseRegistration> updateRegistered = registrationController.updateCourseRegistration(1L, courseRegistration);
        Assert.assertNotNull(updateRegistered);
    }
}