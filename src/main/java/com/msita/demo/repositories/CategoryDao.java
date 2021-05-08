package com.msita.demo.repositories;

import com.msita.demo.form.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao  extends JpaRepository<Category,Integer> {
}
