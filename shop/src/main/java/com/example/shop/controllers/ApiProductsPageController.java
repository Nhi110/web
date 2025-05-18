package com.example.shop.controllers;

import com.example.shop.models.ProductPage;
import com.example.shop.services.ProductsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProductsPageController {

    @Autowired
    private ProductsPageService productsPageService;


    @GetMapping("/product_page")
    public List<ProductPage> getProductList() {
        return productsPageService.findAll();
    }

    @GetMapping("/product_page/{id}")
    public ResponseEntity<ProductPage> getProductById(@PathVariable("id") int productId) {
        ProductPage productPage = productsPageService.findById(productId);
        if (productPage != null) {
            return ResponseEntity.status(200).body(productPage);
        }
        return ResponseEntity.status(404).body(null);
    }


    @DeleteMapping("/product_page/{id}")
    public ResponseEntity<List<ProductPage>> deleteProductById(@PathVariable("id") int productId) {
        productsPageService.delete(productId);
        return ResponseEntity.status(200).body(productsPageService.findAll());
    }


    @PostMapping("/product_page")
    public ResponseEntity<ProductPage> createProductById(@RequestBody ProductPage productPage) {
        ProductPage savedProduct = productsPageService.create(productPage);
        return ResponseEntity.status(201).body(savedProduct);
    }


    @PutMapping("/product_page/{id}")
    public ResponseEntity<ProductPage> updateProductById(@PathVariable("id") int productId, @RequestBody ProductPage updateProduct) {
        ProductPage productPage = productsPageService.findById(productId);
        if (productPage != null) {

            productPage.setName(updateProduct.getName());
            productPage.setPrice(updateProduct.getPrice());
            productPage.setPrice1(updateProduct.getPrice1());
            productPage.setSales(updateProduct.getSales());
            productPage.setPercent(updateProduct.getPercent());
            productPage.setImageFilename(updateProduct.getImageFilename());
            productPage.setTitle(updateProduct.getTitle());
            productsPageService.save(productPage);
            return ResponseEntity.status(200).body(productPage);
        }
        return ResponseEntity.status(404).body(null);
    }
}
