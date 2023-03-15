package com.emeraldhieu.stream.practice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private Integer tier;
}
