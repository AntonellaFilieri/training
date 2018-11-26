package com.training.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
public class User {

    @Id
    private String id;
    private String name;

    public User() {
    }

    public User( String name) {
        this.name = name;
    }
}
