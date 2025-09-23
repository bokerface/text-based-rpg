package com.itoo;

import java.util.Random;

public class Event {

    public static void generate(Player player) {
        Random random = new Random();
        int eventChance = random.nextInt(100);

        // 5% chance of finding a rest spot
        if (eventChance < 5) {
            System.out.println("You found a rest area");
        } // 10% chance of finding treasure
        else if (eventChance < 10) {
            System.out.println("You found a treasure chest!");
        } // 30% chance of encountering a monster
        else if (eventChance < 50) {
            System.out.println("You're ambushed by a monster!");
            battle(player);
        } // 60% chance of nothing happening
        else {
            System.out.println("The path is clear. You continue your journey.");
        }
    }

    public static void battle(Player player) {
        Monster monster = Factory.generateMonster();

        while (player.isAlive && monster.isAlive) {

            monster.takeDamage(player.getAttackPower());
            System.out.println("You attack the " + monster.getName() + " for " + player.getAttackPower() + " damage.");
        }
    }
}
