package com.example.demo.services;

import com.example.demo.dto.CookDto;
import com.example.demo.mappers.CookMapper;
import com.example.demo.mappers.CookMapperImpl;
import com.example.demo.models.Cook;
import com.example.demo.repositories.CookRepo;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes =  {CookService.class, CookMapperImpl.class})
public class CookServiceTest {

    @Autowired
    private CookService cookService;

    @MockBean
    private CookRepo cookRepo;

    @Test
    void getAllEntitiesMapToDtoTest(){
        //when(cookRepo.findAll()).thenReturn(List.of(new Cook(1L,"Test")));
       //CookDto cookDto = new CookDto("Test","Test",123,1L);

        //List<CookDto> response = cookService.getAllCooks();

        //assertThat(response).hasSize(1);
        //assertThat(response.get(0)).isEqualTo(cookDto);
    }
}
