package basicPortfolio.ch05;

public class RoboWarrior {
    private String type;
    private String description;

    public RoboWarrior(String type) {
        this.type = type;
        setDescription(type);
    }

    private void setDescription(String type) {
        switch (type.toLowerCase()) {
            case "ninja":
                description = "stealthy and agile warrior, master of shadow and silence.";
                break;
            case "priest":
                description = "wise and spiritual guide, healer of wounds and souls.";
                break;
            case "berserker":
                description = "fierce and relentless warrior, fueled by rage and raw power.";
                break;
            case "mystic":
                description = "mystical and enigmatic figure, wielding arcane powers and knowledge.";
                break;
            default:
                description = "Unknown warrior type.";
                break;
        }
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void move() {
        System.out.println(type + " moves swiftly across the battlefield.");
    }

    public void attack() {
        System.out.println(type + " launches a normal attack.");
    }

    // Overload a method by using different parameters at different locations.
    // Here I use a String to specify which type of attack,
    // as opposed to a 'normal' attack
    public void attack(String technique) {
        switch (technique.toLowerCase()) {
            case "punch":
                System.out.println(type + " throws a powerful punch.");
                break;
            case "kick":
                System.out.println(type + " delivers a swift kick.");
                break;
            case "laser":
                System.out.println(type + " fires a devastating laser beam.");
                break;
            case "plasmasword":
                System.out.println(type + " slashes with a glowing plasma sword.");
                break;
            default:
                System.out.println(type + " tries an unknown technique.");
                break;
        }
    }

    public void defend() {
        System.out.println(type + " raises their defenses.");
    }
}