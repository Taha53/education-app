package com.assessment.education.service.impl;

import com.assessment.education.model.Courses;
import com.assessment.education.repository.CourseRepository;
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

public class CourseServiceImplTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseServiceImpl courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        courseService = null;
        courseRepository = null;
    }

    @Test
    public void addCourse() {
        Courses courses = new Courses();
        courses.setCourseId(1L);
        when(courseRepository.saveAndFlush(any())).thenReturn(courses);
        courses = courseService.addCourse(courses);
        Assert.assertNotNull(courses);
    }

    @Test
    public void getCourse() {
        Courses courses = new Courses();
        courses.setCourseId(1L);
        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courses);
        when(courseRepository.findAll()).thenReturn(coursesList);
        coursesList = courseService.getCourse();
        Assert.assertNotNull(coursesList);
    }
}