package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class TreasureItem extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    public TreasureItem(String name, String color, String rarity, ItemEffectType effectType, int effectValue) {
        super(name, color, rarity, effectType, effectValue);
    }

    @Override
    public void use(Hero hero) {
        applyEffect(hero);
        System.out.println("Used " + getName());
    }
}

