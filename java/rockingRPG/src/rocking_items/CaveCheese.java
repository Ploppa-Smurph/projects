package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class CaveCheese extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public CaveCheese(String name, String color, String rarity) {
        super(name, color, rarity, ItemEffectType.INCREASE_INTELLIGENCE, 0);
    }

    @Override
    public void use(Hero hero) {
        hero.increaseIntelligence(15); // Arbitrary value for intelligence increase
        System.out.println("Used " + getName() + " and increased intelligence.");
    }
}