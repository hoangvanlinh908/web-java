package com.msita.demo.services;

import com.msita.demo.form.User;
import com.msita.demo.models.UserModel;
import com.msita.demo.repositories.UserDao;
import com.msita.demo.repositories.UserDaoUser;
import com.msita.demo.repositories.UserDaoUser2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
@Service
public class UserSevrices {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDaoUser userDao1;
    @Autowired
    private UserDaoUser2 userDaoUser2;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Transactional
    public List<User> finall(){
     return userDao.findAll();
    }
    @Transactional
    public void delete(Integer id){
        userDao.deleteById(id);
    }
    public Integer getUserIdByEmailAndPassword(final String email, final String password) {
        return userDao.quyery1(email,password);
    }
    @Transactional
    public void createUser(UserModel userModel){
        userDao1.save(userModel);
    }
    @Transactional
    public UserModel finbyid(Integer id){
        return (UserModel) userDao1.findAllById(Collections.singleton(id));
    }
    public UserModel getContactById(Integer id) {
        return  userDao1.quyery2(id);
    }
}
