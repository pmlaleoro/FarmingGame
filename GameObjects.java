package FarmingGame;

public class GameObjects {
    int treesInInventory;
    int rocksInInventory;
    int fishInInventory;
    int waterInInventory;
    int seedlingsInInventory;
    int harvestedCropsInInventory;
    int plantedCropsInventory;
    int moneyInInventory;

    // Constructor
    public GameObjects() {
        // Initialize inventory
        treesInInventory = 0;
        rocksInInventory = 0;
        fishInInventory = 0;
        waterInInventory = 0;
        seedlingsInInventory = 0;
        harvestedCropsInInventory = 0;
        plantedCropsInventory = 0;
        moneyInInventory = 100;
    }

    public int getTreesInInventory() {
        return treesInInventory;
    }

    public int getRocksInInventory() {
        return rocksInInventory;
    }

    public int getFishInInventory() {
        return fishInInventory;
    }

    public int getWaterInInventory(){
        return waterInInventory;
    }

    public int getSeedlingsInInventory() {
        return seedlingsInInventory;
    }

    public int getHarvestedCrops() {
        return harvestedCropsInInventory;
    }

    public int getPlantedCrops(){
        return plantedCropsInventory;
    }

    public int getMoneyInInventory(){
        return moneyInInventory;
    }



    public void incrementTreesLogged() {
        treesInInventory += 1;
     }

     public void incrementWaterCollected() {
         waterInInventory += 1;
     }

     public void incrementRocksMined() {
         rocksInInventory += 1;
     }

     public void incrementFishCaught() {
         fishInInventory+= 1;
     }

     public void incrementSeedlings(int amount){
         seedlingsInInventory += amount;
     }

     public void incrementHarvestedCrops(int amount) {
         harvestedCropsInInventory += (amount + 2);
     }

     public void incrementPlantedCrops(int amount){
         plantedCropsInventory += amount;
     }

     public void setMoneyDecrease(int moneyToRemove){
         moneyInInventory -= moneyToRemove;
     }

     public void setMoneyIncrease(int moneytoAdd){
         moneyInInventory += moneytoAdd;
     }



    public void sellTrees(int amount) {
        moneyInInventory += amount * 5; // Price per tree
        treesInInventory -= amount;
    }

    public void sellCrops(int amount) {
        moneyInInventory += amount * 3; // Price per crop
        harvestedCropsInInventory -= amount;
    }

    public void sellRocks(int amount) {
        moneyInInventory += amount * 3; // Price per rock
        rocksInInventory -= amount;
    }

    public void sellFish(int amount) {
        moneyInInventory += amount * 4; // Price per fish
        fishInInventory -= amount;
    }

    // Method to remove crops from inventory
    public void removeCropsInInventory(int amount) {
        harvestedCropsInInventory -= amount;
    }

    public void removeSeedlingsInInventory(int amount){
        seedlingsInInventory -= amount;
    }

    public void removePlantedCropsInInventory(int amount){
        plantedCropsInventory -= amount;
    }
}
