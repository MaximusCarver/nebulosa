import java.io.File;
import java.io.IOException;
import java.util.*;

public class Nebulosa {
    File saveFile;
    Player player;
    Scanner scanner = new Scanner(System.in);
    Constants CONST = new Constants();

    public Nebulosa() throws IOException {
        player = new Player();
        saveFile = new File("savefile.txt");

        if (!saveFile.exists()) {
            saveFile.createNewFile();
            newGame();
        }
        else {
            continueGame();
        }
    }



    public void continueGame() throws IOException {
        System.out.println("Welcome back, " + player.getName() + "!");

        String decision = "";
        while(!decision.equals("yes") && !decision.equals("no")) {
            System.out.println("Would you like to continue your adventure?");
            decision = scanner.nextLine();
        }

        if(decision.equals("no")) {
            return;
        }

        switch(player.getLastSavedLocation().toLowerCase()) {
            case("douglas town"):
                douglasTown();
        }
    }


    public void newGame() throws IOException{

        System.out.println("[Narrator]: Long, long ago, the land of the Nebulosa region was uncharted.");
        System.out.println("Soldiers, sailors, traders, and homesteaders alike traveled vast distances");
        System.out.println("to explore this new and mysterious territory. Some rode on horseback for hundreds of miles,");
        System.out.println("while others came by sea. Through their journeys, some of these settlers discovered");
        System.out.println("that they had the most unusual ability to talk with the beasts");
        System.out.println("they encountered in Nebulosa. What could this mean?");
        System.out.println("");

        pressEnter();

        System.out.println("Hard cold drops of rain pattered your face as you trekked along the muddy path.");
        System.out.println("In the darkness, you spotted a dim candlelight just up ahead.");

        pressEnter();

        System.out.println("|||{Douglas Town Gate}|||");

        System.out.println("[Douglas Town Gate Guard]: Welcome, traveler! What is your name?");
        String name = scanner.nextLine();
        while (name.equals("")) {
            System.out.println("Sorry, I didn't catch that. What is your name again?");
            name = scanner.nextLine();
        }
        player.setName(name);

        System.out.println("Ah, pleased to meet you sir! Our king has been awaiting your arrival. I shall escort you to his palace immediately.");

        pressEnter();

        System.out.println("Tap tap tap.");
        System.out.println("I'm afraid this is where I must bid you farewell. Have a pleasant evening!");

        pressEnter();

        System.out.println("[Muffled Voice]: Enter.");

        pressEnter();

        System.out.println("[Narrator]: You opened the gilded wooden door and stepped inside the small palace.");

        System.out.println("|||{Douglas Palace}|||");
        System.out.println();

        pressEnter();

        System.out.println("[King Winston]: Ah, " + player.getName() + "! Welcome, welcome!");
        System.out.println("I'm pleased you could make it. You might be wondering why I sent for you. Hmmmm?");

        pressEnter();

        System.out.println("Well, I've heard rumors about your... talents speaking to beasts, and you seemed like");
        System.out.println("the perfect person for the job. Do you follow me " + player.getName() + "?");
        System.out.println("No? Well, I'll put it simply: we've lived here for nearly 400 years,");
        System.out.println("yet no one has bothered to make a comprehensive guide of these beasts.");
        System.out.println("Some people even call themselves 'beast tamers' without knowing all that much about them.");
        System.out.println("I'm looking to change that.");

        pressEnter();

        System.out.println("I want you to study the lives of Nebulosa's beasts extensively, and report your findings to me when complete.");
        System.out.println("You'll be rewarded handsomely, of course.");
        System.out.println("You'll get more based on the number of beasts you log.");

        pressEnter();

        System.out.println("Sound like a plan? Great!");
        System.out.println("I'm looking forward to reading your logs. Our sages will be sure to reprint them for the Nebulosa Library");
        System.out.println("once I'm finished with them. You might even get a little fame with your fortune!");

        pressEnter();

        System.out.println("I wish you the best of luck on your quest, " + player.getName() + "!");

        pressEnter();

        System.out.println("Oh, before you leave... take this.");
        System.out.println();

        pressEnter();

        System.out.println();
        System.out.println("......... You got a Crown Pass!");
        player.getKeyItems().put("Crown Pass", "A small, shiny, golden pass with a crown print on it. Allows you to visit lodges for free.");

        pressEnter();

        System.out.println("This will allow you to travel to clinics to heal your beasts whenever they get injured.");
        System.out.println("Since this also gives free access to lodges, I suggest you spend the night at the nearest lodge.");
        System.out.println("One of my aides will give you some more information before you depart tomorrow.");

        System.out.println("So long!");

        pressEnter();

        System.out.println("");
        System.out.println("[Narrator]: You pushed open the gilded wooden doors and carefully walked down the rain soaked stairs.");
        System.out.println("Would you like to head to the lodge?");
        String lodgeAnswer = scanner.nextLine();
        while (!lodgeAnswer.toLowerCase().equals("yes")) {
            System.out.println("It's a bit too cold and rainy to do anything else... Would you like to head to the lodge?");
            lodgeAnswer = scanner.nextLine();
        }

        System.out.println("|||{Douglas Town Lodge}|||");

        System.out.println();

        pressEnter();

        System.out.println("You headed inside the lodge and showed your Crown Pass to the inkeep.");
        System.out.println("He led you to your room and headed back to the front desk.");

        pressEnter();

        System.out.println("Although the sheets smelled a tad bit musty, the room had an overall pleasant atmosphere.");
        System.out.println("You hopped into bed and fell asleep immediately.");

        pressEnter();

        System.out.println("...");
        System.out.println("...");
        pressEnter();

        System.out.println("Bright sun shone through the open windows.");
        System.out.println("You hopped out of bed and headed downstairs.");

        pressEnter();

        System.out.println("[Douglas Town Innkeep]: Morning, " + player.getName() + "!");
        System.out.println("Lawrence, one of the King's aides, told me that he wanted to meet with you outside.");

        pressEnter();

        String outsideDecision = "";

        while (!outsideDecision.equals("outside")) {
            System.out.println("Where would you like to go? (outside, room)");
            outsideDecision = scanner.nextLine();
            if (!outsideDecision.equals("outside") && !outsideDecision.equals("room")) {
                System.out.println("Where would you like to go? (outside, room)");
            }

            if (outsideDecision.equals("room")) {
                System.out.println("You headed back to your room. Bright yellow sunlight glistens through the window.");
                System.out.println("The sheets on the bed are all messed up. A spare pillow lays next to the bed.");

                pressEnter();

                System.out.println("The closet, doors half open, contains a hat, robe, and suit.");
                System.out.println("A modest looking chandelier hangs from the ceiling in the center of the room.");

                System.out.println();

                String downstairsDecision = "";
                while(!downstairsDecision.equals("yes")) {
                    System.out.println("Would you like to head back downstairs?");
                    downstairsDecision = scanner.nextLine();

                    if(downstairsDecision.equals("no")) {
                        System.out.println("...");
                        System.out.println("...");

                        pressEnter();

                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("There's nothing else to do here!");
                    }
                }
            }
        }

        System.out.println("You stepped outside the inn and noticed the King's aide petting three animals.");
        System.out.println("[King's Aide Lawrence]: Good morning " + player.getName() + "! Hope you slept alright.");

        String readyDecision = "";
        while(!readyDecision.equals("yes")) {
            System.out.println("Are you ready to get started?");
            readyDecision = scanner.nextLine();
        }

        System.out.println("Great! Let me teach you the basics of taking care of and managing beasts.");
        System.out.println("First of all, you'll need to choose one of these three lovely creatures.");
        System.out.println("It'll help you immensely to have a beast-friend on your journey.");

        pressEnter();


        String starterChoice = "";
        while(!starterChoice.equals("a") && !starterChoice.equals("b") && !starterChoice.equals("c")
                && !starterChoice.equals("swallow") && !starterChoice.equals("iguana") && !starterChoice.equals("racoon")) {
            System.out.println("So, which'll it be?");
            System.out.println("A: Swallow");
            System.out.println("B: Iguana");
            System.out.println("C: Racoon");

            starterChoice = scanner.nextLine().toLowerCase();
        }

        if(starterChoice.equals("swallow") || starterChoice.equals("a")) {
            System.out.println("Nice choice! The Swallow is a small but nimble beast capable of swift air attacks.");
            System.out.println("As you may have guessed, its elemental affinity lies with air.");
            player.getBestiary().add("swallow");
            rename(CONST.getBeastMap().get("Swallow"));
        } else if(starterChoice.equals("iguana") || starterChoice.equals("b")) {
            System.out.println("Nice choice! The iguana is a slow but steady denizen of the reptilian world.");
            System.out.println("Its elemental affinity lies with Terra.");
            player.getBestiary().add("iguana");
            rename(CONST.getBeastMap().get("Iguana"));
        } else if(starterChoice.equals("racoon") || starterChoice.equals("c")) {
            System.out.println("Nice choice! The racoon is a fast moving and adorable mammal capable of devastating claw attacks.");
            System.out.println("Its elemental affinity lies with Terra.");
            player.getBestiary().add("racoon");
            rename(CONST.getBeastMap().get("Racoon"));
        }

        System.out.println("Here's a little gift from the king: ");
        System.out.println("");
        System.out.println("...");

        pressEnter();

        System.out.println("You got a Bestiary!");
        player.getKeyItems().put("Bestiary", "A perfectly weighted leather-bound book of royal quality. " +
                "A thin leather pouch runs alongside the spine of the" +
                "book with a gilded quiver pen inside. Strangely, the pen never seems to run out of ink.");

        System.out.println();
        System.out.println("Bestiary: " + player.getKeyItems().get("Bestiary"));

        System.out.println("[King's Aide Lawrence]: The king had this exquisite book developed just for your journey.");
        System.out.println("Record all of your observations and insights within here. Be sure to include drawings of every beast!");
        System.out.println();

        pressEnter();

        System.out.println("Fantastic! Now that that's settled, let me tell you a little bit about what to expect on your journey.");

        pressEnter();

        System.out.println("Alongside the many beasts that you will undoubtedly see and, ideally, observe, there will be");
        System.out.println("a number of beast tamers spread throughout Nebulosa. These people, much like yourself,");
        System.out.println("have the remarkable ability to speak with and understand beasts.");

        pressEnter();

        System.out.println("As such, these people have formed special bonds with their pet beasts and can often be found");
        System.out.println("roaming the hills and forests with them. Somewhat intriguingly, many of these beast tamers");
        System.out.println("seem to battle one another as a sort of code of honor. Don't be surprised if you get challenged");
        System.out.println("by one or two along the way.");

        pressEnter();


        System.out.println("There's also something else that we need to discuss.");
        System.out.println("To catch and tame beasts, you will need special food to bond with them.");
        System.out.println("Although there are a few different varieties of beast food that you will find on your journey,");
        System.out.println("by far the most common is the Beast Berry.");
        System.out.println("Here are a few of them.");

        pressEnter();

        System.out.println("...");
        System.out.println("...");
        System.out.println("You got 3 Beast Berries!");
        player.getBeastBaitMap().put("beast berry", 3);

        System.out.println("[King's Aide Lawrence]: These should help get you started on your beast logging adventure.");
        System.out.println("Each type of berry provides a different success multiplier that affects the chance you have of catching beasts.");
        System.out.println("Beast Berries provide the lowest level of success modifier, x1.");

        pressEnter();

        System.out.println("Oh, one last thing " + player.getName() + ". You might get various items throughout your battles with");
        System.out.println("other tamers or see them in shops. Some allow you to heal your beasts, while others might increase their prowess in battle.");
        System.out.println("That about covers everything.");

        pressEnter();

        System.out.println("... I know what you're thinking, " + player.getName() + ", but unfortunately I am under no orders to give you any starting money.");
        System.out.println("As you already know though, a handsome payout is waiting for your return! Good luck my friend!");

        pressEnter();

        System.out.println("[Narrator]: King's Aide Lawrence turned back towards the palace and headed up the stairs.");
        System.out.println("Your journey has just begun!");

        douglasTown();
    }


    public void douglasTown() throws IOException {
        if(player.isQuitGame()) {
            player.save();
            return;
        }

        if(!player.getPlacesVisited().contains("douglas town")) {
            player.getPlacesVisited().add("douglas town");
        }
        player.setCurrentLocation("Douglas Town");

        System.out.println("|||{Douglas Town}|||");
        System.out.println();

        String decision = "";
        while(!decision.equals("read sign") && !decision.equals("a")
                && !decision.equals("visit shop") && !decision.equals("b")
                && !decision.equals("visit palace") && !decision.equals("c")
                && !decision.equals("visit lodge") && !decision.equals("d")
                && !decision.equals("go to visitor's center") && !decision.equals("e")
                && !decision.equals("go to route 1") && !decision.equals("f")
                && !decision.equals("open menu") && !decision.equals("g")) {

            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("A: Read Sign");
            System.out.println("B: Visit Shop");
            System.out.println("C: Visit Palace");
            System.out.println("D: Visit Lodge");
            System.out.println("E: Go to Visitor's Center");
            System.out.println("F: Go to Route 1");
            System.out.println("G: Open Menu");

            decision = scanner.nextLine().toLowerCase();
        }

        switch(decision) {
            case "a":
            case "read sign":
                System.out.println("Douglas Town: A pleasant forest town bustling with traders during the summer season.");
                break;

            case "b":
            case "visit shop":
                douglasTownShop();
                break;

            case "c":
            case "visit palace":
                visitPalace();
                break;

            case "d":
            case "visit lodge":
                visitLodge("Douglas Town");
                break;

            case "e":
            case "go to visitor's center":
                douglasTownVisitorsCenter();
                break;

            case "f":
            case "go to route 1":
                route1("forward");
                break;

            case "g":
            case "open menu":
                menu();
                break;
        }

        douglasTown();
    }


    public void menu() {
        String decision = "";

        while(!decision.equals("a") && !decision.equals("save and quit game")
                && !decision.equals("b") && !decision.equals("exit menu")) {
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("A: Save and Quit Game");
            System.out.println("B: Exit Menu");

            decision = scanner.nextLine();
        }

        if(decision.equals("a") || decision.equals("save and quit game")) {
            player.setLastSavedLocation(player.getCurrentLocation());
            player.setQuitGame(true);
            return;
        }
    }


    public void douglasTownShop() {
        if(!player.getPlacesVisited().contains("town2")) {
            System.out.println("[Douglas Town Shopkeep]: We're not open yet! Check back later!");
            return;
        }

        System.out.println();

        String buyOrSell = "";
        while(!buyOrSell.equals("a") && !buyOrSell.equals("buying")
                && !buyOrSell.equals("b") && !buyOrSell.equals("selling")
                && !buyOrSell.equals("c") && !buyOrSell.equals("exit")) {

            System.out.println("[Douglas Town Shopkeep]: Hi! Are you buying or selling?");
            System.out.println();
            System.out.println("A: Buying");
            System.out.println("B: Selling");
            System.out.println("C: Exit");

            buyOrSell = scanner.nextLine().toLowerCase();
        }

        if(buyOrSell.equals("a") || buyOrSell.equals("buying")) {
            douglasTownBuying();
        } else if(buyOrSell.equals("b") || buyOrSell.equals("selling")) {
            douglasTownSelling();
        } else {
            System.out.println("Exiting shop...");
            return;
        }

        douglasTownBuying();
    }


    public void douglasTownBuying() {
        System.out.println("Here's what we have in stock.");
        System.out.println();
        System.out.println("Shop Items:");
        System.out.println("--------------------");
        System.out.println("Beast Berry (x3): $" + CONST.getItemValues().get("Beast Berry"));
        System.out.println("Lavender Oil: $" + CONST.getItemValues().get("Lavender Oil"));
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Your money: $" + player.getMoney());

        String purchaseDecision = "";
        while(!purchaseDecision.equals("beast berry") && !purchaseDecision.equals("lavender oil")
                && !purchaseDecision.equals("quit")) {
            System.out.println("What would you like to purchase? (or quit)");
            purchaseDecision = scanner.nextLine().toLowerCase();
        }

        if(purchaseDecision.equals("quit")) {
            return;
        }

        if(player.getMoney() < CONST.getItemValues().get(purchaseDecision)) {
            System.out.println("Sorry, my friend. You don't have enough money.");
            douglasTownBuying();
            return;
        }

        System.out.println("So, you'd like to purchase a " + purchaseDecision + "?");
        String decideToPurchase = scanner.nextLine();
        while(!decideToPurchase.equals("yes") && !decideToPurchase.equals("no")) {
            System.out.println("Sorry, I didn't quite catch that. Would you like to purchase a " + purchaseDecision + "?");
            decideToPurchase = scanner.nextLine();
        }

        if(decideToPurchase.equals("yes")) {
            System.out.println("Great! You won't be disappointed with this one laddy.");
            player.setMoney(player.getMoney() - CONST.getItemValues().get(purchaseDecision));


            if(purchaseDecision.equals("beast berry")) {
                System.out.println("You got 3 Beast Berries!");
                if(player.getBeastBaitMap().containsKey("beast berry")) {
                    player.getBeastBaitMap().put("beast berry", player.getBeastBaitMap().get("beast berry") + 3);
                } else {
                    player.getBeastBaitMap().put("beast berry", 3);
                }

            } else if(purchaseDecision.equals("lavender oil")) {
                System.out.println("You got a Lavender Oil!");
                if(player.getPotionsMap().containsKey("lavender oil")) {
                    player.getPotionsMap().put("lavender oil", player.getPotionsMap().get("lavender oil") + 1);
                } else {
                    player.getPotionsMap().put("lavender oil", 1);
                }
            }


        } else if(decideToPurchase.equals("no")) {
            System.out.println("No problem laddy! Take your time, take your time.");
        }

        douglasTownBuying();
    }


    public void douglasTownSelling() {
        if(player.getItems().size() == 0) {
            System.out.println("You don't have any items to sell my friend!");
            return;
        }

        System.out.println("What would you like to sell? (or quit)");
        System.out.println();
        System.out.println("Items:");
        System.out.println("--------------------");
        Iterator iter = player.getItems().keySet().iterator();
        while(iter.hasNext()) {
            String currentItem = (String)iter.next();
            System.out.println(currentItem + ": " + player.getItems().get(currentItem));
        }
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Your Money: $" + player.getMoney());

        String decision = scanner.nextLine().toLowerCase();

        if(decision.equals("quit")) {
            douglasTownShop();
            return;
        } else if(!player.getItems().containsKey(decision)) {
            System.out.println("You don't even have that laddy.");
            douglasTownSelling();
            return;
        }

        if(player.getItems().get(decision) > 1) {
            System.out.println("Laddy, you seem to have more than one " + decision + ". That'll come to $"
                    + (CONST.getItemValues().get(decision) * player.getItems().get(decision)) + ". Would you like to sell them all?");
            String sellAllDecision = scanner.nextLine();
            while(!sellAllDecision.equals("yes") && !sellAllDecision.equals("no")) {
                System.out.println("Well, would you like to sell them all?");
                sellAllDecision = scanner.nextLine();
            }

            if(sellAllDecision.equals("yes")) {
                System.out.println("Great! You got " + (CONST.getItemValues().get(decision) * player.getItems().get(decision)));
                player.setMoney(player.getMoney() + (CONST.getItemValues().get(decision) * player.getItems().get(decision)));
                player.getItems().remove(decision);

                douglasTownSelling();
                return;
            }
        }

        System.out.println("That'll come to $" + CONST.getItemValues().get(decision) + ". So, you'd like to sell just the one?");
        String finalSellDecision = scanner.nextLine();
        while(!finalSellDecision.equals("yes") && !finalSellDecision.equals("no")) {
            System.out.println("Uh, I didn't hear that lad. Would you like to sell just the one?");
            finalSellDecision = scanner.nextLine();
        }

        if(finalSellDecision.equals("yes")) {
            System.out.println("Great! You got $" + CONST.getItemValues().get(decision) + ".");
            player.setMoney(player.getMoney() + CONST.getItemValues().get(decision));
            System.out.println("Your total money is now $" + player.getMoney() + ".");
            player.getItems().remove(decision);
        } else {
            System.out.println("Don't worry about it laddy. Take your time!");
        }

        douglasTownSelling();
    }


    public void visitPalace() {
        System.out.println("[King Winston]: Why, hello " + player.getName() + "!! How's your journey coming along?");
        System.out.println("It's good to see you!");

        pressEnter();

        System.out.println("Hand me your Bestiary and I'll take a look at your progress so far.");
        System.out.println();

        System.out.println("Do you want to give King Winston your Bestiary?");
        String decision = scanner.nextLine();
        while(!decision.equals("yes")) {
            System.out.println("[King Winston]: Sorry " + player.getName() + ", but you're not getting any money until I");
            System.out.println("see how much progress you've made.");
            System.out.println("Do you want to give King Winston your Bestiary?");

            decision = scanner.nextLine();
        }

        if(player.getBestiary().size() < 25) {
            System.out.println("Hahaha! I'm afraid you're going to need to catch a few more beasts before you'll get any reward, my friend.");
            System.out.println("Out you go! There's plenty more beasts just waiting to be tamed!");

            System.out.println("[Narrator]: One of the King's guards led you outside the palace and shut the gilded wooden entrance.");
            return;
        }
    }




    public void visitLodge(String area) {
        System.out.println("[" + area + " Innkeep]: Hi! Welcome to the " + area + " lodge. Staying in a room");
        System.out.println("costs $20 or is free of charge with a Crown Pass.");

        pressEnter();

        System.out.println("You showed your Crown Pass to the Innkeep.");

        System.out.println();

        System.out.println("Wonderful! Have you lodged with us before, or would you like an explanation of how it works?");
        String infoDecision = scanner.nextLine();
        while(!infoDecision.equals("yes") && !infoDecision.equals("yes please")
                && !infoDecision.equals("no") && !infoDecision.equals("no thanks")) {
            System.out.println("Umm, I didn't quite catch that. Could you repeat?");
            infoDecision = scanner.nextLine();
        }

        if(infoDecision.equals("yes") || infoDecision.equals("yes please")) {
            System.out.println("Of course! Each bed is layered with a soft cushion known as a Healing Mattress.");
            System.out.println("Embedded with the essence of cucumbers and lavender oil, Healing Mattresses");
            System.out.println("will fix up any wounds you or your beasts may have overnight.");
        }

        String outsideDecision = "";
        while(!outsideDecision.equals("outside") && !outsideDecision.equals("room")) {
            System.out.println("Where would you like to go? (outside, room)");
            outsideDecision = scanner.nextLine();
        }

        System.out.println("The Innkeep lead you to your room on the second floor and headed back downstairs.");

        pressEnter();

        System.out.println("Although the sheets smelled a tad bit musty, the room had an overall pleasant atmosphere.");
        System.out.println("You hopped into bed and fell asleep immediately.");

        pressEnter();

        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        pressEnter();

        Iterator<String> iter = player.getBeastMap().keySet().iterator();

        while(iter.hasNext()) {
            String currentBeast = iter.next();
            player.getBeastMap().get(currentBeast).setHealth(player.getBeastMap().get(currentBeast).getMaxHealth());
        }

        System.out.println("Bright sun shone through the open windows.");
        System.out.println("You hopped out of bed and headed downstairs.");

        pressEnter();

        System.out.println("[" + area + " Innkeep]: Morning, " + player.getName() + "!");

        pressEnter();

        outsideDecision = "";

        while (!outsideDecision.equals("outside")) {
            System.out.println("Where would you like to go? (outside, room)");
            outsideDecision = scanner.nextLine();
            if (!outsideDecision.equals("outside") && !outsideDecision.equals("room")) {
                System.out.println("Where would you like to go? (outside, room)");
            }

            if (outsideDecision.equals("room")) {
                System.out.println("You headed back to your room. Bright yellow sunlight glistens through the window.");
                System.out.println("The sheets on the bed are all messed up. A spare pillow lays next to the bed.");

                pressEnter();

                System.out.println("The closet, doors half open, contains a hat, robe, and suit.");
                System.out.println("A modest looking chandelier hangs from the ceiling in the center of the room.");

                System.out.println();

                String downstairsDecision = "";
                while(!downstairsDecision.equals("yes")) {
                    System.out.println("Would you like to head back downstairs?");
                    downstairsDecision = scanner.nextLine();

                    if(downstairsDecision.equals("no")) {
                        System.out.println("...");
                        System.out.println("...");

                        pressEnter();

                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("There's nothing else to do here!");
                    }
                }
            }
        }

    }


    public void douglasTownVisitorsCenter() {
        String decision = "";
        while(!decision.equals("a") && !decision.equals("go outside")
                && !decision.equals("b") && !decision.equals("talk to clerk")) {
            System.out.println("[Narrator]: What would you like to do?");
            System.out.println();
            System.out.println("A: Go Outside");
            System.out.println("B: Talk to Clerk");

            decision = scanner.nextLine().toLowerCase();
        }

        if(decision.equals("a") || decision.equals("go outside")) {
            return;
        }

        String infoDecision = "";

        while(!infoDecision.equals("yes") && !infoDecision.equals("no")) {
            System.out.println("[Douglas Town Visitors Center Clerk]: Hiya! Would you like to learn more about Douglas Town's History?");
            infoDecision = scanner.nextLine().toLowerCase();
        }

        if(infoDecision.equals("no")) {
            System.out.println("No problem!");
            douglasTownVisitorsCenter();
            return;
        } else {
            System.out.println("Great! Let's get started.");
            System.out.println("Douglas Town was founded about 200 years ago during the Great Renaissance --");
            System.out.println("the time from about 400 years ago to 100 years ago when colonists from across the planet");
            System.out.println("first flocked to settle the open lands of Nebulosa -- by King Bernard I.");

            System.out.println("");
            pressEnter();
            System.out.println("");

            System.out.println("The only major settlement in the vast Nebulosa Forest for many years, Douglas Town quickly");
            System.out.println("attracted a healthy number of traders after its founding.");
            System.out.println("Today, it is best known for the massive number of trade deals it hosts during the summer season.");

            System.out.println();
            pressEnter();
            System.out.println();

            System.out.println("Save for a vicious dragon attack about 75 years back, much of Douglas Town's History has been a story");
            System.out.println("of slow but steady economic and trade growth. And there you have it!");

            System.out.println("");
            pressEnter();
            System.out.println("");

            douglasTownVisitorsCenter();
        }
    }


    public void route1(String direction) throws IOException {
        if(!player.getPlacesVisited().contains("Route 1")) {
            player.getPlacesVisited().add("Route 1");
        }

        System.out.println("|||{ Route 1 }|||");
        System.out.println();

        int count = 1;
        int routeLength = 10;

        while(count < routeLength) {

            switch(count) {
                case 1:
                    String initialDecision = "";

                    while(!initialDecision.equals("a") && !initialDecision.equals("go forward")
                            && !initialDecision.equals("b") && !initialDecision.equals("return to douglas town")) {
                        System.out.println("What would you like to do?");
                        System.out.println();
                        System.out.println("A: Go Forward");
                        System.out.println("B: Return to Douglas Town");

                        initialDecision = scanner.nextLine().toLowerCase();
                    }

                    if(initialDecision.equals("b") || initialDecision.equals("return to douglas town")) {
                        douglasTown();
                        return;
                    } else {
                        count++;
                    }
                    break;

                case 2:


            }

            String decision = "";
            while(!decision.equals("a") && !decision.equals("go forward")
                    && !decision.equals("b") && !decision.equals("go backward")
                    && !decision.equals("c") && !decision.equals("open menu")) {
                System.out.println("What would you like to do?");
                System.out.println();
                System.out.println("A: Go Forward");
                System.out.println("B: Go Backward");
                System.out.println("C: Open Menu");

                decision = scanner.nextLine().toLowerCase();
            }

            if(decision.equals("a") || decision.equals("go forward")) {
                System.out.println("You took a step forward.");
                if(direction.equals("forward")) {
                    count++;
                } else {
                    count--;
                }
            } else if(decision.equals("b") || decision.equals("go backward")) {
                System.out.println("You took a step backward.");
                if(direction.equals("backward")) {
                    count++;
                } else {
                    count--;
                }
            }
        }
    }







    public void rename(Beast beast) {
        String likeToRename = "";
        if(!player.getBeastMap().containsKey(beast.getName())) {
            while(!likeToRename.equals("yes") && !likeToRename.equals("no")) {
                System.out.println("Would you like to rename your " + beast.getName() + "?");
                likeToRename = scanner.nextLine();
            }
        } else {
            System.out.println("You already have a beast named " + beast.getName() + ". You must rename your beast.");
            likeToRename = "yes";
        }

        if(likeToRename.equals("yes")) {
            String newName = "";
            while(newName.equals("")) {
                System.out.println("What would you like to rename your " + beast.getName() + " to?");
                newName = scanner.nextLine();
            }

            System.out.println("Success! Your " + beast.getName() + " has been renamed to " + newName + ".");

            player.getBeastMap().put(newName, beast);
            player.getBeastMap().get(newName).setName(newName);
        } else {
            System.out.println("Your " + beast.getName() + " was added to your beast list.");
            player.getBeastMap().put(beast.getName(), beast);
        }
    }


    public void pressEnter() {
        System.out.println("<Press enter to continue> ");
        String pressEnter = scanner.nextLine();
        while(!pressEnter.equals("")) {
            System.out.println("<Press enter to continue> ");
            pressEnter = scanner.nextLine();
        }
    }

}


