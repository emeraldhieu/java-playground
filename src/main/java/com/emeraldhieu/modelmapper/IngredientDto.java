package com.emeraldhieu.modelmapper;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@Jacksonized
@EqualsAndHashCode
// Can't use @RequiredArgsConstructor because Model Mapper requires @NoArgsConstructor
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
// @Builder requires @AllArgsConstructor
@AllArgsConstructor
class IngredientDto {
    /**
     * Can't use "final" because @NoArgsConstructor is needed for Model Mapper
     */
//    private final String name;
//    private final double price;
//    private final LocalDate expirationDate;

    private String name;
    private double price;
    private LocalDate expirationDate;
}