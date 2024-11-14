package rocking_villains;

import rocking_races.Race;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RockingVillains {
    private Map<Integer, Villain> villains;
    private Random random;

    public RockingVillains() {
        villains = new HashMap<>();
        random = new Random();
        generateVillains();
    }

    private void generateVillains() {
        String[] villainNames = {"Shadowblade", "Ironclaw", "Bloodfang", "Stormbringer", "Nightshade", "Darkthorn", "Deathstalker", "Silencer", "Hexmaster", "Venom"};
        Race[] races = Race.values();
        VillainClass[] classes = VillainClass.values();
        int id = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                String name = villainNames[i] + " " + (j + 1);
                Race race = races[random.nextInt(races.length)];
                VillainClass villainClass = classes[random.nextInt(classes.length)];
                villains.put(id++, new Villain(name, race, villainClass));
            }
        }
    }

    public Villain getRandomVillain() {
        int id = random.nextInt(villains.size()) + 1;
        return villains.get(id);
    }

    public void displayVillains() {
        for (Villain villain : villains.values()) {
            villain.displayInfo();
        }
    }
}