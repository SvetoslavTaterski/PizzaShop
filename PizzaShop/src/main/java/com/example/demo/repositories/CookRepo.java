package com.example.demo.repositories;

import com.example.demo.models.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CookRepo extends JpaRepository<Cook, Long> {

    boolean existsCookByCookNum(Integer num);

    Optional<Cook> findCookByCookNum(Integer num);
}
