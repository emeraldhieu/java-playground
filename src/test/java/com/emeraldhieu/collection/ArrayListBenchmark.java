package com.emeraldhieu.collection;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
public class ArrayListBenchmark {

    @Benchmark
    public void testAdd(ArrayListBenchmark.MyState state) {
        state.employeeList.add(new Employee(state.iterations + 1, "John"));
    }

    @Benchmark
    public void testAddAt(ArrayListBenchmark.MyState state) {
        state.employeeList.add((int) (state.iterations), new Employee(state.iterations, "John"));
    }

    @Benchmark
    public boolean testContains(ArrayListBenchmark.MyState state) {
        return state.employeeList.contains(state.employee);
    }

    @Benchmark
    public int testIndexOf(ArrayListBenchmark.MyState state) {
        return state.employeeList.indexOf(state.employee);
    }

    @Benchmark
    public Employee testGet(ArrayListBenchmark.MyState state) {
        return state.employeeList.get(state.employeeIndex);
    }

    @Benchmark
    public boolean testRemove(ArrayListBenchmark.MyState state) {
        return state.employeeList.remove(state.employee);
    }

    @State(Scope.Thread)
    public static class MyState {

        List<Employee> employeeList = new ArrayList<>();

        long iterations = 1000;

        Employee employee = new Employee(100L, "Harry");

        int employeeIndex = -1;

        @Setup(Level.Trial)
        public void setUp() {
            for (long i = 0; i < iterations; i++) {
                employeeList.add(new Employee(i, "John"));
            }

            employeeList.add(employee);
            employeeIndex = employeeList.indexOf(employee);
        }
    }
}