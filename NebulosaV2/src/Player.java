import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Player {
    private String name;
    private Map<String, String> keyItems;
    private Map<String, Beast> beastMap;
    private Map<String, Integer> beastBaitMap;
    private List<String> bestiary;
    private List<String> placesVisited;
    private Map<String, Integer> items;
    private List<String> uniqueItemsObtained;
    private int money;
    private Map<String, Integer> potionsMap;
    private String currentLocation;
    private String lastSavedLocation;
    private boolean quitGame;

    private Constants CONST = new Constants();

    public Player() throws IOException {
        File saveFile = new File("savefile.txt");

        name = new String();
        keyItems = new TreeMap<String, String>();
        beastMap = new TreeMap<String, Beast>();
        beastBaitMap = new TreeMap<String, Integer>();
        bestiary = new ArrayList<String>();
        placesVisited = new ArrayList<String>();
        uniqueItemsObtained = new ArrayList<String>();
        potionsMap = new TreeMap<String, Integer>();
        items = new TreeMap<String, Integer>();
        currentLocation = new String();
        lastSavedLocation = new String();
        quitGame = false;

        if(saveFile.exists()) {
            Scanner fileReader = new Scanner(saveFile);

            // updates name from save file
            String line = fileReader.nextLine();
            name = line.substring(line.indexOf(" ") + 1);

            // updates money from save file
            line = fileReader.nextLine();
            money = Integer.parseInt(line.substring(line.indexOf(" ") + 1));

            // updates last saved location from save file
            line = fileReader.nextLine();
            lastSavedLocation = line.substring(line.indexOf(" ") + 1);

            // updates placesVisited from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                placesVisited.add(currentToken);
            }

            // updates keyItems from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                keyItems.put(currentToken, CONST.getKeyItems().get(currentToken));
            }

            // adds item names to temporary list (gets updated along with item quantities)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> temporaryListItemNames = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListItemNames.add(currentToken);
            }

            // updates item names and quantities from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            int temporaryCount = 0;
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                items.put(temporaryListItemNames.get(temporaryCount), Integer.parseInt(currentToken));
                temporaryCount++;
            }

            // updates unique items from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                uniqueItemsObtained.add(currentToken);
            }

            // adds beast names to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> temporaryListBeastNames = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastNames.add(currentToken);
            }

            // adds beast species to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> temporaryListBeastSpecies = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastSpecies.add(currentToken);
            }

            // adds beast health to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<Integer> temporaryListBeastHealth = new ArrayList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastHealth.add(Integer.parseInt(currentToken));
            }

            // adds beast max health to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<Integer> temporaryListBeastMaxHealth = new ArrayList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastMaxHealth.add(Integer.parseInt(currentToken));
            }

            // adds beast attack to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<Integer> temporaryListBeastAttack = new ArrayList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastAttack.add(Integer.parseInt(currentToken));
            }

            // adds beast level to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<Integer> temporaryListBeastLevel = new ArrayList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastLevel.add(Integer.parseInt(currentToken));
            }

            // adds beast experience points to temporary list (gets updated later)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<Integer> temporaryListBeastExp = new ArrayList<Integer>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastExp.add(Integer.parseInt(currentToken));
            }

            // updates beasts in player's list
            for(int i = 0; i < temporaryListBeastNames.size(); i++) {
                String tempBeastSpecies = temporaryListBeastSpecies.get(i);
                String tempBeastName = temporaryListBeastNames.get(i);
                int tempBeastHealth = temporaryListBeastHealth.get(i);
                int tempBeastMaxHealth = temporaryListBeastMaxHealth.get(i);
                int tempBeastAttack = temporaryListBeastAttack.get(i);
                int tempBeastLevel = temporaryListBeastLevel.get(i);
                int tempBeastExp = temporaryListBeastExp.get(i);
                beastMap.put(temporaryListBeastNames.get(i), new Beast(tempBeastSpecies, tempBeastName, tempBeastHealth, tempBeastMaxHealth, tempBeastAttack,
                        tempBeastLevel, tempBeastExp,
                        CONST.getBeastMap().get(temporaryListBeastSpecies.get(i)).getCatchRate(),
                        CONST.getBeastMap().get(tempBeastSpecies).getRarity(), CONST.getBeastMap().get(tempBeastSpecies).getElement()));
            }

            // updates bestiary entries from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                bestiary.add(currentToken);
            }

            // adds beast bait names to temporary list (gets updated along with beast bait quantities)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> temporaryListBeastBaitNames = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListBeastBaitNames.add(currentToken);
            }

            // updates beast bait names and quantities from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            temporaryCount = 0;
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                beastBaitMap.put(temporaryListBeastBaitNames.get(temporaryCount), Integer.parseInt(currentToken));
                temporaryCount++;
            }

            // adds potion names to temporary list (gets updated along with potion quantities)
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            ArrayList<String> temporaryListPotionNames = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                temporaryListPotionNames.add(currentToken);
            }

            // updates potion names and quantities from save file
            line = fileReader.nextLine();
            line = line.substring(line.indexOf(" ") + 1);
            tokenizer = new StringTokenizer(line, ",");
            temporaryCount = 0;
            while(tokenizer.hasMoreTokens()) {
                String currentToken = tokenizer.nextToken();
                items.put(temporaryListPotionNames.get(temporaryCount), Integer.parseInt(currentToken));
                temporaryCount++;
            }
        }
    }

    public void save() throws IOException {
        System.out.println("Now saving...");
        System.out.println("Thanks for playing!");
        PrintWriter saveFile = new PrintWriter("savefile.txt");

        // saves name
        saveFile.println("[Name]: " + name);

        // saves money
        saveFile.println("[Money]: " + money);

        // saves last location
        saveFile.println("[Last_Location]: " + lastSavedLocation);

        // saves places visited
        String line = "[Places_Visited]: ";
        Iterator iter = placesVisited.iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves key items
        line = "[Key_Items]: ";
        iter = keyItems.keySet().iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves item names
        line = "[Item_Names]: ";
        iter = items.keySet().iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves item quantities
        line = "[Item_Quantities]: ";
        iter = items.keySet().iterator();
        while(iter.hasNext()) {
            line += items.get(iter.next());
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves unique items obtained
        line = "[Unique_Items]: ";
        iter = uniqueItemsObtained.iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves name of player's beasts
        line = "[Player_Beasts_Name]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves species of player's beasts
        line = "[Player_Beasts_Species]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getSpecies();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves health of player's beasts
        line = "[Player_Beasts_Health]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getHealth();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves max health of player's beasts
        line = "[Player_Beasts_MaxHealth]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getMaxHealth();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves attack of player's beasts
        line = "[Player_Beasts_Attack]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getAttack();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves level of player's beasts
        line = "[Player_Beasts_Level]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getLevel();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves experience points of player's beasts
        line = "[Player_Beasts_Exp]: ";
        iter = beastMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastMap.get(iter.next()).getExp();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves bestiary entries
        line = "[Bestiary_Entries]: ";
        iter = bestiary.iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves beast bait names
        line = "[BeastBait_Names]: ";
        iter = beastBaitMap.keySet().iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves beast bait quantities
        line = "[BeastBait_Quantities]: ";
        iter = beastBaitMap.keySet().iterator();
        while(iter.hasNext()) {
            line += beastBaitMap.get(iter.next());
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves potion names
        line = "[Potion_Names]: ";
        iter = potionsMap.keySet().iterator();
        while(iter.hasNext()) {
            line += iter.next();
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);

        // saves potion quantities
        line = "[Potion_Quantities]: ";
        iter = potionsMap.keySet().iterator();
        while(iter.hasNext()) {
            line += potionsMap.get(iter.next());
            if(iter.hasNext())
                line += ",";
        }
        saveFile.println(line);


        saveFile.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSavedLocation() {
        return lastSavedLocation;
    }

    public void setLastSavedLocation(String lastSavedLocation) {
        this.lastSavedLocation = lastSavedLocation;
    }

    public Map<String, String> getKeyItems() {
        return keyItems;
    }

    public void setKeyItems(TreeMap<String, String> keyItems) {
        this.keyItems = keyItems;
    }

    public Map<String, Beast> getBeastMap() {
        return beastMap;
    }

    public void setBeastMap(TreeMap<String, Beast> beastList) {
        this.beastMap = beastList;
    }

    public Map<String, Integer> getBeastBaitMap() {
        return beastBaitMap;
    }

    public void setBeastBaitMap(TreeMap<String, Integer> beastBaitMap) {
        this.beastBaitMap = beastBaitMap;
    }

    public List<String> getBestiary() {
        return bestiary;
    }

    public void setBestiary(ArrayList<String> bestiary) {
        this.bestiary = bestiary;
    }

    public List<String> getPlacesVisited() {
        return placesVisited;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public List<String> getUniqueItemsObtained() {
        return getUniqueItemsObtained();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Map<String, Integer> getPotionsMap() {
        return potionsMap;
    }

    public boolean isQuitGame() {
        return quitGame;
    }

    public void setQuitGame(boolean quitGame) {
        this.quitGame = quitGame;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}


