package com.training.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat
@Getter
public enum Role {
    ROLE_USER("User", "default"),
    ROLE_ADMIN("Admin");

    private String name;
    private String description;


    Role(String name, String description) {
        this.name = name;
        this.description = description;

    }

    Role(String name) {
        this.name = name;
    }
}
