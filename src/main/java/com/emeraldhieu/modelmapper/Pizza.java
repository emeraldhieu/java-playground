package com.emeraldhieu.modelmapper;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Getter
@Jacksonized
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class Pizza {
    private final String name;
    private final Ingredient ingredient;
}
