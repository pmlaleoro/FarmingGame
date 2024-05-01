package FarmingGame;

public class Main {
    public static void main(String[] args) {
        GameMechanics gameMechanics = new GameMechanics();
        PlayerCharacter playerCharacter = new PlayerCharacter();

        x:
        do{
            System.out.println("\nWelcome to our Farming Game!");
            System.out.println("\nIntroduction: A man stressed from the city decided to live\npeacefully by building a farm in a rural area.\n");

            System.out.print("Please type [1] to continue or [2] to exit the program. ");
            int input = ErrorHandling.validateIntegerInputValue(1,2);
            System.out.println();

                if (input == 2) {
                    break;
                }

            System.out.println("First, let us create your character!");
                playerCharacter.customizeCharacter();
                playerCharacter.displayCharacter();

            System.out.print("\nAfter creating your character. You need to build your house.\nAnd to build it, you should first log trees.\n");
            System.out.print("\nPlease type [1] to continue or [2] to exit the program. ");
            int input1 = ErrorHandling.validateIntegerInputValue(1,2);
            System.out.println();

                if (input1 == 2) {
                    break;
                }

            gameMechanics.logTrees();

            System.out.print("\nDo you want to build your house? ([1] Yes or [2] No): ");
            int buildHouse = ErrorHandling.validateIntegerInput();

                if (buildHouse == 2) {
                    break;
                }

            System.out.println("Building your house...");
            playerCharacter.characterHouse();

            System.out.print("\nYou are now ready to embark with your farm life responsibilities!\nPlease type [1] to continue or [2] to exit the program. ");
            int input2 = ErrorHandling.validateIntegerInputValue(1,2);
            System.out.println();

                if (input2 == 2) {
                    break;
                }
            System.out.println("\nYou have $100 as initial money. Invest it to buy crops and increase it \nwhen you sell your inventories.");

            do{
                System.out.println("\nWhat would you like to do?\nMain options:\n1. Labor Duties\n2. Crop Production\n3. Buy\n4. Sell\n5. See Inventory\n6. Exit the program");
                System.out.print("Choice: ");
                int mainAction = ErrorHandling.validateIntegerInputValue(1, 6);
                switch (mainAction) {
                    case 1:
                        System.out.println("\nLabor Duties: \n1. Log Trees\n2. Mine rock\n3. Fish\n4. Feed Animals\n5. Collect Water");
                        System.out.print("Choice: ");
                        int subAction = ErrorHandling.validateIntegerInputValue(1,5);
                        switch (subAction) {
                            case 1:
                                gameMechanics.logTrees();
                                break;
                            case 2:
                                gameMechanics.mineRock();
                                break;
                            case 3:
                                gameMechanics.fish();
                                break;
                            case 4:
                                gameMechanics.feedAnimals();
                                break;
                            case 5:
                                gameMechanics.collectWater();
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("\nCrop Production: \n1.Plant Crops\n2.Harvest Crops");
                        System.out.print("Choice: ");
                        int subAction2 = ErrorHandling.validateIntegerInputValue(1, 2);
                        switch (subAction2) {
                            case 1:
                                gameMechanics.plantCrops();
                                break;
                            case 2:
                                gameMechanics.harvestCrop();
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("\nYou are only allowed to buy seedlings.");
                        gameMechanics.buySeedlings();
                        break;
                    case 4:
                        System.out.println("\nSell: \n1.Trees\n2.Rocks\n3.Fish\n4.Crops");
                        System.out.print("Choice: ");
                        int subAction3 = ErrorHandling.validateIntegerInputValue(1, 4);
                        switch (subAction3) {
                            case 1:
                                gameMechanics.sellTrees();
                                break;
                            case 2:
                                gameMechanics.sellRocks();
                                break;
                            case 3:
                                gameMechanics.sellFish();
                                break;
                            case 4:
                                gameMechanics.sellCrops();
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("Inventory: ");
                        break;
                    case 6:
                        System.out.println("Exiting the program");
                        break x;
                }
            } while (true);

        }while(true);
    }
}
