package com.jeffaugg.DiaFin.user.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private BigDecimal wage;
    private BigDecimal reserve;
}
