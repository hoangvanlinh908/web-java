package com.msita.demo.repositories;

import com.msita.demo.models.ProductModel;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdcutDaoModel extends JpaRepository<ProductModel,Integer> {


}
