package com.msita.demo.controller.admin;

import com.msita.demo.form.Admin;
import com.msita.demo.form.ListAdmin;
import com.msita.demo.models.AdminModel;
import com.msita.demo.repositories.AdminRepositories;
import com.msita.demo.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
        @Autowired
        private AdminRepositories adminRepositories;
        @Autowired
        private AdminServices adminServices;
    @GetMapping("/index")
    public String index(Model model, HttpSession session){
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId == null) {
            return "redirect:/login";
        }
         List<Admin> admins1 = adminServices.finAll();
         model.addAttribute("admin",admins1);

        return "index";
    }
    @GetMapping("/register")
    public String  getRegister(final Model model){
        model.addAttribute("registerForm", new Admin());
        return "register";


    }
    @PostMapping("/register")
    public String  postRegister(@Valid  @ModelAttribute("registerForm") Admin admin,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors())  {
            return "register";
        }
        String name = admin.getName();
        String address = admin.getAddress();
        String email = admin.getEmail();
        String password = admin.getPassword();
        String phone = admin.getPhone();
        int level = admin.getLevel();
        adminServices.createAdmin(new Admin(name,address,email,password,phone,level));
        model.addAttribute("mess","thêm thành cong");
        return "redirect:/register";


    }
    @GetMapping("/delete")
    public  String delete(@RequestParam("id") Integer id){
          adminServices.delete(id);

        return "redirect:/index" ;
    }
    @GetMapping("/edit")
    public String getEdit(@RequestParam("id") Integer id, Model model){
       List<AdminModel> adminModel = (List<AdminModel>) adminServices.getContactById(id);
        String name = adminModel.get(0).getName();
        String address = adminModel.get(0).getAddress();
        String email= adminModel.get(0).getEmail();
        String password = adminModel.get(0).getPassword();
        String phone = adminModel.get(0).getPhone();
        int level = adminModel.get(0).getLevel();
        model.addAttribute("adminModel",new AdminModel(id,name,address,email,password,phone,level));
        return "edit";

    }
    @PostMapping("/edit")
    public  String edit(@ModelAttribute("adminModel") AdminModel admin ){
//        if (bindingResult.hasErrors())  {
//            return "editProduct";
//        }
        Integer id = admin.getId();
        admin.setId(id);
        String name = admin.getName();
        admin.setName(name);
        String address = admin.getAddress();
        admin.setAddress(address);
        String email= admin.getEmail();
        admin.setEmail(email);
        String password = admin.getPassword();
        admin.setPassword(password);
        String phone = admin.getPhone();
        admin.setPhone(phone);
        int level = admin.getLevel();
        admin.setLevel(level);


     adminServices.save(admin);
        return "redirect:/index" ;

    }

}
