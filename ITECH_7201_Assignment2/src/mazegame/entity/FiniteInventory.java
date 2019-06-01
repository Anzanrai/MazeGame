package mazegame.entity;

import mazegame.entity.utility.WeightLimit;

public class FiniteInventory extends Inventory {
	private double weightLimit;
	
	public FiniteInventory (int strength) {
		super ();
		this.setStrength(strength);
	}
	
	public void setStrength (int strength) {
		weightLimit = (double) WeightLimit.getInstance().getModifier(strength);
	}
	
	public double getWeight () {
		double currentWeight = 0;
		for (Item theItem: this.getItemList().values()) {
			currentWeight += theItem.getWeight();
		}
		return currentWeight;
	}
	
	public boolean addItem (Item theItem) {
		if (weightLimit > theItem.getWeight() + getWeight()) {
			return super.addItem(theItem);
		}
		return false;
	}

	public String getDescription(){
		String response = "";
		for (Item theItem: this.getItemList().values()) {
			response += theItem.getLabel()+"\t\t"+theItem.getWeight()+"\n";
//			currentWeight += theItem.getWeight();
		}
		response += String.format("Gold: %d", this.getGold());
		return response;
	}

	public int getGold(){
		return super.getGold();
	}

	public void addMoney(int goldPieces){
		super.addMoney(goldPieces);
	}

	public boolean removeMoney(int goldPieces){
		return super.removeMoney(goldPieces);
	}

	public Item findItem(String itemLabel)
	{
		Item item = super.findItem(itemLabel);
		return item;
	}

	public Item removeItem(String itemName) {
		return super.removeItem(itemName);
	}

}
