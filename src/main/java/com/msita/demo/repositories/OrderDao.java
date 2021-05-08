package com.msita.demo.repositories;


import com.msita.demo.models.Orders;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Orders,Integer> {

}
