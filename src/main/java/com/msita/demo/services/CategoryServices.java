package com.msita.demo.services;

import com.msita.demo.form.Category;
import com.msita.demo.form.EditCategory;
import com.msita.demo.models.AdminModel;
import com.msita.demo.models.CategoryModel;
import com.msita.demo.repositories.CategoryDao;
import com.msita.demo.repositories.CategoryModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CategoryModelDao categoryModelDao;
    @Transactional
    public List<Category> finall(){
        return categoryDao.findAll();
    }
    @Transactional
    public  void  addCategory(Category category){
        categoryDao.save(category);
    }
    @Transactional
    public void delete(Integer id){
        categoryDao.deleteById(id);
    }
    @Transactional
    public List<CategoryModel> getcategoryByid(Integer id){
        return categoryModelDao.findAllById(Collections.singleton(id));
    }
    @Transactional
    public void save(CategoryModel categoryModel){
        categoryModelDao.save(categoryModel);
    }
    public List<Category> getAll(){
        return categoryDao.findAll();
    }


}
