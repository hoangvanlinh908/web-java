package com.msita.demo.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotBlank
    private String name;

    private  String slug;
    private  String thunbar;
    @Min(1)
    private float price;
    @Min(1)
    private float sale;
    @Min(1)
    private int number;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date created_ad;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Product() {

    }

    public Product(String name, String slug, String thunbar, float price, float sale, int number, Date created_ad, Category category) {
        this.name = name;
        this.slug = slug;
        this.thunbar = thunbar;
        this.price = price;
        this.sale = sale;
        this.number = number;
        this.created_ad = created_ad;
        this.category = category;
    }

    public Product(Integer id, String name, String slug, String thunbar, float price, float sale, int number, Date created_ad, Category category) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.thunbar = thunbar;
        this.price = price;
        this.sale = sale;
        this.number = number;
        this.created_ad = created_ad;
        this.category = category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getThunbar() {
        return thunbar;
    }

    public void setThunbar(String thunbar) {
        this.thunbar = thunbar;
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
}
