package com.emeraldhieu.modelmapper;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

/**
 * To avoid this error:
 * "Failed to instantiate instance of destination com.emeraldhieu.modelmapper.PizzaDto.
 * Ensure that com.emeraldhieu.modelmapper.PizzaDto has a non-private no-argument constructor.",
 *
 * @NoArgsConstructor is needed
 * To use builder, @AllArgsConstructor is needed
 */
@Builder(toBuilder = true)
@Getter
@Jacksonized
@EqualsAndHashCode
// Can't use @RequiredArgsConstructor because Model Mapper requires @NoArgsConstructor
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
// @Builder requires @AllArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class PizzaDto {
    /**
     * Can't use "final" because @NoArgsConstructor is needed for Model Mapper
     */
//    private final String name;
//    private final Ingredient ingredient;

    private String name;
    private IngredientDto ingredient;
}