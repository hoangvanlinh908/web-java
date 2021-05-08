package com.msita.demo.repositories;

import com.msita.demo.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopRepositories {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<ProductModel> getEditProductByCategoryIdPage(int pageSize , int page){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product   LIMIT  ? OFFSET ?", pageSize,pageSize*(page-1));
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }

        return products;
    }
    public List<ProductModel> getEditProductBylimit(){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product   LIMIT  2 ");
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }
        return products;
    }
    public List<ProductModel> getEditProductBylimit9(Integer id){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product WHERE category_id = ?",id);
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }
        return products;
    }

    public List<ProductModel> getEditProductBylimit1(){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product   LIMIT  2 OFFSET 2 ");
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }
        return products;
    }
    public List<ProductModel> getEditProductBylimit12(){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product  WHERE 1 ORDER BY ID DESC LIMIT 4 ");
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }

        return products;
    }
    public List<ProductModel> getEditProductBylimit123(){
        ArrayList<ProductModel> products = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM product  WHERE 1 ORDER BY pay  DESC LIMIT 4 ");
        while (sqlRowSet.next()) {
            products.add(new ProductModel(sqlRowSet.getInt("id"),
                    sqlRowSet.getString("name"),
                    sqlRowSet.getString("slug"),
                    sqlRowSet.getFloat("price"),
                    sqlRowSet.getFloat("sale"),
                    sqlRowSet.getInt("number"),
                    sqlRowSet.getDate("created_ad"),
                    sqlRowSet.getString("thunbar"),
                    sqlRowSet.getInt("category_id")
            ));
        }

        return products;
    }
    public Integer getTramId() {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM transaction  ORDER BY id  DESC LIMIT 1");
        if (sqlRowSet.next())  {
            return sqlRowSet.getInt("id");
        }
        return null;


    }
}
