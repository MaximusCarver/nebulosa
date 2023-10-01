import java.util.Map;
import java.util.TreeMap;

public class Constants {
    private Map<String, Beast> beastMap;
    private Map<String, String> keyItems;
    private Map<String, Integer> itemValues;

    public Constants() {
        beastMap = new TreeMap<String, Beast>();
        beastMap.put("Swallow", new Beast("Swallow", "Swallow", 10, 10, 2, 1, 0, 1/3, "Common", "Air"));
        beastMap.put("Iguana", new Beast("Iguana", "Iguana", 10, 10, 2, 1, 0, 1/3, "Common", "Terra"));
        beastMap.put("Racoon", new Beast("Racoon", "Racoon", 10, 10, 2, 1, 0, 1/3, "Common", "Terra"));

        keyItems = new TreeMap<String, String>();
        keyItems.put("Crown Pass", "A small, shiny, golden pass with a crown print on it. Allows you to visit  and lodges for free.");
        keyItems.put("Bestiary", "A perfectly weighted leather-bound book of royal quality. " +
                "A thin leather pouch runs alongside the spine of the book with a gilded quiver pen inside. " +
                "Strangely, the pen never seems to run out of ink.");

        itemValues = new TreeMap<String, Integer>();
        itemValues.put("beast berry", 5);
        itemValues.put("lavender oil", 5);
    }

    public Map<String, Beast> getBeastMap() {
        return beastMap;
    }

    public Map<String, String> getKeyItems() {
        return keyItems;
    }

    public Map<String, Integer> getItemValues() {
        return itemValues;
    }
}

