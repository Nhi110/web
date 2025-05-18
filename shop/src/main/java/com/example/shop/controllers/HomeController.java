package com.example.shop.controllers;

import com.example.shop.models.Home;
import com.example.shop.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeRepository repo;

    @GetMapping({"", "/"})
    public String productPage(Model model) {
        List<Home> productPage = repo.findAll();
        model.addAttribute("productPage", productPage);
        return "products/home";
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("productPage", repo.findByNameContainingIgnoreCase(name));
            model.addAttribute("searchKeyword", name);
        } else {
            model.addAttribute("productPage", repo.findAll());
        }
        return "products/search";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "products/contact";
    }
    @GetMapping("/cart")
    public String cartPage(){
        return "products/cart";
    }
}