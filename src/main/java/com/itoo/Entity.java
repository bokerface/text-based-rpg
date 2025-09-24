package com.itoo;

public class Entity {

    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int defense;
    private int exp;
    private int level = 1;

    private boolean isAlive;

    public Entity(String name, int health, int maxHealth, int attackPower, int defense, int exp) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
        this.isAlive = true;
        this.exp = exp;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public String getName() {
        return this.name;
    }

    public int getExp() {
        return this.exp;
    }

    public int setExp(int exp) {
        return this.exp = exp;
    }

    public int setLevel(int level) {
        return this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean setIsAlive(boolean isAlive) {
        return this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public int setMaxHealth(int maxHealth) {
        return this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeDamage(int damage) {
        // prevent negative damage and ensure at least 1 damage is taken when defense is higher than attack
        int calculatedDamage = Math.max(damage - this.defense, 1);

        // update health and check if entity is still alive
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

    public void takeHealing(int healAmount) {
        // restore health but not exceed max health
        this.health = Math.min(this.health + healAmount, this.maxHealth);
    }

}
