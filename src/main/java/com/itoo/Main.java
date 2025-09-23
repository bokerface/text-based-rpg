package com.itoo;

import java.util.Scanner;

public class Main {

    public static void action(Scanner s, Player player) {

        System.err.println("Status: " + player.getName() + " | Level: " + player.level + " | EXP: " + player.exp + "/" + player.expToNextLevel);
        System.out.println("Select action :");
        System.out.println("1. Explore");
        System.out.println("2. Exit");

        int choice = s.nextInt();
        switch (choice) {
            case 1:
                Event.generate(player);
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        boolean isAlive = true;
        Scanner s = new Scanner(System.in);

        System.err.print("Enter your name: ");
        String name = s.nextLine();

        Player player = new Player(name, 100, 15, 5, 0);

        // s.close();
        while (isAlive) {
            action(s, player);
            // try {
            //     Thread.sleep(2000); // Simulate game loop delay
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }
}
