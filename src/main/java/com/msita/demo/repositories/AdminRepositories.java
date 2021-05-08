package com.msita.demo.repositories;

import com.msita.demo.form.Admin;
import com.msita.demo.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface AdminRepositories extends JpaRepository<Admin,Integer> {
//    @Query("UPDATE Admin SET Admin.name = ?2, Admin.address = ?3 , Admin.email = ?4 , Admin.password = ?5 , Admin.phone = ?6 , Admin.level = ?7 where Admin.id = ?1 ")
//    Admin updateByid(Integer id, String name, String address, String email, String password, String phone, int levels );
@Query("SELECT u.id FROM Admin u WHERE u.email = :email and u.password = :password")
Integer quyery1(String email, String password );
}
