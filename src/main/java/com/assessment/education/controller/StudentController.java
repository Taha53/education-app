package com.assessment.education.controller;

import com.assessment.education.model.Student;
import com.assessment.education.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "It Creates the Student")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PostMapping(value = "/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        log.info("Create student");
        student = studentService.registerStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @ApiOperation(value = "It deletes the Student")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @DeleteMapping(value = "/student/{studentId}")
    public HttpStatus deleteStudent(@PathVariable Long studentId) {
        log.info("delete Course");
        studentService.deleteStudent(studentId);
        return HttpStatus.OK;
    }
}
