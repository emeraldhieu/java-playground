package com.emeraldhieu.statemachine;

public interface StateMachine<S, T extends TransitionEvent> {

    S initState();

    S next(S currentState, T action);
}
