package com.example.shop.services;

import com.example.shop.models.Detail;
import com.example.shop.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public Detail getDetailById(Long id) {
        return detailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail not found"));
    }
}

