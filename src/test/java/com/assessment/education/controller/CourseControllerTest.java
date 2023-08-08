package com.assessment.education.controller;

import com.assessment.education.model.Courses;
import com.assessment.education.service.CourseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        courseService = null;
        courseController = null;
    }

    @Test
    public void createCourse() {
        Courses courses = new Courses();
        courses.setCourseId(1L);
        when(courseService.addCourse(any())).thenReturn(courses);
        ResponseEntity<Courses> createCourses = courseController.createCourse(courses);
        Assert.assertNotNull(createCourses);

    }

    @Test
    public void getCourse() {
        Courses courses = new Courses();
        List<Courses> coursesList = new ArrayList<>();
        courses.setCourseId(1L);
        coursesList.add(courses);
        when(courseService.getCourse()).thenReturn(coursesList);
        ResponseEntity<List<Courses>> getCourses = courseController.getCourse();
        Assert.assertNotNull(getCourses);
        Assert.assertEquals(Long.valueOf(1), getCourses.getBody().get(0).getCourseId());
    }

    @Test
    public void deleteCourse() {
        doNothing().when(courseService).deleteCourse(1L);
        HttpStatus deleteCourses = courseController.deleteCourse(1L);
        Assert.assertNotNull(deleteCourses);
        Assert.assertEquals(200, deleteCourses.value());
    }

    @Test
    public void updateCourse() {
        Courses courses = new Courses();
        courses.setCourseId(1L);
        when(courseService.updateCourse(any())).thenReturn(courses);
        ResponseEntity<Courses> createCourses = courseController.updateCourse(1L, courses);
        Assert.assertNotNull(createCourses);
    }
}