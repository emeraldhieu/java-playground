package com.emeraldhieu.statemachine.order;

public enum OrderStatus {
    DRAFT,
    ORDER_SENT_FOR_SIGNATURE,
    ORDER_SIGNED,
    ORDER_SIGNING_FAILED,
    ORDER_ACTIVATED,
    ON_HOLD,
    ORDER_DEACTIVATED,
    DELETED
}
