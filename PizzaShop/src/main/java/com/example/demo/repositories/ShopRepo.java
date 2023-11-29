package com.example.demo.repositories;

import com.example.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {

}
