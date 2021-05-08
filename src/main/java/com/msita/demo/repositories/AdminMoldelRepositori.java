package com.msita.demo.repositories;

import com.msita.demo.form.Admin;
import com.msita.demo.form.LoginFrom;
import com.msita.demo.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminMoldelRepositori extends JpaRepository<LoginFrom,Integer> {

}
