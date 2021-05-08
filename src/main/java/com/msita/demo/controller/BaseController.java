package com.msita.demo.controller;

import com.msita.demo.form.Category;
import com.msita.demo.form.Seach;
import com.msita.demo.models.ProductModel;
import com.msita.demo.models.UserModel;
import com.msita.demo.services.CategoryServices;
import com.msita.demo.services.ProductServices;
import com.msita.demo.services.UserSevrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BaseController {
    @Autowired
    protected ProductServices productServices;
    @Autowired
    protected CategoryServices categoryService;
    @Autowired
    protected UserSevrices userSevrices;

    @ModelAttribute("shop")
    public List<ProductModel> getProduct(){
        return productServices.getEditProductBylimit();
    }
    @ModelAttribute("shop1")
    public List<ProductModel> getProduct1(){
        return productServices.getEditProductBylimit1();
    }
    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.finall();
    }
    @ModelAttribute("userModelcart")
    public UserModel getUser(HttpSession session){
        Integer loginFormUser = (Integer) session.getAttribute("loginFormUser");
        return (UserModel) userSevrices.getContactById(loginFormUser);
    }
    @ModelAttribute("search")
    public Seach Seach(){
       return new Seach();
    }
}
