package com.emeraldhieu.stream;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        // Empty stream.
        Stream<String> emptyString = Stream.empty();

        // Stream of collection.
        Collection<String> stringCollection = Arrays.asList("apple", "orange", "guava");
        Stream<String> stringStream = stringCollection.stream();

        // Stream of values.
        Stream<String> stringStream1 = Stream.of("apple", "orange", "guava");

        // Stream of array.
        String[] arr = new String[]{"apple", "orange", "guava"};
        Stream<String> stringStream2 = Arrays.stream(arr);

        // Stream builder.
        Stream<String> stringStream3 = Stream.<String>builder()
            .add("apple")
            .add("orange")
            .add("guava")
            .build();

        // Stream#generate.
        Stream<String> generatedStream = Stream.generate(() -> "orange").limit(10);

        // Stream#iterate
        Stream<Integer> iteratedStream = Stream.iterate(40, n -> n + 2).limit(10);

        // Stream of primitives.
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        // Random stream.
        Random random = new Random();
        IntStream intStream1 = random.ints();
        DoubleStream doubleStream = random.doubles(3);

        // Stream of characters.
        IntStream charStream = "abc".chars();

        // Stream of characters by splitting.
        Stream<String> charStream1 =
            Pattern.compile(", ").splitAsStream("a, b, c");

        // Stream pipeline.
        long count = Stream.of("abcd", "bbcd", "cbcd", "cbcd")
            .skip(1)
            .map(element -> element.substring(0, 3))
            .distinct()
            .count();

        // Lazy invocation
        List<String> list1 = Arrays.asList("guava", "apple", "orange");
        Optional<String> stream = list1.stream()
            .filter(element -> {
                System.out.println("filter() was called");
                return element.contains("e");
            }).map(element -> {
                System.out.println("map() was called");
                return element.toUpperCase();
            })
            .findFirst();

        // Order of execution
        long size = list1.stream().skip(2).map(element -> {
            System.out.println("map() was called");
            return element.substring(0, 3);
        }).count();
        // is faster than...
        long size2 = list1.stream().map(element -> {
            System.out.println("map() was called");
            return element.substring(0, 3);
        }).skip(2).count();
        // because the first snippet skip elements before mapping.

        // Stream reduction.
        OptionalInt reduced =
            IntStream.range(1, 4).reduce((a, b) -> a + b);

        int reducedParams = Stream.of(1, 2, 3)
            .reduce(10, (a, b) -> a + b, (a, b) -> {
                System.out.println("combiner was called");
                return a + b;
            });

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
            .reduce(10, (a, b) -> a + b, (a, b) -> {
                System.out.println("combiner was called");
                return a + b;
            });

        // Collecting.
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
            new Product(14, "orange"), new Product(13, "lemon"),
            new Product(23, "bread"), new Product(13, "sugar"));

        String listToString = productList.stream().map(Product::getName)
            .collect(Collectors.joining(", ", "[", "]"));

        double averagePrice = productList.stream()
            .collect(Collectors.averagingLong(Product::getPrice));

        int summingPrice = productList.stream()
            .collect(Collectors.summingInt(Product::getPrice));
        // has the same result with this.
        int summingPrice2 = productList.stream()
            .map(Product::getPrice)
            .mapToInt(Integer::intValue)
            .sum();

        // Collect statistics.
        IntSummaryStatistics statistics = productList.stream()
            .collect(Collectors.summarizingInt(Product::getPrice));

        // Grouping of stream's elements.
        Map<Integer, List<Product>> groupedProducts = productList.stream()
            .collect(Collectors.groupingBy(Product::getPrice));

        // Partition a list.
        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
            .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        // Perform additional transformation.
        Function<Set<Product>, Set<Product>> finisher = products -> Collections.unmodifiableSet(products);
        Set<Product> unmodifiableSet =
            productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                    finisher));

        // Custom collector.
        Collector<Product, ?, LinkedList<Product>> toLinkedList =
            Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
        LinkedList<Product> linkedListOfPersons =
            productList.stream().collect(toLinkedList);

        // Parallel streams
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean bigPrice = streamOfCollection
            .map(product -> product.getPrice() * 12)
            .anyMatch(price -> price > 200);
    }
}
