package mazegame.entity;

public class Player extends Character {

    private Location currentLocation;
    private FiniteInventory playerInventory = new FiniteInventory(23);

    public Player() {
    }

    public Player(String name) {
        super (name);
        super.setLifePoints(2000);
        super.setAgility(20);
        playerInventory.addItem(new Weapon("Dagger", 10, 5, "Small knife", "1d6"));
        playerInventory.addMoney(500);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getInventoryDescription(){
        return playerInventory.getDescription();
    }

    public boolean addItem(Item item){
        return playerInventory.addItem(item);
    }

    public int getGold(){
        return playerInventory.getGold();
    }

    public void removeMoney(int goldPieces){
        playerInventory.removeMoney(goldPieces);
    }

    public void addMoney(int goldPieces){
        playerInventory.addMoney(goldPieces);
    }

    public Item findItem(String itemLabel){
        Item item = playerInventory.findItem(itemLabel);
        return item;
    }

    public boolean removeItem(String itemName) {
        if(playerInventory.removeItem(itemName) != null){
            return true;
        }
        return false;
    }

    public void equipWeapon(Weapon weapon){
        super.equipWeapon(weapon);
    }

    public void equipArmour(Armour armour){
        super.equipArmour(armour);
    }

    public void equipShield(Shield shield){
        super.equipShield(shield);
    }

    public String getEquippedWeaponLabel(){
        return super.getEquippedWeaponLabel();
    }

    public String getEquippedArmourLabel(){
        return super.getEquippedArmourLabel();
    }

    public String getEquippedShieldLabel(){
        return super.getEquippedShieldLabel();
    }

    public String getPlayerStatus(){
        String responseString = String.format("%-20s\t:%d\n", "HP", getLifePoints());
        responseString += String.format("%-20s\t:%d\n", "Gold", playerInventory.getGold());
        responseString += String.format("%-20s\t:%s\n", "Weapon", this.getEquippedWeaponLabel());
        responseString += String.format("%-20s\t:%s\n", "Armour", this.getEquippedArmourLabel());
        responseString += String.format("%-20s\t:%s\n", "Shield", this.getEquippedShieldLabel());
        return responseString;
    }

    public Weapon getEquippedWeapon(){
        return super.getEquippedWeapon();
    }

    public Armour getEquippedArmour(){
        return super.getEquippedArmour();
    }

    public Shield getEquippedShield(){
        return super.getEquippedShield();
    }
}
