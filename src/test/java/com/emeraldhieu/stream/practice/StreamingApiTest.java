package com.emeraldhieu.stream.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is intended for testing my Streaming API's knowledge.
 * See https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
 */
class StreamingApiTest {

    private Customer john;
    private Customer jane;
    private Customer jack;
    private Product pizza;
    private Product burger;
    private Product toKillAMockingBird;
    private Product huggies;
    private Product pasta;
    private Product nineteenEightyFour;
    private Product everythingIsFck;
    private Product pampers;
    private Product johnson;
    private List<Product> products;
    private Order order1;
    private Order order2;
    private Order order3;
    private Order order4;
    private Order order5;
    private Order order6;
    private Order order7;
    private Order order8;
    private List<Order> orders;
    private Product lego;
    private Product rubik;
    private Order order9;
    private Order order10;

    @BeforeEach
    public void setUp() {
        // Prepare data
        john = createCustomer(42L, "John", 1);
        jane = createCustomer(666L, "Jane", 2);
        jack = createCustomer(18L, "Jack", 2);

        pizza = createProduct(1L, "Pizza", "food", 42);
        burger = createProduct(2L, "Burger", "food", 666);
        toKillAMockingBird = createProduct(2L, "To Kill a Mocking Bird", "book", 200);
        huggies = createProduct(3L, "Huggies", "baby", 13);
        rubik = createProduct(10L, "Rubik", "toy", 100);
        pasta = createProduct(4L, "Pasta", "food", 18);
        nineteenEightyFour = createProduct(5L, "1984", "book", 19);
        everythingIsFck = createProduct(6L, "Everything is fck", "book", 422);
        pampers = createProduct(7L, "Pampers", "baby", 399);
        johnson = createProduct(8L, "Johnson's", "baby", 84);
        lego = createProduct(9L, "Lego", "toy", 1000);
        products = List.of(pizza, burger, toKillAMockingBird, huggies, rubik, pasta, nineteenEightyFour,
            everythingIsFck, pampers, johnson, lego);

        order1 = createOrder(42L, john, List.of(pizza, burger), LocalDate.of(2023, 11, 20));
        order2 = createOrder(42L, jane, List.of(burger), LocalDate.of(2022, 06, 07));
        order3 = createOrder(42L, jack, List.of(pizza, burger, pasta), LocalDate.of(2024, 02, 13));
        order4 = createOrder(42L, john, List.of(pizza, burger, huggies), LocalDate.of(2024, 04, 13));
        order5 = createOrder(42L, john, List.of(pizza, pampers, pasta, huggies), LocalDate.of(2024, 02, 13));
        order6 = createOrder(42L, john, List.of(pizza, burger, johnson), LocalDate.of(2024, 03, 13));
        order7 = createOrder(42L, john, List.of(pizza), LocalDate.of(2021, 03, 15));
        order8 = createOrder(42L, john, List.of(pizza, pasta), LocalDate.of(2021, 03, 15));
        order9 = createOrder(42L, jane, List.of(pizza, burger), LocalDate.of(2021, 02, 02));
        order10 = createOrder(42L, jane, List.of(pizza, toKillAMockingBird), LocalDate.of(2021, 02, 20));
        orders = List.of(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10);
    }

    // Exercise 1 — Obtain a list of products belongs to category “book” with price > 100
    @Test
    public void booksWhosePriceIsGreaterThan100() {
        // WHEN
        List<Product> result = products.stream()
            .filter(product -> product.getCategory().equals("book") && product.getPrice() > 100)
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(toKillAMockingBird, everythingIsFck), result);
    }

    // Exercise 2 — Obtain a list of order with products belong to category “baby”
    @Test
    public void ordersWhoseProductsBelongToCategoryBaby() {
        // WHEN
        List<Order> result = orders.stream()
            .filter(order -> order.products.stream()
                .anyMatch(product -> product.getCategory().equals("baby"))
            )
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(order4, order5, order6), result);
    }

    // Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
    @Test
    public void productsWhoseCategoryIsToyAndDiscountIs10Percent() {
        // WHEN
        List<Product> result = products.stream()
            .filter(product -> product.getCategory().equals("toy"))
            .map(product -> {
                product.setPrice(product.getPrice() * 0.9);
                return product;
            })
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(rubik, lego), result);
        assertEquals(90, result.get(0).getPrice());
        assertEquals(900, result.get(1).getPrice());
    }

    // Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    @Test
    public void productsOrderedByCustomerTier2BetweenATimeRange() {
        // WHEN
        List<Product> result = orders.stream()
            .filter(order -> order.getCustomer().getTier() == 2)
            .filter(order -> !order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1))
                && !order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1))
            )
            .flatMap(order -> order.getProducts().stream())
            .distinct()
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(pizza, burger, toKillAMockingBird), result);
    }

    // Exercise 5 — Get the cheapest products of “Books” category
    @Test
    public void cheapestBook() {
        // WHEN
        var result = products.stream()
            .filter(product -> product.getCategory().equals("book"))
            .sorted(Comparator.comparing(Product::getPrice))
            .findFirst()
            .get();

        // THEN
        assertEquals(nineteenEightyFour, result);
    }

    // Exercise 6 — Get the 3 most recent placed order
    @Test
    public void theMostThreeRecentOrders() {
        // WHEN
        var result = orders.stream()
            .sorted(Comparator.comparing(Order::getOrderDate).reversed())
            .limit(3)
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(order4, order6, order3), result);
    }

    // Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021,
    // log the order records to the console and then return its product list
    @Test
    public void ordersPlacedOnAGivenDateAndProductsLoggedInTheImddl() {
        // WHEN
        var result = orders.stream()
            .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
            .peek(order -> System.out.println(order))
            .map(Order::getProducts)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());

        // THEN
        assertEquals(List.of(pizza, pasta), result);
    }

    // Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
    @Test
    public void lumpSumOfOrdersPlacedInAGivenTime() {
        // WHEN
        var result = orders.stream()
            .filter(order -> YearMonth.from(order.getOrderDate()).equals((YearMonth.of(2021, 2))))
            .map(Order::getProducts)
            .flatMap(Collection::stream)
            .map(Product::getPrice)
            .mapToDouble(Double::doubleValue)
            .sum();

        // THEN
        assertEquals(950, result);
    }

    private static Customer createCustomer(long id, String name, int tier) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setTier(tier);
        return customer;
    }

    private static Product createProduct(long id, String name, String category, double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        return product;
    }

    private static Order createOrder(long id, Customer customer, List<Product> products, LocalDate date) {
        Order order = new Order();
        order.setId(id);
        order.setOrderDate(date);
        order.setCustomer(customer);
        order.setProducts(products);
        return order;
    }
}