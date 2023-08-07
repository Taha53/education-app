package com.assessment.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

    private String errorMsg;
    private String cause;
    private String errorDetail;
}
