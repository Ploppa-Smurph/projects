package basicPortfolio.ch05;

// Define the interface
public interface RoboWarriorType {
    String[] WARRIOR_TYPES = {
            "ninja",
            "priest",
            "berserker",
            "mystic"};

    void chooseWarrior(String type);
    }