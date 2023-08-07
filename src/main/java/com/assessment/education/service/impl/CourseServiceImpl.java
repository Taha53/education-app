package com.assessment.education.service.impl;

import com.assessment.education.exception.CourseNotFoundException;
import com.assessment.education.model.Courses;
import com.assessment.education.repository.CourseRepository;
import com.assessment.education.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Courses addCourse(Courses courses) {
        log.info("Creating Courses");
        return courseRepository.saveAndFlush(courses);
    }

    @Override
    public void deleteCourse(Long courseId) {
        log.info("Delete course for course Id {}", courseId);
        Optional<Courses> courses = courseRepository.findById(courseId);
        if (courses.isPresent()) {
            courseRepository.delete(courses.get());
        } else {
            throw new CourseNotFoundException("CourseId not found");
        }
    }

    @Override
    public Courses updateCourse(Courses courses) {

        Optional<Courses> course = courseRepository.findById(courses.getCourseId());
        if (course.isPresent()) {
            Courses updateCourse = course.get();
            updateCourse.setCourseId(courses.getCourseId());
            updateCourse.setCourseName(courses.getCourseName());
            updateCourse.setCourseDesc(courses.getCourseDesc());
            courseRepository.saveAndFlush(updateCourse);
            return updateCourse;
        } else {
            throw new CourseNotFoundException("CourseId not found");
        }

    }

    @Override
    public List<Courses> getCourse() {
        return courseRepository.findAll();
    }
}
