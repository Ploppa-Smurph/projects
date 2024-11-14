package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class ChickenFeather extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public ChickenFeather(String name, String color, String rarity) {
        super(name, color, rarity, ItemEffectType.INCREASE_SPEED, 0);
    }

    @Override
    public void use(Hero hero) {
        hero.increaseSpeed(50); // Arbitrary value for speed increase
        System.out.println("Used " + getName() + " and increased speed.");
    }
}
