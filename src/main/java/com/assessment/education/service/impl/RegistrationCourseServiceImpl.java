package com.assessment.education.service.impl;

import com.assessment.education.exception.CourseRegistrationNotFound;
import com.assessment.education.model.CourseRegistration;
import com.assessment.education.repository.CourseRegistrationRepository;
import com.assessment.education.service.RegistrationCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class RegistrationCourseServiceImpl implements RegistrationCourseService {

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public CourseRegistration allocateCourse(CourseRegistration courseRegistration) {
        log.info("Allocate Course to Student");
        return courseRegistrationRepository.saveAndFlush(courseRegistration);
    }

    @Override
    public List<CourseRegistration> getStudentSelectedCourse() {
        log.info("Find student allocated for the course");
        return courseRegistrationRepository.findAll();
    }

    @Override
    public CourseRegistration updateCourseOfStudent(CourseRegistration courseRegistration) {
        log.info("Update Course in the course registration");
        Optional<CourseRegistration> courseRegistrations = courseRegistrationRepository.findById(courseRegistration.getRegistrationId());
        if (courseRegistrations.isPresent()) {
            CourseRegistration updateCourseRegistration = courseRegistrations.get();
            updateCourseRegistration.setRegistrationId(courseRegistration.getRegistrationId());
            updateCourseRegistration.setCourseId(courseRegistration.getCourseId());
            courseRegistrationRepository.saveAndFlush(courseRegistration);
            return updateCourseRegistration;
        } else {
            throw new CourseRegistrationNotFound("Course Registration not found");
        }
    }
}
