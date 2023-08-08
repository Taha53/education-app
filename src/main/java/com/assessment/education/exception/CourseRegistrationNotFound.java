package com.assessment.education.exception;

public class CourseRegistrationNotFound extends RuntimeException {
    public CourseRegistrationNotFound(String message) {
        super(message);
    }

    public CourseRegistrationNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
