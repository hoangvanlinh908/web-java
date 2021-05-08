package com.msita.demo.repositories;

import com.msita.demo.form.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Integer> {
    @Query("SELECT u.id FROM User u WHERE u.email = :email and u.password = :password")
    Integer quyery1(String email, String password );


}
