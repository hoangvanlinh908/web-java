//package com.msita.demo.controller.shop;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.msita.demo.models.Cart;
//import com.msita.demo.models.CartItem;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class AjaxController {
//
//    @GetMapping("/cartdelete")
//    public @ResponseBody
//    String cartdelete(@RequestParam("id") Integer id, final Model model, HttpSession session){
//        Cart cart = (Cart) session.getAttribute("cart");
//
//
//        if (cart == null || cart.getCartItems().isEmpty()){
//            return "redirect:/";
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        String ajax="";
//        CartItem cartItem = cart.getCartItemByProductId(id);
//        if (cartItem != null){
//            cart.removeCartItem(id);
//            session.setAttribute("cart",cart);
////        model.addAttribute("cart1",num);
//
//        }
//
//
//
//        try {
//            ajax = mapper.writeValueAsString(cart);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//        return ajax;
//    }
//}
