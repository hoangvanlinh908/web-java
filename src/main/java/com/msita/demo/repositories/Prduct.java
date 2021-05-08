package com.msita.demo.repositories;

import com.msita.demo.form.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Prduct extends JpaRepository<ProductForm,Integer> {
}
