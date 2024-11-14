package rocking_npc;

import java.io.Serializable;

public class NPC implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String occupation;
    private String questDescription;
    private int targetX; // For coordinate-based quests
    private int targetY; // For coordinate-based quests
    private boolean questCompleted;

    public NPC(String name, String occupation, String questDescription, int targetX, int targetY) {
        this.name = name;
        this.occupation = occupation;
        this.questDescription = questDescription;
        this.targetX = targetX;
        this.targetY = targetY;
        this.questCompleted = false;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public boolean isQuestCompleted() {
        return questCompleted;
    }

    public void completeQuest() {
        this.questCompleted = true;
    }
}
