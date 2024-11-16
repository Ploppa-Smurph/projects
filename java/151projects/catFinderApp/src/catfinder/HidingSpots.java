package catfinder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HidingSpots implements Serializable {
    private Map<String, List<String>> rooms;

    public HidingSpots() {
        rooms = new HashMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        // Add rooms and their corresponding hiding spots
        rooms.put("bedroom", List.of("under the bed", "in the closet", "on the windowsill"));
        rooms.put("kitchen", List.of("on the counter", "in the sink", "under the table"));
        rooms.put("bathroom", List.of("in the sink", "in the bathtub", "behind the shower curtain"));
        rooms.put("living room", List.of("on the couch", "under the couch", "on the coffee table"));
        rooms.put("spare bedroom", List.of("under the bed", "in the closet", "on the chair"));
        // Add more rooms and hiding spots as needed
    }

    public List<String> getHidingSpots(String room) {
        return rooms.get(room);
    }

    public String getRandomHidingSpot(String room) {
        List<String> spots = rooms.get(room);
        return spots.get((int) (Math.random() * spots.size()));
    }

    public void addCustomRoom(String roomName, List<String> customSpots) {
        rooms.put(roomName, customSpots);
    }

    public Map<String, List<String>> getRooms() {
        return rooms;
    }
}
