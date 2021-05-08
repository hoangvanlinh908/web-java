package com.msita.demo.form;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class LoginFromUser {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
    private String name;
    private String email;
    private String password;

    public LoginFromUser(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginFromUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
