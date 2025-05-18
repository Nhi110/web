package com.example.shop.services;

import com.example.shop.models.ProductPage;
import com.example.shop.repository.ProductsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsPageService {

    @Autowired
    private ProductsPageRepository productsPageRepository;


    public List<ProductPage> findAll() {
        return productsPageRepository.findAll();
    }


    public ProductPage findById(int id) {
        Optional<ProductPage> productPage = productsPageRepository.findById(id);
        return productPage.orElse(null);
    }


    public ProductPage create(ProductPage productPage) {
        return productsPageRepository.save(productPage);
    }


    public ProductPage save(ProductPage productPage) {
        return productsPageRepository.save(productPage);
    }


    public void delete(int id) {
        productsPageRepository.deleteById(id);
    }
}

