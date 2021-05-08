package com.msita.demo.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    private  String slug;
    private boolean home;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date created_at;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
     private List<Product>  products;


    public Category() {

    }

    public Category(String name, String slug, boolean home, Date created_at) {
        this.name = name;
        this.slug = slug;
        this.home = home;
        this.created_at = created_at;
    }

    public Category(Integer id, String name, String slug, boolean home, Date created_at) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.home = home;
        this.created_at = created_at;
    }

    public Category(String name, String slug, Date created_at) {
        this.name = name;
        this.slug = slug;
        this.created_at = created_at;

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

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
