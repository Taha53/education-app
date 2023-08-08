package com.assessment.education.service;

import com.assessment.education.model.CourseRegistration;

import java.util.List;

public interface RegistrationCourseService {

    CourseRegistration allocateCourse(CourseRegistration courseRegistration);

    List<CourseRegistration> getStudentSelectedCourse();

    CourseRegistration updateCourseOfStudent(CourseRegistration courseRegistration);
}
