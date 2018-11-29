package com.training.demo;

import com.training.demo.model.User;
import com.training.demo.repository.UserRepository;
import de.flapdoodle.embed.mongo.MongodExecutable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataMongoTest //- test senza il run dell'app
@ActiveProfiles(profiles = "test")
public class UserTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userMongoRepository;


    @Before
    public void setUp() throws Exception {
        User user1= new User("Alice");
        User user2= new User("Bob");
        //save product, verify has ID value after save
        assertNull(user1.getId());
        assertNull(user2.getId());//null before save
        this.userMongoRepository.save(user1);
        this.userMongoRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Optional<User> userA = userMongoRepository.findByName("Bob");
        assertNotNull(userA);
        /*Get all products, list should only have two*/
        int count = userMongoRepository.findAll().size();

        assertEquals(count, 2);
    }

    @Test
    public void testDataUpdate(){
        /*Test update*/
       /* Optional<User> userB = userMongoRepository.findByName("Bob");
        userMongoRepository.save(userB);
        Optional<User> userC= userMongoRepository.findByName("Bob");
        assertNotNull(userC);*/
    }

    @After
    public void tearDown() throws Exception {
        this.userMongoRepository.deleteAll();
    }

}
