package com.assessment.education.service;


import com.assessment.education.model.Courses;

import java.util.List;

public interface CourseService {

    Courses addCourse(Courses courses);

    void deleteCourse(Long courseId);

    Courses updateCourse(Courses courses);

    List<Courses> getCourse();
}
