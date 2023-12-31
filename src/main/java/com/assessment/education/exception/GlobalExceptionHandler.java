package com.assessment.education.exception;

import com.assessment.education.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        String errorMsg = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMsg, "Runtime Exception Occurred", ex.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundEx(Exception ex) {
        String errorMsg = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMsg, "BAD REQUEST", ex.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundEx(Exception ex) {
        String errorMsg = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMsg, "BAD REQUEST", ex.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(CourseRegistrationNotFound.class)
    public ResponseEntity<ErrorResponse> handleCourseRegNotFoundEx(Exception ex) {
        String errorMsg = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMsg, "BAD REQUEST", ex.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundEx(Exception ex) {
        String errorMsg = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorMsg, "BAD REQUEST", ex.getCause().getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
