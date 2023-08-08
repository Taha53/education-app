package com.assessment.education.service.impl;

import com.assessment.education.model.CourseRegistration;
import com.assessment.education.repository.CourseRegistrationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RegistrationCourseServiceImplTest {

    @Mock
    CourseRegistrationRepository courseRegistrationRepository;

    @InjectMocks
    RegistrationCourseServiceImpl registrationCourseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        registrationCourseService = null;
        courseRegistrationRepository = null;
    }

    @Test
    public void allocateCourse() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(1L);
        when(courseRegistrationRepository.saveAndFlush(any())).thenReturn(courseRegistration);
        courseRegistration = registrationCourseService.allocateCourse(courseRegistration);
        Assert.assertNotNull(courseRegistration);
    }

    @Test
    public void getStudentSelectedCourse() {
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(1L);
        List<CourseRegistration> courseRegistrationList = new ArrayList<>();
        courseRegistrationList.add(courseRegistration);
        when(courseRegistrationRepository.findAll()).thenReturn(courseRegistrationList);
        courseRegistrationList = registrationCourseService.getStudentSelectedCourse();
        Assert.assertNotNull(courseRegistrationList);
    }
}