package com.msita.demo.controller.admin;


import com.msita.demo.form.Admin;
import com.msita.demo.form.LoginFrom;
import com.msita.demo.models.AdminModel;
import com.msita.demo.repositories.AdminRepositories;
import com.msita.demo.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class AdminLoginController {
    @Autowired
    private AdminRepositories adminRepositories;
    @Autowired
    private AdminServices adminServices;
    @GetMapping("/logoutAdmin")
    public String loguot(HttpSession session){

        session.removeAttribute("loginUser");
        return "redirect:/login";


    }
    @GetMapping("/login")
    public String getLogin(Model model, HttpSession session){
        model.addAttribute("loginForm", new Admin());
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId != null) {
            return "redirect:/index";
        }
        return "login";
    }
   @PostMapping("/login")
   public String postLogin(@ModelAttribute("loginForm") Admin loginFrom, final Model model, HttpSession session){
         String email = loginFrom.getEmail();
         String password =loginFrom.getPassword();

       if (email == null || password == null) {
           model.addAttribute("errorMessage", "Please enter the username and password fields");
           return "login";
       }
       Integer loginUser = adminServices.getUserIdByEmailAndPassword(email, password);

       if (loginUser == null) {
           model.addAttribute("errorMessage", "Username or password is invalid");
           return "login";
       }
       session.setAttribute("loginUser", loginUser);

       return "redirect:/index";
   }

   }
