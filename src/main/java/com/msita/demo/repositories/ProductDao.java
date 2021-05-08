package com.msita.demo.repositories;

import com.msita.demo.form.Product;
import com.msita.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
            @Query("SELECT m FROM Product m WHERE m.name LIKE %:title%")
            List<Product> searchByNameLike(@Param("title") String title);
}
