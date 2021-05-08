package com.msita.demo.controller.shop;

import com.msita.demo.controller.BaseController;
import com.msita.demo.form.LoginFromUser;
import com.msita.demo.form.User;
import com.msita.demo.models.UserModel;
import com.msita.demo.services.UserSevrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ShopLogin extends BaseController {
    @Autowired
    private UserSevrices userSevrices;
    @GetMapping("/loginUser")
    public String getLogin(Model model){
        model.addAttribute("loginFormUser", new User());
        model.addAttribute("registerFormuser", new UserModel());
        return "LoginUser";

    }
    @PostMapping("/loginUser")
    public String postLogin(@ModelAttribute("loginFormUser") User loginFromUser, final Model model, HttpSession session){
        String email = loginFromUser.getEmail();
        String password =loginFromUser.getPassword();

        if (email == null || password == null) {
            model.addAttribute("errorMessage", "Please enter the username and password fields");
            return "LoginUser";
        }
        Integer loginFormUser = userSevrices.getUserIdByEmailAndPassword(email, password);
        if (loginFormUser == null) {
            model.addAttribute("errorMessage", "Username or password is invalid");
            return "LoginUser";
        }
        session.setAttribute("loginFormUser", loginFormUser);

        return "redirect:/";
    }
    @GetMapping("/register-user")
    public String registeruser(Model model){
        model.addAttribute("registerFormuser", new UserModel());
        return "registerUser";

    }
    @PostMapping("/register-user")
    public String  postRegister(@Valid @ModelAttribute("registerFormuser") UserModel userModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors())  {
            return "registerUser";
        }
        String name = userModel.getName();
        String address = userModel.getAddress();
        String email = userModel.getEmail();
        String password = userModel.getPassword();
        String phone = userModel.getPhone();
        userSevrices.createUser(new UserModel(name,address,email,password,phone));
        model.addAttribute("mess","thêm thành cong");
        return "redirect:/loginUser";


    }
    @GetMapping("/logoutUser")
    public String loguot(HttpSession session){

        session.removeAttribute("loginFormUser");
        return "redirect:/";


    }

}
