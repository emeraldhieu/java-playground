package com.emeraldhieu.employee;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeImportance {

    public int getImportanceValue(List<Employee> employees, int id) {
        Map<Integer, Employee> employeesById = employees.stream()
            .collect(Collectors.toMap(Employee::getId, Function.identity()));
        return getImportanceValue(employeesById, employees, id);
    }

    private int getImportanceValue(Map<Integer, Employee> employeesById,
                                          List<Employee> employees, int id) {
        if (employees.isEmpty()) {
            return 0;
        }

        Employee employee = employeesById.get(id);
        int importanceValue = employee.getImportanceValue();
        List<Integer> childIds = employee.getSubordinates();
        List<Employee> childEmployees = getEmployees(employeesById, childIds);

        int importanceValueOfChildren = 0;
        for (Employee childEmployee : childEmployees) {
            int childId = childEmployee.getId();
            int importanceValueOfGrandChildren = getImportanceValue(employeesById, employees, childId);
            importanceValueOfChildren += importanceValueOfGrandChildren;
        }
        return importanceValue + importanceValueOfChildren;
    }

    private List<Employee> getEmployees(Map<Integer, Employee> employeesById,
                                               List<Integer> ids) {
        return ids.stream()
            .map(id -> employeesById.get(id))
            .collect(Collectors.toList());
    }
}
