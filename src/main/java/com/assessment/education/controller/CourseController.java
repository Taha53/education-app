package com.assessment.education.controller;

import com.assessment.education.model.Courses;
import com.assessment.education.service.CourseService;
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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "It Creates the Courses")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PostMapping(value = "/course")
    public ResponseEntity<Courses> createCourse(@RequestBody Courses courses) {
        log.info("Create Course");
        courses = courseService.addCourse(courses);
        return new ResponseEntity<>(courses, HttpStatus.CREATED);
    }

    @ApiOperation(value = "It retrieve the Courses")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @GetMapping(value = "/course")
    public ResponseEntity<List<Courses>> getCourse() {
        log.info("Get Course");
        List<Courses> courses = courseService.getCourse();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @ApiOperation(value = "It deletes the Courses")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @DeleteMapping(value = "/course/{courseId}")
    public HttpStatus deleteCourse(@PathVariable Long courseId) {
        log.info("delete Course");
        courseService.deleteCourse(courseId);
        return HttpStatus.OK;
    }

    @ApiOperation(value = "It update the Courses")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PutMapping(value = "/course/{courseId}")
    public ResponseEntity<Courses> updateCourse(@PathVariable Long courseId, @RequestBody Courses courses) {
        log.info("update Course");
        courses.setCourseId(courseId);
        return new ResponseEntity<>(courseService.updateCourse(courses), HttpStatus.OK);
    }

}
