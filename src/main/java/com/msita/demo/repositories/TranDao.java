package com.msita.demo.repositories;

import com.msita.demo.form.User;
import com.msita.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranDao extends JpaRepository<Transaction,Integer> {

}
