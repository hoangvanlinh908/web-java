package com.msita.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private  String slug;
    private float price;
    private float sale;
    private int number;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date created_ad;
    private String thunbar;
    private Integer category_id;

    public ProductModel() {

    }

    public ProductModel(Integer id, String name, String slug, float price, float sale, int number, Date created_ad, String thunbar, Integer category_id) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.price = price;
        this.sale = sale;
        this.number = number;
        this.created_ad = created_ad;
        this.thunbar = thunbar;
        this.category_id = category_id;
    }

    public ProductModel(String name, String slug, float price, float sale, int number, String thunbar, Integer category_id) {

        this.name = name;
        this.slug = slug;
        this.price = price;
        this.sale = sale;
        this.number = number;

        this.thunbar = thunbar;
        this.category_id = category_id;
    }

    public String getThunbar() {
        return thunbar;
    }

    public void setThunbar(String thunbar) {
        this.thunbar = thunbar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreated_ad() {
        return created_ad;
    }

    public void setCreated_ad(Date created_ad) {
        this.created_ad = created_ad;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
