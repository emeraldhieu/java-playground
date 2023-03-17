package com.emeraldhieu.employee;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeImportanceTest {

    private final EmployeeImportance employeeImportance = new EmployeeImportance();

    @Test
    public void case1() {
        // GIVEN
        List<Employee> employees = List.of(
            new Employee(1, 5, List.of(2, 3)),
            new Employee(2, 3, List.of()),
            new Employee(3, 3, List.of())
        );

        // WHEN
        int result = employeeImportance.getImportanceValue(employees, 1);

        // THEN
        assertEquals(11, result);
    }

    @Test
    public void case2() {
        // GIVEN
        List<Employee> employees = List.of(
            new Employee(1, 5, List.of(2)),
            new Employee(2, 3, List.of(3)),
            new Employee(3, 3, List.of())
        );

        // WHEN
        int result = employeeImportance.getImportanceValue(employees, 1);

        // THEN
        assertEquals(11, result);
    }

    @Test
    public void case3() {
        // GIVEN
        List<Employee> employees = List.of(
            new Employee(1, 2, List.of(5)),
            new Employee(5, -3, List.of())
        );

        // WHEN
        int result = employeeImportance.getImportanceValue(employees, 5);

        // THEN
        assertEquals(-3, result);
    }
}