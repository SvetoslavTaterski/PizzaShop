package com.example.demo.repositories;

import com.example.demo.models.Cook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql({
        "/sql/cook_data.sql"
})
public class CookRepoTest {
    @Autowired
    private CookRepo cookRepo;

    @Test
    void testFindCookByCookNumSuccess() {
        Optional<Cook> result = cookRepo.findCookByCookNum(123);
        assertThat(result.get().getFirstName())
                .isNotNull()
                .isEqualTo("John");
    }
}
