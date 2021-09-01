package com.example.Login.Repo;

import com.example.Login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {


    @Query("select u from User u where u.email=:email")
    User findByEmail(@Param("email") String email);
}
