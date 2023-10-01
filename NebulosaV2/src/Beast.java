import java.util.Map;
import java.util.TreeMap;

public class Beast {
    private String species;
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int level;
    private int exp;
    private Map<Integer, Integer> levelXPMap;
    private int catchRate;
    private String rarity;
    private String element;

    public Beast(String species, String name, int health, int maxHealth, int attack, int level, int exp, int catchRate, String rarity, String element) {
        this.species = species;
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.level = level;
        this.exp = exp;
        this.catchRate = catchRate;
        this.rarity = rarity;
        this.element = element;

        levelXPMap = new TreeMap<Integer, Integer>();
        levelXPMap.put(2, 10);
        levelXPMap.put(3, 20);
        levelXPMap.put(4, 30);
        levelXPMap.put(5, 45);
        levelXPMap.put(6, 60);
        levelXPMap.put(7, 75);
        levelXPMap.put(8, 90);
        levelXPMap.put(9, 105);
        levelXPMap.put(10, 125);
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public String getRarity() {
        return rarity;
    }

    public String getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Map<Integer, Integer> getLevelXPMap() {
        return levelXPMap;
    }
}
