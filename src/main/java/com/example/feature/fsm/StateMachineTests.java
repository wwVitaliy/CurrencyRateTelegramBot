package com.example.feature.fsm;

import java.util.Scanner;

public class StateMachineTests {
    public static void main(String[] args) {
        StateMachine fsm = new StateMachine();

        fsm.addListener(((message, time) -> {
            System.out.println("Listener called");
            System.out.println("Message: " + message);
            System.out.println("Time: " + time);
        }));
        Scanner scanner = new Scanner(System.in);
        while(true){
            String text = scanner.nextLine();
            fsm.handle(text);
        }
    }
}
