package com.itoo;

import java.util.List;
import java.util.Random;

public class Factory {

    public static Monster generateMonster() {
        List<Monster> monsters = List.of(
                new Monster("Goblin", 20, 5, 2, 8),
                new Monster("Orc", 30, 7, 3, 13),
                new Monster("Troll", 40, 10, 5, 20)
        );

        return monsters.get(new Random().nextInt(monsters.size()));
    }
}
