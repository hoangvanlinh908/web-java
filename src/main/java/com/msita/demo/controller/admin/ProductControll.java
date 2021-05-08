package com.msita.demo.controller.admin;

import com.msita.demo.StringUtils;
import com.msita.demo.form.Category;
import com.msita.demo.form.Product;
import com.msita.demo.form.ProductForm;
import com.msita.demo.models.ProductModel;
import com.msita.demo.repositories.CategoryDao;
import com.msita.demo.services.CategoryServices;
import com.msita.demo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductControll {
    private final int pagesize =3;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private CategoryServices categoryServices;
    @GetMapping("/product")
    public String product(Model model, @RequestParam(value = "page", required = true, defaultValue = "1") Integer page , HttpSession session){
        Integer loginUserId = (Integer) session.getAttribute("loginUser");
        if (loginUserId == null) {
            return "redirect:/login";
        }
        model.addAttribute("productlist1",productServices.finall());
        model.addAttribute("category1",categoryServices.getAll());
       List<ProductModel> productModels = productServices.getEditProductByCategoryIdPage(pagesize,page);
       model.addAttribute("productlist",productModels);
        model.addAttribute("categories",categoryServices.getAll());
        model.addAttribute("totalPage",productServices.count()/pagesize+1);
        model.addAttribute("currentPage",page);
        return "indexProduct";
    }
    @GetMapping("/add-product")
    public  String addProduct(Model model){
        model.addAttribute("productAdd",new ProductModel());
        model.addAttribute("category",categoryServices.finall());
        return "addProduct";
    }
    @PostMapping("/add-product")
    public  String postaddproduct(@Valid @ModelAttribute("productAdd") ProductForm productForm,BindingResult bindingResult,@RequestParam("thunbar") MultipartFile thunbar1, Model model)throws IOException {
        if (bindingResult.hasErrors())  {
            return "addProduct";
        }
        String name = productForm.getName();
        final String slug = productForm.getName().toLowerCase().replaceAll(" ","-");
        String thunbar = thunbar1.getOriginalFilename().toLowerCase();
        if (!thunbar.contains(".jpg") && !thunbar.contains(".png")) {
            model.addAttribute("message", "Invalid image file");
            return "/add-product";
        }
        Path imagePath = Paths.get("src/main/resources/static/images/shop/" + thunbar);
        Files.write(imagePath, thunbar1.getBytes());
        float price = productForm.getPrice();
        float sale = productForm.getSale();
        int number = productForm.getNumber();
        Integer category_id = productForm.getCategory_id();
        Date created_ad=java.util.Calendar.getInstance().getTime();
        productServices.save(new ProductModel(name,slug,price,sale,number,thunbar,category_id));
        return "redirect:/product";

    }
    @GetMapping("/product-delete")
    public  String delete(@RequestParam("id") Integer id){
        productServices.delete(id);

        return "redirect:/product" ;
    }
    @GetMapping("/edit-product")
    public  String edit(  @RequestParam("id")Integer id, Model model){

        model.addAttribute("category",categoryServices.finall());
        List<ProductModel> productModels = productServices.getByprodcutId(id);
        String name = productModels.get(0).getName();
        String slug = productModels.get(0).getSlug();
        float price = productModels.get(0).getPrice();
        float sale = productModels.get(0).getSale();
        int number = productModels.get(0).getNumber();
        Integer category_id = productModels.get(0).getCategory_id();
        String thunbar = productModels.get(0).getThunbar();
        Date created_ad = productModels.get(0).getCreated_ad();

        model.addAttribute("editProduct",new ProductModel(id,name,slug,price,sale,number,created_ad,thunbar,category_id));
        return  "editProduct";

    }
    @PostMapping("/edit-product")
    public  String postedit(  @ModelAttribute("editProduct") ProductForm productModel,@RequestParam("thunbar") MultipartFile thunbar1, Model model)throws IOException {
//        if (bindingResult.hasErrors())  {
//            return "editProduct";
//        }
        String thunbar = null;
        if (thunbar1 != null && !thunbar1.isEmpty()) {
            thunbar = thunbar1.getOriginalFilename();
            if (!thunbar.contains(".jpg") && !thunbar.contains(".png")) {
                model.addAttribute("message", "Invalid image file");
                return "editProduct";
            }

            Optional<ProductModel> product = productServices.getByprodcutId1(productModel.getId());

          Path  oldImagePath = Paths.get("src/main/resources/static/images/shop/" + product.get().getThunbar());
           Files.delete(oldImagePath);

            Path imagePath = Paths.get("src/main/resources/static/images/shop/" + thunbar);
            Files.write(imagePath, thunbar1.getBytes());
        }


        Integer id = productModel.getCategory_id();

        String name = productModel.getName();
        productModel.setName(name);

        final String slug = productModel.getName().toLowerCase().replaceAll(" ","-");
productModel.setSlug(StringUtils.removeAccent(slug));
        float price = productModel.getPrice();
        productModel.setPrice(price);
        float sale = productModel.getSale();
        productModel.setSale(sale);

        int number = productModel.getNumber();
        productModel.setNumber(number);
        Date created_ad=java.util.Calendar.getInstance().getTime();
        productModel.setCreated_ad(created_ad);
        Integer category_id = productModel.getCategory_id();
        productModel.setCategory_id(category_id);
        productServices.save1(productModel);
        model.addAttribute("editProduct",new ProductModel(id,name,slug,price,sale,number,created_ad,thunbar,category_id));



        return "redirect:/product";
    }
}
