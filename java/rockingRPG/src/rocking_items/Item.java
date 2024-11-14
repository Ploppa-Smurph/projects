package rocking_items;

import rocking_hero.Hero;

import java.io.Serializable;

public abstract class Item implements Serializable {  // Make the class implement Serializable
    private static final long serialVersionUID = 1L;
    private String name;
    private String color;
    private String rarity;
    private ItemEffectType effectType;
    private int effectValue;

    public Item(String name, String color, String rarity, ItemEffectType effectType, int effectValue) {
        this.name = name;
        this.color = color;
        this.rarity = rarity;
        this.effectType = effectType;
        this.effectValue = effectValue;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getRarity() {
        return rarity;
    }

    public ItemEffectType getEffectType() {
        return effectType;
    }

    public int getEffectValue() {
        return effectValue;
    }

    public void applyEffect(Hero hero) {
        switch (effectType) {
            case RESTORE_HEALTH:
                hero.restoreHealth(effectValue);
                break;
            case INCREASE_DEFENSE:
                hero.increaseDefense(effectValue);
                break;
            case INCREASE_ATTACK:
                hero.increaseAttack(effectValue);
                break;
            case INCREASE_SPEED:
                hero.increaseSpeed(effectValue);
                break;
            case INCREASE_INTELLIGENCE:
                hero.increaseIntelligence(effectValue);
                break;
        }
    }

    public abstract void use(Hero hero);
}
