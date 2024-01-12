package com.example.demo.repositories;

import com.example.demo.models.Shop;
import com.example.demo.models.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WaiterRepo extends JpaRepository<Waiter, Long> {

    boolean existsWaiterByEmployeeNumber(Integer employeeNumber);

    Optional<Waiter> findWaiterByEmployeeNumber(Integer employeeNumber);

    @Modifying
    @Query("UPDATE Waiter SET shop = :shop WHERE employeeNumber = :employeeNumber")
    void updateShop(Shop shop, Integer employeeNumber);

    @Modifying
    @Query(value = "UPDATE waiter SET shop_id = :shopId WHERE employee_number = :employeeNumber", nativeQuery = true)
    void updateShopNative(Long shopId, Integer employeeNumber);
}