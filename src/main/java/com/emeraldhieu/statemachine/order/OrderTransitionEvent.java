package com.emeraldhieu.statemachine.order;

import com.emeraldhieu.statemachine.TransitionEvent;

public enum OrderTransitionEvent implements TransitionEvent {
    SEND_FOR_SIGNATURE,
    SIGNED,
    CUSTOMER_REJECTED,
    ACTIVATE,
    DEACTIVATED,
    HOLD,
    RESUME,
    DELETE_ORDER
}
