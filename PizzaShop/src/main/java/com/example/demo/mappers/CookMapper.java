package com.example.demo.mappers;

import com.example.demo.dto.CookDto;
import com.example.demo.models.Cook;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CookMapper {
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "cookNum", source = "dto.cookNum")
    Cook convertDtoToEntity(CookDto dto, Long id);
}
