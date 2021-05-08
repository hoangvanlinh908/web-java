package com.msita.demo.controller.admin;

import com.msita.demo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class TransactionController {
    @Autowired
    private ProductServices productServices;
    @GetMapping("/transaction")
    public String transaction(Model model, HttpSession session){
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId == null) {
            return "redirect:/login";
        }
        model.addAttribute("tran",productServices.finall1());
        return "indexTransaction";
    }
//    @GetMapping("/user-delete")
//    public  String delete(@RequestParam("id") Integer id){
//        userSevrices.delete(id);
//        return "redirect:/user" ;
//    }
}
