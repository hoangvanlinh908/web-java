package com.msita.demo.controller.shop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msita.demo.controller.BaseController;
import com.msita.demo.form.Admin;
import com.msita.demo.form.User;
import com.msita.demo.models.*;

import com.msita.demo.services.ProductServices;
import com.msita.demo.services.UserSevrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController extends BaseController {

    @Autowired
    private ProductServices productService;
    @Autowired
    private UserSevrices userSevrices;
    @GetMapping("cart")
    public String cart(final Model model, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        model.addAttribute("cart",cart);
        if (cart == null || cart.getCartItems().isEmpty()){
            return "redirect:/";

        }
        return "cart";
    }
    @GetMapping("/cartdelete")
    public @ResponseBody
    String cartdelete(@RequestParam("id") Integer id, final Model model, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");


        if (cart == null || cart.getCartItems().isEmpty()){
            return "redirect:/";
        }
        ObjectMapper mapper = new ObjectMapper();
        String ajax="";
        CartItem cartItem = cart.getCartItemByProductId(id);
        if (cartItem != null){
            cart.removeCartItem(id);
            session.setAttribute("cart",cart);


        }

        try {
            ajax = mapper.writeValueAsString(cart);

        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }

        return ajax;
    }

//    @GetMapping("/cartdelete")
//    public String cartdelete(@RequestParam("id") Integer id,final Model model, HttpSession session){
//        Cart cart = (Cart) session.getAttribute("cart");
//
//        if (cart == null || cart.getCartItems().isEmpty()){
//            return "redirect:/";
//        }
//        cart.removeCartItem(id);
//        num = num - cart.getCartItems().get(0).getTotalPrice();
//        model.addAttribute("cart1",num);
//        session.setAttribute("cart",cart);
//        return "redirect:/cart";
//    }

    @GetMapping("/addToCart")
    public String getAddToCart(@RequestParam("id") Integer id, HttpSession session, HttpServletRequest request,Model model){

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        CartItem cartItem = cart.getCartItemByProductId(id);
        if (cartItem == null) {
            List<ProductModel> product = productService.getProductById(id);
            cart.addCartItem(new CartItem(product.get(0),  1, product.get(0).getPrice()));

        }
        else {
            cartItem.setNumber1 (cartItem.getNumber1()+1);
            cartItem.setTotalPrice(cartItem.getProduct().getPrice()*cartItem.getNumber1());
        }


       session.setAttribute("cart",cart);


        return "redirect:/cart";
    }
    @GetMapping("/thanhtoan")
    public String thanhtoan(final Model model, HttpSession session){
        Integer loginFormUser = (Integer) session.getAttribute("loginFormUser");
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("Order", new Orders());
        if (loginFormUser == null) {
            return "redirect:/loginUser";
        }

       UserModel userModel = userSevrices.getContactById(loginFormUser);
        model.addAttribute("userModelcart",userModel);
        Cart cart = (Cart) session.getAttribute("cart");
        ArrayList<CartItem> cartItem = cart.getCartItems();
        for (int i =0;i< cartItem.size() ;++i){
            num = num +cartItem.get(i).getTotalPrice();
        }
        model.addAttribute("sum",num);
        model.addAttribute("cart",cart);
        if (cart == null || cart.getCartItems().isEmpty()){
            return "redirect:/";

        }
        return "thanhtoan";
    }
    Float num = 0F;
    @PostMapping("/thanhtoan")
    public String  postRegister(Model model, @ModelAttribute("transaction") Transaction transaction ,HttpSession session ){
        Cart cart = (Cart) session.getAttribute("cart");

        ArrayList<CartItem> cartItem = cart.getCartItems();
        Integer loginFormUser = (Integer) session.getAttribute("loginFormUser");

        Integer users_id = loginFormUser;
        String note= transaction.getNote();
        Boolean status = false;
        Integer j = cart.getCartItems().size();
        Float amount =num/2;

        productService.save2(new Transaction(amount,users_id,status,note));
        session.removeAttribute("cart");
        for (int i =0;i< j ;++i){

            Integer transaction_id = productService.getTramId();
            Integer product_id = cart.getCartItems().get(i).getProduct().getId();
            Integer qty = cart.getCartItems().get(i).getNumber1();
            Float  price = cart.getCartItems().get(i).getProduct().getPrice();
            productService.save3(new Orders(transaction_id,product_id,qty,price));
        }
        return "redirect:/";


    }

}