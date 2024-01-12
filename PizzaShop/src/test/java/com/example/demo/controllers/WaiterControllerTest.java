package com.example.demo.controllers;

import com.example.demo.models.Waiter;
import com.example.demo.services.WaiterService;
import com.example.demo.services.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WaiterController.class)
public class WaiterControllerTest {

    @MockBean
    private WaiterService waiterService;

    @MockBean
    private MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void pageWaitersDefaultValuesOkTest() throws Exception {
        when(waiterService.getAllWaiters(any())).thenReturn(getWaiterPage());
        mockMvc.perform(get("/page/waiters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(1));
    }

    private Page<Waiter> getWaiterPage() {
        Pageable pageable = PageRequest.of(0, 5);
        return new PageImpl<>(List.of(new Waiter()), pageable, 1L);
    }
}