package com.example.demo.controllers;

import com.example.demo.dto.CookDto;
import com.example.demo.models.Cook;
import com.example.demo.services.CookService;
import com.example.demo.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CookController {

    private final CookService cookService;
    private final MessageService messageService;

    @GetMapping("/fetch/cooks")
    public List<Cook> fetchCooks() {
        return cookService.getAllCooks();
    }

    @GetMapping("/page/cooks")
    public ResponseEntity<Map<String, Object>> fetchCooks(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "5") int perPage
    ) {
        Pageable pageable = PageRequest.of(currentPage - 1, perPage);
        Page<Cook> page = cookService.getAllCooks(pageable);
        Map<String, Object> response = Map.of(
                "cooks", page.getContent(),
                "totalPages", page.getTotalPages(),
                "totalElements", page.getTotalElements()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public String getMessage(@RequestParam String msg) {
        return messageService.getMessage(msg);
    }


    @PostMapping("/save/cooks")
    public ResponseEntity<?> saveCooks(@RequestBody CookDto dto) {
        Cook savedInDb = cookService.saveCook(dto);
        return new ResponseEntity<>(savedInDb, HttpStatus.CREATED);
    }

    @PutMapping("/update/cooks")
    public ResponseEntity<?> updateCook(
            @RequestParam Long shopId,
            @RequestParam Integer cookNum
    ) {
        cookService.updateCookShop(shopId, cookNum);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/cooks/native")
    public ResponseEntity<?> updateCooksNative(
            @RequestParam Long shopId,
            @RequestParam Integer cookNum
    ) {
        cookService.updateCookShopNative(shopId, cookNum);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}
