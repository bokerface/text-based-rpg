package com.itoo;

public class Player extends Entity {

    private int expToNextLevel;

    private int potions;

    public Player(String name, int health, int maxHealth, int attack, int defense, int exp) {
        super(name, health, maxHealth, attack, defense, exp);
        this.expToNextLevel = 100;
    }

    public int setPotions(int amount) {
        return this.potions += amount;
    }

    public int getPotions() {
        return this.potions;
    }

    public int setExpToNextLevel() {
        // set the exp needed for the next level after leveling up (formula applied after level 1)
        return 100 + (100 / 2) * this.getLevel();
    }

    public int getExpToNextLevel() {
        return this.expToNextLevel;
    }

    public void gainExp(int amount) {
        // add the exp gained from battle to player's current exp
        this.setExp(this.getExp() + amount);

        // check if player has enough exp to level up
        while (this.getExp() >= this.expToNextLevel) {
            this.setExp(this.getExp() - this.expToNextLevel);
            levelUp();
            this.expToNextLevel = setExpToNextLevel();
            System.out.println("Congratulations! You've leveled up to level " + this.getLevel() + "!");
            System.out.println("EXP needed for next level: " + this.expToNextLevel);
        }
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
    }

    public void usePotion() {
        if (this.potions > 0) {
            this.takeHealing(40);
            this.potions -= 1;
            System.out.println("You used a potion and restored 40 health points.");
            System.out.println("You have " + this.potions + " potions left.");
        } else {
            System.out.println("You have no potions left!");
        }
    }
}
