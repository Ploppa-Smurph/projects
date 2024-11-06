package crybaby;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Crybaby {
    private Set<String> approvedFoods;
    private Set<String> approvedGames;
    public Crybaby() {
        // Initialize approved foods and games
        approvedFoods = new HashSet<>(Arrays.asList("apple", "banana", "cookie", "chicken nuggets", "pizza"));
        approvedGames = new HashSet<>(Arrays.asList("hide and seek", "tag", "lego", "imagination time", "seesaw"));
    }

// Feed method throws NastyFoodException if food NOT approved
public void feed(String food) {
        if (!approvedFoods.contains(food)) {
            throw new NastyFoodException("I don't like " + food);
        } System.out.println("Yay, I like " + food);
    }

// Play method that throws DumbGameException if game is NOT approved
public void play(String game) throws DumbGameException {
        if (!approvedGames.contains(game)) {
            throw new DumbGameException("I don't like " + game);
        } System.out.println("Yay, " + game + " is so much fun!"); }
}