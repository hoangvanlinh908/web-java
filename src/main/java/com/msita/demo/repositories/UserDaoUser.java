package com.msita.demo.repositories;

import com.msita.demo.form.User;
import com.msita.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDaoUser extends JpaRepository<UserModel,Integer> {
    @Query("SELECT u FROM UserModel u WHERE  u.id = :id")
    UserModel quyery2(Integer id );

}
