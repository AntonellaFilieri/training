package com.training.demo;


import com.training.demo.model.UserRole;
import com.training.demo.model.Role;
import com.training.demo.model.User;
import com.training.demo.repository.RoleRepository;
import com.training.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());
        userRepository.save(new User("alè"));
        initRole();
    }

    private void initRole() {
        Arrays.stream(Role.values()).forEach((r) -> {
                    Optional<UserRole> existRole = roleRepository.findByName(r.getName());
                    if(!existRole.isPresent()) roleRepository.save(new UserRole(r));
                }
        );
    }
}