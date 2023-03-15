package com.emeraldhieu.stream.practice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Order {
    private Long id;

    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;

    private Customer customer;

    List<Product> products;
}