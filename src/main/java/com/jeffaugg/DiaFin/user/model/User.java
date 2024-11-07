package com.jeffaugg.DiaFin.user.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    private Integer age;

    @Column(precision = 15, scale = 2)
    private BigDecimal wage;

    @Column(precision = 15, scale = 2)
    private BigDecimal reserve;

}
