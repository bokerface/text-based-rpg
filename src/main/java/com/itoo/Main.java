package com.itoo;

import java.util.Scanner;

public class Main {

    public static void action(Scanner scanner, Player player) {

        // print player status and available actions
        System.err.println("Status: " + player.getName() + " | Level: " + player.getLevel() + " | Health: " + player.getHealth() + "/" + player.getMaxHealth() + " | Potions: " + player.getPotions() + " | EXP: " + player.getExp() + "/" + player.getExpToNextLevel());
        System.out.println("Select action :");
        System.out.println("1. Explore");
        System.out.println("2. Exit");

        // get player choice and perform action
        int choice = scanner.nextInt();
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
        // declare scanner for user intput
        Scanner scanner = new Scanner(System.in);

        System.err.print("Enter your name: ");
        // get player name input
        String name = scanner.nextLine();

        // create new instance of player
        Player player = new Player(name, 100, 100, 15, 5, 0);

        // main loop of the game
        while (player.getIsAlive()) {
            action(scanner, player);
        }
    }
}
