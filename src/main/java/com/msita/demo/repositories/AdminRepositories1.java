package com.msita.demo.repositories;

import com.msita.demo.form.Admin;
import com.msita.demo.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepositories1 extends JpaRepository<AdminModel,Integer> {
//    @Query("UPDATE Admin SET Admin.name = ?2, Admin.address = ?3 , Admin.email = ?4 , Admin.password = ?5 , Admin.phone = ?6 , Admin.level = ?7 where Admin.id = ?1 ")
//    Admin updateByid(Integer id, String name, String address, String email, String password, String phone, int levels );
//  @Query("SELECT c FROM  Admin c where c.email = ?1 and  c.password = ?2")
//  Admin findAdminByEmailAndPassword(String email, String password);


}
