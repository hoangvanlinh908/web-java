package com.msita.demo.controller.admin;

import com.msita.demo.services.UserSevrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserSevrices userSevrices;
    @GetMapping("/user")
    public String user(Model model, HttpSession session){
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId == null) {
            return "redirect:/login";
        }
        model.addAttribute("user",userSevrices.finall());
        return "indexUser";
    }
    @GetMapping("/user-delete")
    public  String delete(@RequestParam("id") Integer id){
            userSevrices.delete(id);
        return "redirect:/user" ;
    }
}
