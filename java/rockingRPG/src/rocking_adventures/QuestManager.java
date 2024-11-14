package rocking_adventures;

import rocking_npc.NPC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<NPC> npcs;

    public QuestManager() {
        this.npcs = new ArrayList<>();
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNPCs() {
        return npcs;
    }

    public void checkQuestCompletion(int playerX, int playerY) {
        for (NPC npc : npcs) {
            if (!npc.isQuestCompleted() && playerX == npc.getTargetX() && playerY == npc.getTargetY()) {
                System.out.println("Quest from " + npc.getName() + " (" + npc.getOccupation() + ") completed!");
                npc.completeQuest();
            }
        }
    }

    public void displayQuests() {
        for (NPC npc : npcs) {
            System.out.println("Quest from " + npc.getName() + " (" + npc.getOccupation() + "): " + npc.getQuestDescription() + " - " + (npc.isQuestCompleted() ? "Completed" : "Incomplete"));
        }
    }
}
