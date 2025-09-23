package com.itoo;

public class Player extends Entity {

    private int expToNextLevel;

    public Player(String name, int health, int attack, int defense, int exp) {
        super(name, health, attack, defense, exp);
        this.expToNextLevel = 100;
    }

    private int setExpToNextLevel() {
        // set the exp needed for the next level after leveling up (formula applied after level 1)
        return 100 + (100 / 2) * this.getLevel();
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

    public int getExpToNextLevel() {
        return this.expToNextLevel;
    }

}
