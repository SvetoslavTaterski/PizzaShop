package com.example.demo.controllers;

import com.example.demo.dto.WaiterDto;
import com.example.demo.models.Waiter;
import com.example.demo.services.WaiterService;
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
public class WaiterController {

    private final WaiterService waiterService;
    private final MessageService messageService;

    @GetMapping("/fetch/waiters")
    public List<Waiter> fetchWaiters() {
        return waiterService.getAllWaiters();
    }

    @GetMapping("/page/waiters")
    public ResponseEntity<Map<String, Object>> fetchWaiters(
            @RequestParam(required = false, defaultValue = "1") int currentPage,
            @RequestParam(required = false, defaultValue = "5") int perPage
    ) {
        Pageable pageable = PageRequest.of(currentPage - 1, perPage);
        Page<Waiter> page = waiterService.getAllWaiters(pageable);
        Map<String, Object> response = Map.of(
                "waiters", page.getContent(),
                "totalPages", page.getTotalPages(),
                "totalElements", page.getTotalElements()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save/waiters")
    public ResponseEntity<?> saveWaiters(@RequestBody WaiterDto dto) {
        Waiter savedInDb = waiterService.saveWaiter(dto);
        return new ResponseEntity<>(savedInDb, HttpStatus.CREATED);
    }

    @PutMapping("/update/waiters")
    public ResponseEntity<?> updateWaiter(
            @RequestParam Long shopId,
            @RequestParam Integer employeeNumber
    ) {
        waiterService.updateWaiterShop(shopId, employeeNumber);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/waiters/native")
    public ResponseEntity<?> updateWaitersNative(
            @RequestParam Long shopId,
            @RequestParam Integer employeeNumber
    ) {
        waiterService.updateWaiterShopNative(shopId, employeeNumber);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }
}