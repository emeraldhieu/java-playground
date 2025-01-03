package com.emeraldhieu.statemachine.order.processor;

import com.emeraldhieu.statemachine.order.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder(toBuilder = true)
@Getter
public class Order {

    private final String id;
    private final List<String> products;
    private final OrderStatus status;

}
