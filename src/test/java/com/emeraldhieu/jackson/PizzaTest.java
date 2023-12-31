package com.emeraldhieu.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void serializationAndDeserialization() throws IOException {
        // GIVEN
        var pizza = Pizza.builder()
                .name("pepperoni")
                .isVegan(true)
                .ingredients(List.of(
                        Ingredient.builder()
                                .name("John")
                                .build()
                ))
                .build();

        var json = objectMapper.writeValueAsString(pizza);
        System.out.println(json);

        // WHEN
        var deserializedPizza = objectMapper.readValue(json, Pizza.class);

        // THEN
        assertEquals(pizza.getName(), deserializedPizza.getName());
        assertTrue(deserializedPizza.isVegan());
        assertEquals(pizza.getIngredients().get(0).getName(),
                deserializedPizza.getIngredients().get(0).getName());
    }
}