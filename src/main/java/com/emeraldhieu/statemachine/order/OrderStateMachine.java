package com.emeraldhieu.statemachine.order;

import com.emeraldhieu.statemachine.InvalidStateException;
import com.emeraldhieu.statemachine.StateMachine;

import java.util.HashMap;
import java.util.Map;

public class OrderStateMachine implements StateMachine<OrderStatus, OrderTransitionEvent> {

    /**
     * currentState -> action -> nextState
     */
    private final Map<OrderStatus, Map<OrderTransitionEvent, OrderStatus>> transitions = new HashMap<>();

    public OrderStateMachine() {
        initialize();
    }

    @Override
    public OrderStatus initState() {
        return OrderStatus.DRAFT;
    }

    @Override
    public OrderStatus next(OrderStatus currentState, OrderTransitionEvent action) {
        Map<OrderTransitionEvent, OrderStatus> stateTransitions = transitions.get(currentState);
        if (stateTransitions == null || !stateTransitions.containsKey(action)) {
            throw new InvalidStateException(
                String.format("No state transition for action %s from state %s", action, currentState)
            );
        }
        return stateTransitions.get(action);
    }

    private void register(
        OrderTransitionEvent action,
        OrderStatus fromState,
        OrderStatus toState
    ) {
        transitions
            .computeIfAbsent(fromState, k -> new HashMap<>())
            .put(action, toState);
    }

    private void initialize() {
        register(OrderTransitionEvent.SEND_FOR_SIGNATURE, OrderStatus.DRAFT, OrderStatus.ORDER_SENT_FOR_SIGNATURE);
        register(OrderTransitionEvent.SIGNED, OrderStatus.ORDER_SENT_FOR_SIGNATURE, OrderStatus.ORDER_SIGNED);
        register(OrderTransitionEvent.DEACTIVATED, OrderStatus.ORDER_SIGNED, OrderStatus.ORDER_DEACTIVATED);
        register(OrderTransitionEvent.CUSTOMER_REJECTED, OrderStatus.ORDER_SENT_FOR_SIGNATURE, OrderStatus.ORDER_SIGNING_FAILED);
        register(OrderTransitionEvent.ACTIVATE, OrderStatus.ORDER_SIGNED, OrderStatus.ORDER_ACTIVATED);
        register(OrderTransitionEvent.HOLD, OrderStatus.ORDER_ACTIVATED, OrderStatus.ON_HOLD);
        register(OrderTransitionEvent.DEACTIVATED, OrderStatus.ORDER_ACTIVATED, OrderStatus.ORDER_DEACTIVATED);
        register(OrderTransitionEvent.DELETE_ORDER, OrderStatus.DRAFT, OrderStatus.DELETED);
        register(OrderTransitionEvent.DELETE_ORDER, OrderStatus.ORDER_SIGNING_FAILED, OrderStatus.DELETED);
        register(OrderTransitionEvent.DELETE_ORDER, OrderStatus.ORDER_ACTIVATED, OrderStatus.DELETED);
        register(OrderTransitionEvent.RESUME, OrderStatus.ON_HOLD, OrderStatus.ORDER_ACTIVATED);
    }

}
