package com.emeraldhieu.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Employee {
    private final int id;
    private final int importanceValue;
    private final List<Integer> subordinates;
}
