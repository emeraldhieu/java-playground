package com.emeraldhieu.statemachine.order.processor;

import com.emeraldhieu.statemachine.StateMachine;
import com.emeraldhieu.statemachine.order.OrderStateMachine;
import com.emeraldhieu.statemachine.order.OrderStatus;
import com.emeraldhieu.statemachine.order.OrderTransitionEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderProcessor {

    private StateMachine<OrderStatus, OrderTransitionEvent> orderStateMachine = new OrderStateMachine();
    private Map<String, Order> inMemoryOrders = new HashMap<>();

    public Order create(List<String> products) {
        var order = Order.builder()
            .id(UUID.randomUUID().toString())
            .status(orderStateMachine.initState())
            .products(products)
            .build();
        inMemoryOrders.put(order.getId(), order);
        return order;
    }

    public Order markAsSentForSignature(String id) {
        var sentForSignatureOrder = transitState(id, OrderTransitionEvent.SEND_FOR_SIGNATURE);
        return sentForSignatureOrder;
    }

    private Order transitState(final String id, final OrderTransitionEvent signed) {
        var existingOrder = inMemoryOrders.get(id);
        var sentForSignatureOrder = existingOrder.toBuilder()
            .status(orderStateMachine.next(existingOrder.getStatus(), signed))
            .build();
        inMemoryOrders.put(id, sentForSignatureOrder);
        return sentForSignatureOrder;
    }

    public Order markAsSigned(String id) {
        return transitState(id, OrderTransitionEvent.SIGNED);
    }

    public Order activate(String id) {
        return transitState(id, OrderTransitionEvent.ACTIVATE);
    }

    public Order delete(String id) {
        var currentOrder = inMemoryOrders.get(id);
        var transitedOrder = currentOrder.toBuilder()
            .status(orderStateMachine.next(currentOrder.getStatus(), OrderTransitionEvent.DELETE_ORDER))
            .build();
        inMemoryOrders.remove(transitedOrder);
        return transitedOrder;
    }

}
