package com.emeraldhieu.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Jacksonized
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Pizza {

    private final Long id;
    private final String name;
    private final String type;

    @Builder.Default
    @JsonAlias("vegan")
    private final boolean isVegan = false;

    @Builder.Default
    private final List<Ingredient> ingredients = new ArrayList<>();
}
