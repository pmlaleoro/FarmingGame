package FarmingGame;
import java.util.Random;
import java.util.Scanner;

public class GameMechanics {
    GameObjects gameObjects = new GameObjects();
    Questions questions = new Questions();
    Scanner scanner = new Scanner(System.in);

    //Method to to log trees
    public void logTrees() {
        System.out.println("\nTo log a tree, type [8] and press enter. ");
        do{
            String[] statements = {"Log the tree.","Continue logging the tree.", "Almost there...", "Almost!", "Really almost!", "You have successfully cut the tree!"};
            for (int i = 0; i < statements.length; i++) {
                if (i == statements.length - 1) {
                    System.out.print("\n" + statements[i]);
                    break;
                } else {
                    System.out.println(statements[i]);
                    int input = ErrorHandling.validateIntegerInputLogTree(8);
                }
            }

            gameObjects.incrementTreesLogged();
            System.out.print("\nYou currently have " + gameObjects.getTreesInInventory() + " tree/s.");
            System.out.print("\nDo you want to log trees again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);
            if (choice == 2) {
                break;
            }
        } while(true);
    }

    //Method to mine rocks
    public void mineRock() {
        do{
            System.out.println("\nTo mine rocks, TYPE AND ENTER the following statement CORRECTLY.\n\n13ShH@n347FgGgHJaMiLla@@4$HMIln3+55");
            System.out.print("Input: ");
            String input = ErrorHandling.validateStringInput();

            if(input.equals("13ShH@n347FgGgHJaMiLla@@4$HMIln3+55")){
                // Update total rocks mined
                gameObjects.incrementRocksMined();
                System.out.println("You currently have " + gameObjects.getRocksInInventory() + " rock/s.");
                System.out.print("\nDo you want to mine again? ([1] Yes or [2] No): ");
                int choice = ErrorHandling.validateIntegerInputValue(1,2);

                if (choice == 2) {
                    break;
                }
            } else{
                System.out.println("The one you entered does not match with the statement. Try again.");
                continue;
            }
        } while(true);
    }

    // Method to fish
    public void fish() {
        Random random = new Random();
        do {
            System.out.println("\nFishing...");
                if (random.nextBoolean()) {
                    System.out.println("You caught a fish!");
                    gameObjects.incrementFishCaught();
                } else {
                    System.out.println("You didn't catch any fish this time.");
                }
            System.out.println("You currently have " + gameObjects.getFishInInventory() + " fish/es.");
            System.out.print("\nDo you want to fish again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

                if (choice == 2) {
                    break;
                }
        } while (true);
    }

    // Method to feed animals
    public void feedAnimals() {
        do{
            System.out.print("\nWhich farm animal you want to feed? ([1] Chicken, [2] Pig, [3] Cow): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,3);

            switch (choice) {
                case 1:
                    System.out.println("To feed the chickens, you need to answer first a question.\nIf you'll be able to answer the question correctly, you'll have the opportunity to feed the chickens and you will get a REWARD after.\n ");
                    questions.randomQuestions();
                    break;
                case 2:
                    System.out.println("To feed the pigs, you need to answer first a question.\nIf you'll be able to answer the question correctly, you'll have the opportunity to feed the pigs and you will get a REWARD after. ");
                    questions.randomQuestions();
                    break;
                case 3:
                    System.out.println("To feed the cows, you need to answer first a question.\nIf you'll be able to answer the question correctly, you'll have the opportunity to feed the cows and you will get a REWARD after. ");
                    questions.randomQuestions();
                    break;
            }
            System.out.print("Do you want to feed the animals again? ([1] Yes or [2] No): ");
            int choice1 = ErrorHandling.validateIntegerInputValue(1,2);
                if(choice1 == 2){
                    break;
                }
        } while(true);
    }

    // Method to collect water
    public void collectWater() {
        do{
            System.out.println("\nCollecting water...");
            System.out.println("Your bucket is full!");

           gameObjects.incrementWaterCollected();
            System.out.println("\nYou currently have " + gameObjects.getWaterInInventory() + " water.");
            System.out.print("Do you want to collect water again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);
                if (choice == 2) {
                    break;
                }
        } while(true);
    }

    //Method to plant crops
    public void plantCrops() {
        do{
            int seedlingsInInventory = gameObjects.getSeedlingsInInventory();

                if (seedlingsInInventory == 0) {
                    System.out.println("\nYou don't have any seedlings to plant.");
                    break;
                }

            System.out.println("\nSeedlings in inventory: " + seedlingsInInventory);
            System.out.print("Enter the quantity you want to plant: ");
            int quantityToPlant = ErrorHandling.validateIntegerInput();

                if (quantityToPlant > seedlingsInInventory) {
                    System.out.println("\nYou don't have enough crops in your inventory.");
                    return;
                } else{
                    gameObjects.incrementPlantedCrops(quantityToPlant);
                    gameObjects.removeSeedlingsInInventory(quantityToPlant);
                    System.out.println("\nYou have planted " + quantityToPlant + " crops on your farm!");
                    System.out.print("Do you want to plant again? ([1] Yes or [2] No): ");
                    int choice = ErrorHandling.validateIntegerInput();

                    if(choice == 2){
                        break;
                    }
                }
        } while (true);
    }

    // Method to harvest crops
    public void harvestCrop() {
        do {
            int plantedCrops = gameObjects.getPlantedCrops();

                if(plantedCrops == 0){
                    System.out.println("\nYou did not plant any crops yet.");
                    break;
                }

            System.out.println("\nYou currently have " + plantedCrops + " crops that you planted.");
            System.out.print("Enter the amount of crops you want to harvest: ");
            int quantity = ErrorHandling.validateIntegerInput();

                if (quantity > plantedCrops){
                    System.out.println("\nYou can't harvest crops more than you planted.");
                    return;
                }

            gameObjects.incrementHarvestedCrops(quantity);;
            gameObjects.removePlantedCropsInInventory(quantity);
            System.out.println("You currently now have " + gameObjects.getHarvestedCrops() + " crop/s in your inventory.");
            System.out.print("\nDo you want to harvest again? ([1] Yes or [2] No): ");
            int choice1 = ErrorHandling.validateIntegerInputValue(1,2);

                if (choice1 == 2) {
                    break;
                }
        } while (true);
    }


 //Method to buy seedlings
    public void buySeedlings() {
        do{
            int seedlingPrice = 2;

            System.out.println("\nCurrent money: $" + gameObjects.getMoneyInInventory());
            System.out.print("Enter the quantity you want to buy: ");
            int quantity = ErrorHandling.validateIntegerInput();
            int totalCost = quantity * seedlingPrice;

                if (totalCost > gameObjects.getMoneyInInventory()) {
                    System.out.println("Insufficient funds!");
                    return;
                }

            gameObjects.incrementSeedlings(quantity);
            gameObjects.setMoneyDecrease(totalCost);
            System.out.println("You have bought " + quantity + " seedlings for $" + totalCost + ".");
            System.out.println("\nCurrent balance: $" + gameObjects.getMoneyInInventory());
            System.out.print("Do you want to buy again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

                if (choice == 2) {
                    break;
                }
        }while(true);
    }

    // Method to sell crops
    public void sellCrops() {
        x:
        do{
            int cropsInInventory = gameObjects.getHarvestedCrops();

                if(cropsInInventory == 0){
                    System.out.println("You don't have any harvested crops in your inventory to sell.");
                    break;
                }

            System.out.println("\nYou have " + gameObjects.getHarvestedCrops() + " crop/s in your inventory.");
            System.out.print("Enter the quantity of crops you want to sell: ");
            int quantity = ErrorHandling.validateIntegerInput();

                if(quantity > cropsInInventory){
                    System.out.println("You can't sell crops greater than in your inventory. Please enter again.");
                    continue x;
                }

            int totalPrice = quantity * 3;
            gameObjects.sellCrops(quantity);
            System.out.println("\nYou have sold " + quantity + " crop/s for $" + totalPrice + ".");
            System.out.println("Current balance: $" + gameObjects.getMoneyInInventory());
            System.out.print("Do you want to sell again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

                if (choice == 2) {
                    break;
                }
        }while(true);
    }

    // Method to sell trees
    public void sellTrees() {
        x:
        do{
            int treesInInventory = gameObjects.getTreesInInventory();

                if(treesInInventory == 0){
                    System.out.println("You dont have any trees in your inventory to sell.");
                    break;
                }

            System.out.println("\nYou have " + gameObjects.getTreesInInventory() + " tree/s in your inventory.");
            System.out.print("Enter the quantity of trees you want to sell: ");
            int quantity = ErrorHandling.validateIntegerInput();

                if(quantity > treesInInventory){
                    System.out.println("You can't sell trees greater than in your inventory. Please enter again.");
                    continue x;
                }

            int totalPrice = quantity * 5;
            gameObjects.sellTrees(quantity);
            System.out.println("\nYou have sold " + quantity + " tree/s for $" + totalPrice + ".");
            System.out.println("Current balance: $" + gameObjects.getMoneyInInventory());
            System.out.print("Do you want to sell again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

            if (choice == 2) {
                break;
            }
        }while(true);
    }

    // Method to sell rocks
    public void sellRocks() {
        x:
        do{
            int rocksInInventory = gameObjects.getRocksInInventory();

                if(rocksInInventory == 0){
                    System.out.println("You dont have any rocks in your inventory to sell.");
                    break;
                }

            System.out.println("\nYou have " + gameObjects.getRocksInInventory() + " rock/s in your inventory.");
            System.out.print("Enter the quantity of rocks you want to sell: ");
            int quantity = ErrorHandling.validateIntegerInput();

                if(quantity > rocksInInventory){
                    System.out.println("You can't sell rocks greater than in your inventory. Please enter again.");
                    continue x;
                }

            int totalPrice = quantity * 3;
            gameObjects.sellRocks(quantity);
            System.out.println("\nYou have sold " + quantity + " rock/s for $" + totalPrice + ".");
            System.out.println("Current balance: $" + gameObjects.getMoneyInInventory());
            System.out.print("Do you want to sell again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

            if (choice == 2) {
                break;
            }
        }while(true);
    }

    // Method sell to fish
    public void sellFish() {
        x:
        do{
            int fishInInventory = gameObjects.getFishInInventory();

                if(fishInInventory == 0){
                    System.out.println("You don't have any fish in your inventory to sell.");
                    break;
                }

            System.out.println("\nYou have " + gameObjects.getFishInInventory() + " fish/es in your inventory.");
            System.out.print("Enter the quantity of fish you want to sell: ");
            int quantity =ErrorHandling.validateIntegerInput();

                if(quantity > fishInInventory){
                    System.out.println("You can't sell fish greater than in your inventory. Please enter again.");
                    continue x;
                }

            int totalPrice = quantity * 4;
            gameObjects.sellFish(quantity);
            System.out.println("\nYou have sold " + quantity + " fish/es for $" + totalPrice + ".");
            System.out.println("Current balance: $" + gameObjects.getMoneyInInventory());
            System.out.print("Do you want to sell again? ([1] Yes or [2] No): ");
            int choice = ErrorHandling.validateIntegerInputValue(1,2);

            if (choice == 2) {
                break;
            }
        }while(true);
    }
}
