package com.msita.demo.controller.admin;


import com.msita.demo.StringUtils;
import com.msita.demo.form.Category;
import com.msita.demo.form.EditCategory;
import com.msita.demo.models.CategoryModel;
import com.msita.demo.repositories.CategoryModelDao;
import com.msita.demo.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/category")
    public String Category(final Model model, HttpSession session){
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId == null) {
            return "redirect:/login";
        }
        model.addAttribute("category",categoryServices.finall());
        return "indexCategory";
    }
    @GetMapping("/add-category")
    public String getCategory(final Model model, Category category){
        model.addAttribute("categoryAdd",new Category());
        return "addCategory";
    }
    @PostMapping("/add-category")
    public String addCategory(@Valid @ModelAttribute("categoryAdd") Category category,BindingResult bindingResult){
        if (bindingResult.hasErrors())  {
            return "addCategory";
        }
        String name = category.getName();
        final String slug = category.getName().toLowerCase().replaceAll(" ","-");
        Date created_at=java.util.Calendar.getInstance().getTime();
        categoryServices.addCategory(new Category(name,StringUtils.removeAccent(slug),created_at));
      return "redirect:/category";
    }
    @GetMapping("/category-delete")
    public  String delete(@RequestParam("id") Integer id){
        categoryServices.delete(id);
        return "redirect:/category" ;
    }
    @GetMapping("/edit-category")
    public  String editcategory(@RequestParam("id") Integer id, Model model){
        List<CategoryModel> categoryModel = categoryServices.getcategoryByid(id);
        String name = categoryModel.get(0).getName();
        String slug = categoryModel.get(0).getSlug();
        Boolean home = categoryModel.get(0).isHome();
        Date created_at = categoryModel.get(0).getCreated_at();
        model.addAttribute("editcategory",new CategoryModel(id,name,slug,home,created_at));
        return "editcategory";
    }
    @PostMapping("/edit-category")
        public  String postEdit(@ModelAttribute("editcategory") CategoryModel editCategory){
        Integer id = editCategory.getId();
        editCategory.setId(id);
        String name = editCategory.getName();
        editCategory.setName(name);
        final String slug = editCategory.getName().toLowerCase().replaceAll(" ","-");
        editCategory.setSlug(StringUtils.removeAccent(slug));
        Date created_at=java.util.Calendar.getInstance().getTime();
        editCategory.setCreated_at(created_at);
        categoryServices.save(editCategory);
      return "redirect:/category";
    }





}
