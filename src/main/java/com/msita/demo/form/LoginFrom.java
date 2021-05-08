package com.msita.demo.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin")
public class LoginFrom{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Integer id;
    private String email;
    private String password;

    public LoginFrom(){

    }

    public LoginFrom(String email, String password) {
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
