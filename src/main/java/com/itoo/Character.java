package com.itoo;

public class Character {

    private String name;
    private int health;
    private int attackPower;
    private int defense;

    public boolean isAlive;

    public void takeDamage(int damage) {
        int calculatedDamage = Math.max(damage - this.defense, 1);
        this.health -= calculatedDamage;
        System.out.println(this.name + " takes " + calculatedDamage + " damage. Remaining health: " + this.health);
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    public void setAttributes(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.isAlive = true;
    }

}
