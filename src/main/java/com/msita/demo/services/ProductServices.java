package com.msita.demo.services;

import com.msita.demo.form.Product;
import com.msita.demo.form.ProductForm;
import com.msita.demo.models.*;
import com.msita.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service


public class ProductServices {
    @Autowired
    private Prduct prduct;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TranDao tranDao;
    @Autowired
    private ProdcutDaoModel productDaoModel;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private ShopRepositories shopRepositories;
    @Transactional
    public List<Product> finall(){
        return productDao.findAll();
    }
    @Transactional
    public List<Transaction> finall1(){
        return tranDao.findAll();
    }
    @Transactional
    public void  addproduct(ProductModel product){
        productDaoModel.save(product);
    }
    @Transactional
    public void delete(Integer id){
        productDao.deleteById(id);
    }
    @Transactional
    public List<ProductModel> getByprodcutId(Integer id){
        return productDaoModel.findAllById(Collections.singleton(id));
    }
    public Optional<ProductModel> getByprodcutId1(Integer id){
        return productDaoModel.findById(id);
    }
    @Transactional
    public void save(ProductModel productModel){
        productDaoModel.save(productModel);
    }
    @Transactional
    public void save2(Transaction transaction){
        tranDao.save(transaction);
    }
    @Transactional
    public void save3(Orders orders){
        orderDao.save(orders);
    }
    @Transactional
    public void save1(ProductForm productForm){
        prduct.save(productForm);
    }
    @Transactional
    public List<ProductModel> getEditProductByCategoryIdPage(int pageSize , int page){

        return shopRepositories.getEditProductByCategoryIdPage(pageSize,page);
    }
    @Transactional
    public List<ProductModel> getEditProductBylimit(){
        return shopRepositories.getEditProductBylimit();
    }
    @Transactional
    public List<ProductModel> getEditProductBylimit9(Integer id){
        return shopRepositories.getEditProductBylimit9(id);
    }
    @Transactional
    public List<ProductModel> getProductById(Integer id) {
        return productDaoModel.findAllById(Collections.singleton(id));
    }
    @Transactional
    public List<ProductModel> getEditProductBylimit1(){
        return shopRepositories.getEditProductBylimit1();
    }
    @Transactional
    public List<ProductModel> getEditProductBylimit12(){
        return shopRepositories.getEditProductBylimit12();
    }
    @Transactional
    public List<ProductModel> getEditProductBylimit123(){
        return shopRepositories.getEditProductBylimit123();
    }
    @Transactional
    public int count(){
      return (int) productDaoModel.count();


    }
    @Transactional
    public Integer getTramId() {
        return shopRepositories.getTramId();


    }
    @Transactional
    public List<Product> searchByNameLike(String name)
    {
        return productDao.searchByNameLike(name);
    }



}


