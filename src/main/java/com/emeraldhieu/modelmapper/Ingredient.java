package com.emeraldhieu.modelmapper;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
@Jacksonized
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Ingredient {
    private final String name;
    private final double price;
    private final LocalDate expiryDate;
}
