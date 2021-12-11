package com.example.demo.repos;

import com.example.demo.models.Role;
import com.example.demo.models.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public  void  testNewRoleCreated(){
//        Role admin = new Role("Admin");
//        Role editor = new Role("Editor");
        Role visitor = new Role("Visitor");
//
//         testEntityManager.persist(admin);
//        testEntityManager.persist(editor);
        testEntityManager.persist(visitor);
    }

    @Test
    public void testCreateUserWIthRole(){
        Role adminRole =  testEntityManager.find(Role.class, 1);
        Users user = new Users("yeye@gmail.com", "12345");
        user.addUserRole(adminRole);
        repository.save(user);
    }

    @Test
    public void testCreateUserWIthTwoRoles(){
        Role adminRole =  testEntityManager.find(Role.class, 2);
        Role editoRole =  testEntityManager.find(Role.class, 4);
        Users user = new Users("mimi@gmail.com", "127745");
        user.addUserRole(adminRole);
        user.addUserRole(editoRole);
        repository.save(user);

//        testEntityManager.persist(user);

    }
}