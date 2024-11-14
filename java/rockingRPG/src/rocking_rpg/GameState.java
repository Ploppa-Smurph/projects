package rocking_rpg;

import rocking_hero.Hero;

import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    private Hero hero;
    private int playerX;
    private int playerY;
    private List<String> inventory;
    private int currentHealth;
    private int statusEffectDuration;

    public GameState(Hero hero, int playerX, int playerY, List<String> inventory, int currentHealth, int statusEffectDuration) {
        this.hero = hero;
        this.playerX = playerX;
        this.playerY = playerY;
        this.inventory = inventory;
        this.currentHealth = currentHealth;
        this.statusEffectDuration = statusEffectDuration;
    }

    public Hero getHero() {
        return hero;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getStatusEffectDuration() {
        return statusEffectDuration;
    }
}