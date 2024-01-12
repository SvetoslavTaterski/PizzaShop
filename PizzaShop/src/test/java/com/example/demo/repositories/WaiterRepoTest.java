package com.example.demo.repositories;

import com.example.demo.models.Waiter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql({
        "/sql/waiter_data.sql"
})
class WaiterRepoTest {

    @Autowired
    private WaiterRepo waiterRepo;

    @Test
    void testFindWaiterByEmployeeNumberSuccess() {
        Optional<Waiter> result = waiterRepo.findWaiterByEmployeeNumber(456);
        assertThat(result.get().getFirstName())
                .isNotNull()
                .isEqualTo("Arnold");
    }
}