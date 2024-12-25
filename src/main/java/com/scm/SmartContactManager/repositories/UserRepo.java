package com.scm.SmartContactManager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.SmartContactManager.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
 
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
