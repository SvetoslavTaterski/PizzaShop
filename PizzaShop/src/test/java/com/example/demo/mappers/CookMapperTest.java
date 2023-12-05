package com.example.demo.mappers;

import com.example.demo.dto.CookDto;
import com.example.demo.models.Cook;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class CookMapperTest {
    private final CookMapper underTest = Mappers.getMapper(CookMapper.class);

    @MethodSource("paramProvider")
    void convertDtoToEntityTest(CookDto dto, String[] emptyFields) {
        Cook result = underTest.convertDtoToEntity(dto, 1L);
        assertThat(result)
                .isNotNull()
                .hasNoNullFieldsOrPropertiesExcept(emptyFields);
    }
}
