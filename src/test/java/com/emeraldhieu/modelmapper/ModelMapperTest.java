package com.emeraldhieu.modelmapper;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTest {

    @Test
    void givenEntity_whenMap_thenValuesAreEqual() {
        // GIVEN
        var pizza = Pizza.builder()
                .name("pepperoni")
                .ingredient(Ingredient.builder()
                        .name("cheese")
                        .price(42d)
                        .expiryDate(LocalDate.of(2024, 1, 1))
                        .build())
                .build();

        var modelMapper = new ModelMapper();

        // Can't do because PizzaDto doesn't have a setter.
//        modelMapper.typeMap(Pizza.class, PizzaDto.class).addMappings(mapper -> {
//            mapper.map(src -> src.getIngredient().getExpiryDate(),
//                    (pizzaDto, o) -> {
//                        // PizzaDto doesn't have a setter!
//
//                    });
//        });

        // WHEN
        var pizzaDto = modelMapper.map(pizza, PizzaDto.class);

        // THEN
        assertEquals(pizza.getName(), pizzaDto.getName());
        assertEquals(pizza.getIngredient().getName(), pizzaDto.getIngredient().getName());
        assertEquals(pizza.getIngredient().getPrice(), pizzaDto.getIngredient().getPrice());

        // Can't map #expiryDate to #expirationDate because ReferenceMapExpression#map requires DestinationSetter that requires a setter.
        //assertEquals(pizza.getIngredient().getExpiryDate(), pizzaDto.getIngredient().getExpirationDate());
    }
}
