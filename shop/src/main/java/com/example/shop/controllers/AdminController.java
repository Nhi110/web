package com.example.shop.controllers;


import com.example.shop.models.ProductPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.shop.repository.ProductsPageRepository;
import com.example.shop.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductsPageRepository productRepository;

    @Autowired
    private ProductService productService;


    @GetMapping("/product_page")
    public String viewProducts(Model model) {
        model.addAttribute("productPage", productRepository.findAll());
        return "products/admin";
    }


    @GetMapping("/product_page/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("productPage", new ProductPage());
        return "products/admin_add_product";
    }


    @PostMapping("/product_page/save")
    public String saveProduct(@ModelAttribute("productPage") ProductPage productPage) {
        productService.saveProduct(productPage);
        return "redirect:/admin/product_page";
    }


    @GetMapping("/product_page/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        ProductPage productPage = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("productPage", productPage);
        return "products/editProduct";
    }


    @PostMapping("/product_page/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @ModelAttribute("product") ProductPage productPage) {
        productPage.setId(id);
        productRepository.save(productPage);
        return "redirect:/admin/product_page";
    }


    @GetMapping("/product_page/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
        return "redirect:/admin/product_page";
    }
}

