package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "waiter")
@Entity
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_number")
    private Integer employeeNumber;

    @ManyToOne()
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "waiter_pizzas",
            joinColumns = @JoinColumn(name = "waiter_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private Set<Pizza> pizzas;
}