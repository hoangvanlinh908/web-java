package com.msita.demo.services;

import com.msita.demo.form.Admin;
import com.msita.demo.models.AdminModel;
import com.msita.demo.repositories.AdminMoldelRepositori;
import com.msita.demo.repositories.AdminRepositories;
import com.msita.demo.repositories.AdminRepositories1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {
    @Autowired
    private AdminMoldelRepositori adminMoldelRepositori;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private AdminRepositories adminRepositories;
    @Autowired
    private AdminRepositories1 adminRepositories1;
    @Transactional
    public List<Admin> finAll(){
        return (List<Admin>) adminRepositories.findAll();
    }
    @Transactional
    public void createAdmin(Admin admin){
        adminRepositories.save(admin);
    }

    public List<AdminModel> getContactById(Integer id) {
        return adminRepositories1.findAllById(Collections.singleton(id));
    }
    public Integer getUserIdByEmailAndPassword( String email, String password) {
                return adminRepositories.quyery1(email,password);
    }
    @Transactional
    public void save(AdminModel adminModel){
        adminRepositories1.save(adminModel);
    }
    @Transactional
    public void delete(Integer id){
        adminRepositories.deleteById(id);
}
    @Transactional
    public Admin findbyid(Integer id){
        adminRepositories.findById(id).get();
        return null;
    }
    @Transactional
    public Optional<Admin> edit(Integer id){
   return adminRepositories.findById(id);
}

}
