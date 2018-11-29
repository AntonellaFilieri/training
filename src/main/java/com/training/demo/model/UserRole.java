package com.training.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Getter
@Setter
public class UserRole {
    @Id
    private java.lang.String id;

    private java.lang.String description;
    private java.lang.String name;

    private Role role;

    public UserRole() {

    }

    public UserRole(Role role) {

        BeanUtils.copyProperties(role, this);
    }
}
