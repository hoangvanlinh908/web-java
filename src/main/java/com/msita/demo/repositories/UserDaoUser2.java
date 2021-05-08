package com.msita.demo.repositories;

import com.msita.demo.form.LoginFromUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDaoUser2 extends JpaRepository<LoginFromUser,Integer> {

}


