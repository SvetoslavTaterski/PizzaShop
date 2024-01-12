package com.example.demo.services;

import com.example.demo.dto.WaiterDto;
import com.example.demo.mappers.WaiterMapper;
import com.example.demo.models.Shop;
import com.example.demo.models.Waiter;
import com.example.demo.repositories.ShopRepo;
import com.example.demo.repositories.WaiterRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WaiterService {
    private final WaiterRepo waiterRepo;
    private final WaiterMapper waiterMapper;
    private final ShopRepo shopRepo;

    public List<Waiter> getAllWaiters() {
        return waiterRepo.findAll();
    }

    public Page<Waiter> getAllWaiters(Pageable pageable) {
        return waiterRepo.findAll(pageable);
    }

    @Transactional
    public void updateWaiterShop(Long shopId, Integer employeeNumber) {
        Shop shop = shopRepo.findById(shopId).get();
        waiterRepo.updateShop(shop, employeeNumber);
    }

    @Transactional
    public void updateWaiterShopNative(Long shopId, Integer employeeNumber) {
        waiterRepo.updateShopNative(shopId, employeeNumber);
    }

    public Waiter saveWaiter(WaiterDto dto) {
        Optional<Waiter> dbObject = waiterRepo.findWaiterByEmployeeNumber(dto.employeeNumber());
        Long id;
        if (dbObject.isPresent()) {
            id = dbObject.get().getId();
            log.info("Updating Waiter with id {}", id);
        } else {
            id = null;
            log.info("Inserting new Waiter");
        }
        Waiter waiter = waiterMapper.convertDtoToEntity(dto, id);
        return waiterRepo.saveAndFlush(waiter);
    }
}