package com.example.shop.repository;

import com.example.shop.models.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetailRepository extends JpaRepository< Detail, Long> {

}

