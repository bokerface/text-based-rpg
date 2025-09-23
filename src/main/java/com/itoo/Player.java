package com.itoo;

public class Player extends Character {

    int expToNextLevel;

    public Player(String name, int health, int attack, int defense, int exp) {
        super(name, health, attack, defense, exp);
        this.expToNextLevel = 100;
    }

    private int setExpToNextLevel() {
        return 100 + (100 / 2) * this.level;
    }

    public void gainExp(int amount) {
        this.exp += amount;
        while (this.exp >= this.expToNextLevel) {
            this.exp -= this.expToNextLevel;
            levelUp();
            this.expToNextLevel = setExpToNextLevel();
            System.out.println("Congratulations! You've leveled up to level " + this.level + "!");
            System.out.println("EXP needed for next level: " + this.expToNextLevel);
        }
    }

    public void levelUp() {
        this.level += 1;
    }
}
