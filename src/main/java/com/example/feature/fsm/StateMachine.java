package com.example.feature.fsm;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private State state = State.idle;
    private List<StateMachineListener> listeners = new ArrayList<>();

    private String message;
    private int time;


    public void handle(String text) {
        if (text.equals("Create notification")) {
            onCreateNotificationPressed();
            return;
        }

        onTextReceived(text);

        try {
            int number = Integer.parseInt(text);
            onNumberReceived(number);
        } catch (Exception e) {
            // Skip if text is not integer
        }

    }

    public void addListener(StateMachineListener listener){
        this.listeners.add(listener);
    }

    private void onCreateNotificationPressed() {
        if (state == State.idle) {
            switchState(State.waitForMessage);
        }
    }

    private void onTextReceived(String text) {
        if (state == State.waitForMessage) {
            message = text;
            switchState(State.waitForTime);
        }
    }

    private void onNumberReceived(int number) {
        if (state == State.waitForTime){
            time = number;
            switchState(State.idle);

            for (StateMachineListener listener : listeners) {
                listener.onMessageANdTimeReceiver(message, time);
            }

            //TODO create notification for specific user
        }

    }

    private void switchState(State newState) {
        System.out.println("Switch state " + state + " => " + newState);
        this.state = newState;
    }
}
