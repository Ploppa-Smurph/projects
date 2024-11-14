package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class RockCandy extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public RockCandy(String name, String color, String rarity) {
        super(name, color, rarity, ItemEffectType.INCREASE_DEFENSE, 0);
    }

    @Override
    public void use(Hero hero) {
        hero.increaseDefense(20); // Arbitrary value for defense increase
        System.out.println("Used " + getName() + " and increased defense.");
    }
}
