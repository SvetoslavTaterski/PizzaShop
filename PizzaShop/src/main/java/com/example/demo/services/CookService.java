package com.example.demo.services;

import com.example.demo.dto.CookDto;
import com.example.demo.mappers.CookMapper;
import com.example.demo.models.Cook;
import com.example.demo.models.Shop;
import com.example.demo.repositories.CookRepo;
import com.example.demo.repositories.ShopRepo;
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
public class CookService {
    private final CookRepo cookRepo;
    private final CookMapper cookMapper;
    private final ShopRepo shopRepo;

    public List<Cook> getAllCooks() {
        return cookRepo.findAll();
    }

    public Page<Cook> getAllCooks(Pageable pageable) {
        return cookRepo.findAll(pageable);
    }

    @Transactional
    public void updateCookShop(Long shopId, Integer cookNum) {
        Shop shop = shopRepo.findById(shopId).get();
        cookRepo.updateShop(shop, cookNum);
    }

    @Transactional
    public void updateCookShopNative(Long shopId, Integer cookNum) {
        cookRepo.updateShopNative(shopId, cookNum);
    }

    public Cook saveCook(CookDto dto) {
        Optional<Cook> dbObject = cookRepo.findCookByCookNum(dto.cookNum());
        Long id;
        if(dbObject.isPresent()) {
            id = dbObject.get().getId();
            log.info("Updating Cook with id {}", id);
        } else {
            id = null;
            log.info("Inserting new Cook");
        }
        Cook cook = cookMapper.convertDtoToEntity(dto, id);
        return cookRepo.saveAndFlush(cook);
    }

}
