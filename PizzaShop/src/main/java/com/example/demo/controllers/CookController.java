package com.example.demo.controllers;

import com.example.demo.dto.CookDto;
import com.example.demo.models.Cook;
import com.example.demo.services.CookService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CookController {
    private final CookService cookService;

    @GetMapping("/fetch/cooks")
    public List<Cook> fetchCooks() {
        return cookService.getAllCooks();
    }


    @PostMapping("/save/cooks")
    public ResponseEntity<?> saveCooks(@RequestBody CookDto dto) {
        Cook savedInDb = cookService.saveCook(dto);
        return new ResponseEntity<>(savedInDb, HttpStatus.CREATED);
    }
}
