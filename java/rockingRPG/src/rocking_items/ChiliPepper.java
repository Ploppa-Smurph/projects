package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class ChiliPepper extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public ChiliPepper(String name, String color, String rarity) {
        super(name, color, rarity, ItemEffectType.INCREASE_ATTACK, 0);
    }

    @Override
    public void use(Hero hero) {
        hero.increaseAttack(25); // Arbitrary value for attack increase
        System.out.println("Used " + getName() + " and increased attack.");
    }
}
