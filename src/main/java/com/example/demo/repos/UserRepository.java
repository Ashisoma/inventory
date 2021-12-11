package com.example.demo.repos;

//import com.example.demo.models.User;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}