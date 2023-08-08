package com.assessment.education.controller;

import com.assessment.education.model.CourseRegistration;
import com.assessment.education.service.RegistrationCourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private RegistrationCourseService registrationCourseService;

    @ApiOperation(value = "It Allocate the course to student")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PostMapping(value = "/course/registration")
    public ResponseEntity<CourseRegistration> allocateCourse(@RequestBody CourseRegistration courseRegistration) {
        log.info("Allocate Course");
        courseRegistration = registrationCourseService.allocateCourse(courseRegistration);
        return new ResponseEntity<>(courseRegistration, HttpStatus.CREATED);
    }

    @ApiOperation(value = "It retrieve the Student register for the course")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @GetMapping(value = "/course/registration")
    public ResponseEntity<List<CourseRegistration>> getCourseRegistered() {
        log.info("Get Student Registered for the Course");
        List<CourseRegistration> courseRegistrations = registrationCourseService.getStudentSelectedCourse();
        return new ResponseEntity<>(courseRegistrations, HttpStatus.OK);
    }

    @ApiOperation(value = "It update the Courses of registered student")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PutMapping(value = "/course/registration/{registrationId}")
    public ResponseEntity<CourseRegistration> updateCourseRegistration(@PathVariable Long registrationId, @RequestBody CourseRegistration courseRegistration) {
        log.info("Update Course for the student");
        courseRegistration.setRegistrationId(registrationId);
        return new ResponseEntity<>(registrationCourseService.updateCourseOfStudent(courseRegistration), HttpStatus.OK);
    }
}
