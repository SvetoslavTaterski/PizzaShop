package com.example.demo.mappers;

import com.example.demo.dto.WaiterDto;
import com.example.demo.models.Waiter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WaiterMapper {
    
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "employeeNumber", source = "dto.employeeNumber")
    Waiter convertDtoToEntity(WaiterDto dto, Long id);
}