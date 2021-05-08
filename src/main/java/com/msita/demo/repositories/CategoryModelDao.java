package com.msita.demo.repositories;

import com.msita.demo.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryModelDao extends JpaRepository<CategoryModel,Integer> {
}
