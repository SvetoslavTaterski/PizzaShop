package com.example.demo.services;

import com.example.demo.dto.WaiterDto;
import com.example.demo.mappers.WaiterMapper;
import com.example.demo.mappers.WaiterMapperImpl;
import com.example.demo.models.Waiter;
import com.example.demo.repositories.WaiterRepo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes =  {WaiterService.class, WaiterMapperImpl.class})
public class WaiterServiceTest {

    @Autowired
    private WaiterService waiterService;

    @MockBean
    private WaiterRepo waiterRepo;

    @Test
    void getAllEntitiesMapToDtoTest() {
        when(waiterRepo.findAll()).thenReturn(List.of(new Waiter(1L, "Test")));
        WaiterDto waiterDto = new WaiterDto("Test", "Test", 456, 1L);

        List<WaiterDto> response = waiterService.getAllWaiters();

        assertThat(response).hasSize(1);
        assertThat(response.get(0)).isEqualTo(waiterDto);
    }
}