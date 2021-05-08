package com.msita.demo.controller.shop;

import com.msita.demo.controller.BaseController;
import com.msita.demo.form.Product;
import com.msita.demo.form.Seach;
import com.msita.demo.models.ProductModel;
import com.msita.demo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopController extends BaseController {
    @Autowired
    private ProductServices productServices;
    @GetMapping("/")
    public String shop(Model model){
        List<ProductModel> productModel1 = productServices.getEditProductBylimit12();
        List<ProductModel> productModel2 = productServices.getEditProductBylimit123();
        model.addAttribute("shop2",productModel1);
        model.addAttribute("shop3",productModel2);

        return "shop";
    }
    @GetMapping("/deltail-id")
    public String deltail(@RequestParam("id") Integer id,Model model){
        List<ProductModel> productModels1 = productServices.getByprodcutId(id);
        model.addAttribute("deltail",productModels1);

        return "deltail";

    }
    @GetMapping("/productCategory")
    public String getCategory(@RequestParam("id") Integer id, Model model, HttpSession session){
        List<ProductModel> productModels1 = productServices.getEditProductBylimit9(id);
            model.addAttribute("productid",productModels1);
        return "shop-product";
    }
    @GetMapping("/search")
    public String shopSearch(Model model, HttpSession session){
        String name = (String) session.getAttribute("search1");
        List<Product> products = productServices.searchByNameLike(name);
        model.addAttribute("search2",products);
        return "shop-product1";
    }
    @PostMapping("/search")
    public String getSearch(@ModelAttribute("search") Seach search,Model model,HttpSession session) {
        String name = search.getName();
        if (name == null)
        {
            model.addAttribute("mess9","ko có sản phẩm ");
        }
        session.setAttribute("search1", name);
        return "redirect:/search";
    }

}