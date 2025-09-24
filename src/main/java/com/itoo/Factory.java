package com.itoo;

import java.util.List;
import java.util.Random;

public class Factory {

    public static Monster generateMonster() {
        // list of available monsters
        List<Monster> monsters = List.of(
                new Monster("Goblin", 20, 20, 5, 2, 8),
                new Monster("Orc", 30, 30, 7, 3, 13),
                new Monster("Troll", 40, 30, 10, 5, 20)
        );

        // randomly select and return a monster from the list
        return monsters.get(new Random().nextInt(monsters.size()));
    }
}
