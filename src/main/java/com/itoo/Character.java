package com.itoo;

public class Character {

    private String name;
    private int health;
    private int attackPower;
    private int defense;
    private int exp;
    private int level = 1;

    public boolean isAlive;

    public Character(String name, int health, int attackPower, int defense, int exp) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.isAlive = true;
        this.exp = exp;
    }

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

    public int getAttackPower() {
        return this.attackPower;
    }

    public String getName() {
        return this.name;
    }

}
