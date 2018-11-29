package com.training.demo.repository;

import com.training.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}