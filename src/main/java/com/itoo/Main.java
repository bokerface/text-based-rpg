package com.itoo;

public class Main {

    public static void main(String[] args) {
        boolean isAlive = true;
        while (isAlive) {
            System.err.println("Game is running...");
            try {
                Thread.sleep(2000); // Simulate game loop delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
