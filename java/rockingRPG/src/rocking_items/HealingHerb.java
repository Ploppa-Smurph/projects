package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public class HealingHerb extends Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private int healAmount;

    public HealingHerb(String name, String color, String rarity, int healAmount) {
        super(name, color, rarity, ItemEffectType.RESTORE_HEALTH, healAmount);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void use(Hero hero) {
        hero.restoreHealth(healAmount);
        System.out.println("Used " + getName() + " and restored " + healAmount + " health.");
    }
}


