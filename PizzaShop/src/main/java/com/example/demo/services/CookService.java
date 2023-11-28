package com.example.demo.services;

import com.example.demo.dto.CookDto;
import com.example.demo.mappers.CookMapper;
import com.example.demo.models.Cook;
import com.example.demo.repositories.CookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CookService {
    private final CookRepo cookRepo;
    private final CookMapper cookMapper;

    public List<Cook> getAllCooks() {
        return cookRepo.findAll();
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
