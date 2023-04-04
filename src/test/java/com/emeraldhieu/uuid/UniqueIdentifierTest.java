package com.emeraldhieu.uuid;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueIdentifierTest {

    private final UniqueIdentifier uniqueIdentifier = new UniqueIdentifier();

    @Test
    public void whenGeneratingId_thenIdIsGood() {
        // WHEN
        var id = uniqueIdentifier.getId();

        // THEN
        assertEquals(11, id.length());
    }

    @Test
    public void whenGeneratingRandomNumbers_thenNoNumberIsDuplicated() {
        // WHEN
        var futures = IntStream.range(0, 10000)
            .mapToObj(value ->
                CompletableFuture.supplyAsync(() -> uniqueIdentifier.getNumber()))
            .collect(Collectors.toList());
        var results = allOf(futures).join();

        // THEN
        Map<Long, Long> occurrencesById = results.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurrencesById.entrySet()
            .forEach(entry ->
                assertEquals(1, entry.getValue(), "%s is duplicated".formatted(entry.getKey())));
    }

    @Test
    public void whenGeneratingIdsInParallel_thenNoIdIsDuplicated() {
        // WHEN
        var futures = IntStream.range(0, 10000)
            .mapToObj(value ->
                CompletableFuture.supplyAsync(() -> uniqueIdentifier.getId()))
            .collect(Collectors.toList());
        var results = allOf(futures).join();

        // THEN
        Map<String, Long> occurrencesById = results.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurrencesById.entrySet()
            .forEach(entry ->
                assertEquals(1, entry.getValue(), "%s is duplicated".formatted(entry.getKey())));
    }

    public <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
            CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        return allFuturesResult.thenApply(v ->
            futuresList.stream().
                map(future -> future.join()).
                collect(Collectors.<T>toList())
        );
    }
}