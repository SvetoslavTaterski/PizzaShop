package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "driver")
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "driver_number")
    private Integer driverNum;
}
