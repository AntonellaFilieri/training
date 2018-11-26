package com.training.demo.repository;

import com.training.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, Integer> {
    User findByName(String name);
}