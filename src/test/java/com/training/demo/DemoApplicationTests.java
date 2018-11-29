package com.training.demo;

import com.training.demo.model.User;
import com.training.demo.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;


    @Before
    public void setUp() throws Exception {
        User user1= new User("Alice");
        User user2= new User("Bob");
        //save product, verify has ID value after save
        assertNull(user1.getId());
        assertNull(user2.getId());//null before save
        this.userRepository.save(user1);
        this.userRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Optional<User> userA = userRepository.findByName("Bob");
        assertNotNull(userA);
        /*Get all products, list should only have two*/
        Iterable<User> users = userRepository.findAll();
        int count = 0;
        for(User p : users){
            count++;
        }
        assertEquals(count, 2);
    }

    @Test
    public void testDataUpdate(){
        /*Test update*/
        /*Optional<User> userB = userRepository.findByName("Bob");
        userB.isPresent(userRepository.save(userB));
        Optional<User> userC= userRepository.findByName("Bob");
        assertNotNull(userC);*/
    }

    @After
    public void tearDown() throws Exception {
        this.userRepository.deleteAll();
    }


}
