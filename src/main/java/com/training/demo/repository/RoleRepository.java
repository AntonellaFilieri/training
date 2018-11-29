package com.training.demo.repository;

import com.training.demo.model.UserRole;
import com.training.demo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends MongoRepository<UserRole, java.lang.String> {
    Optional<UserRole> findByName(String name);
}

