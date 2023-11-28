package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "cook")
@Entity
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cook_number")
    private Integer cookNum;

    @ManyToOne()
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cook_pizzas",
            joinColumns = @JoinColumn(name = "cook_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private Set<Pizza> pizzas;
}
