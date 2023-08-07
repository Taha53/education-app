package com.assessment.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private String username;
    private String password;
}
