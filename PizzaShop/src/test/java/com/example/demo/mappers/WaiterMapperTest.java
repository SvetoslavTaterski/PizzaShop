package com.example.demo.mappers;

import com.example.demo.dto.WaiterDto;
import com.example.demo.models.Waiter;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class WaiterMapperTest {

    private final WaiterMapper underTest = Mappers.getMapper(WaiterMapper.class);

    @MethodSource("paramProvider")
    void convertDtoToEntityTest(WaiterDto dto, String[] emptyFields) {
        Waiter result = underTest.convertDtoToEntity(dto, 1L);
        assertThat(result)
                .isNotNull()
                .hasNoNullFieldsOrPropertiesExcept(emptyFields);
    }
}