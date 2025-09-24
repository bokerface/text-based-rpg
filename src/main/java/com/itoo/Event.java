package com.itoo;

import java.util.Random;

public class Event {

    public static void generate(Player player) {
        Random random = new Random();
        int eventChance = random.nextInt(100);

        // 5% chance of finding a rest spot
        if (eventChance < 5) {
            System.out.println("You found a rest area");
            try {
                Thread.sleep(1000); // Simulate time taken to rest
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            restArea(player);
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

        while (player.getIsAlive() && monster.getIsAlive()) {

            System.err.println(player.getName() + " attacks " + monster.getName());
            monster.takeDamage(player.getAttackPower());
            if (!monster.getIsAlive()) {
                break;
            }
            try {
                Thread.sleep(1000); // Simulate time between attacks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(monster.getName() + " attacks " + player.getName());
            player.takeDamage(monster.getAttackPower());
            if (!player.getIsAlive()) {
                break;
            }
        }

        if (player.getIsAlive()) {
            System.out.println("You defeated the " + monster.getName() + " and gained " + monster.getExp() + " EXP!");
            player.gainExp(monster.getExp());
        } else {
            System.out.println("You were defeated by the " + monster.getName() + ". Game Over.");
            System.exit(0);
        }
    }

    public static void restArea(Player player) {
        System.out.println("You take a rest and fully recovered your health.");
        player.takeHealing(player.getMaxHealth());
    }
}
