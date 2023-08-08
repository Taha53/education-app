package com.assessment.education.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseConstant {

    SUCCESS("SUCCESS"),
    UNAUTHORIZED("Unauthorized"),
    AUTHORIZATION("Authorization"),
    BEARER("Bearer "),
    USER_DISABLED("USER_DISABLED"),
    INVALID_CREDENTIALS("INVALID_CREDENTIALS");
    private final String value;
}
