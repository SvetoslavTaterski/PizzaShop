package com.example.demo.repositories;

import com.example.demo.models.Cook;
import com.example.demo.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CookRepo extends JpaRepository<Cook, Long> {

    boolean existsCookByCookNum(Integer num);

    Optional<Cook> findCookByCookNum(Integer num);

    @Modifying
    @Query("UPDATE Cook SET shop = :shop WHERE cookNum = :cookNum")
    void updateShop(Shop shop, Integer cookNum);

    @Modifying
    @Query(value = "UPDATE cook SET shop_id = :shopId WHERE cook_number = :cookNum", nativeQuery = true)
    void updateShopNative(Long shopId, Integer cookNum);
}
