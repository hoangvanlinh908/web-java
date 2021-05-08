package com.msita.demo.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private  String slug;
    @Min(1)
    private float price;
    @Min(0)
    private float sale;
    @Min(1)
    private int number;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date created_ad;
    @NotNull
    private Integer category_id;


    public ProductForm(Integer id, @NotBlank String name, @NotBlank String slug, @Min(1) float price, @Min(0) float sale, @Min(1) int number, Date created_ad, @NotNull Integer category_id) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.price = price;
        this.sale = sale;
        this.number = number;
        this.created_ad = created_ad;
        this.category_id = category_id;
    }

    public ProductForm() {

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
