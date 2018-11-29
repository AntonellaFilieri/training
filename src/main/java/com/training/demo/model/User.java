package com.training.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Getter
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<UserRole> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }
}
