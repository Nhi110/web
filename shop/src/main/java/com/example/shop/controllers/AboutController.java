package com.example.shop.controllers;

import com.example.shop.models.ProductPage;
import com.example.shop.repository.ProductsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private ProductsPageRepository repo;

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        List<ProductPage> productPage = repo.findAll();
        model.addAttribute("productPage", productPage);
        return "products/about";
    }
}
