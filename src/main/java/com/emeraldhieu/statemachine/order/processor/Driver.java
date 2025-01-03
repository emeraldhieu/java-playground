package com.emeraldhieu.statemachine.order.processor;

import com.emeraldhieu.statemachine.InvalidStateException;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        var orderProcessor = new OrderProcessor();
        var createdOrder = orderProcessor.create(List.of("apple", "orange"));
        System.out.println(createdOrder.getStatus());

        var markedAsSentForSignatureOrder = orderProcessor.markAsSentForSignature(createdOrder.getId());
        System.out.println(markedAsSentForSignatureOrder.getStatus());

        try {
            var deletedOrder = orderProcessor.delete(createdOrder.getId());
            System.out.println(deletedOrder.getStatus());
        } catch (InvalidStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        var signedOrder = orderProcessor.markAsSigned(createdOrder.getId());
        System.out.println(signedOrder.getStatus());

        var activatedOrder = orderProcessor.activate(createdOrder.getId());
        System.out.println(activatedOrder.getStatus());

        var deletedOrder = orderProcessor.delete(createdOrder.getId());
        System.out.println(deletedOrder.getStatus());
    }

}
