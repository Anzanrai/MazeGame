package mazegame.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
	private HashMap exits;
//	private HashMap characters;
	private Inventory items;
	private ExitCollection exitCollection;
	private String description;
	private String label;
//	private ArrayList<Item> items = new ArrayList<Item>();
	private NonPlayerCharacter npc;
	
	public Location () {
		exitCollection = new ExitCollection();
		items = new Inventory();
	}
	
	public Location (String description, String label)
	{
		this();
		this.setDescription(description);
		this.setLabel(label);
		exits = new HashMap();
	}

	public Location (String description, String label, NonPlayerCharacter npc){
		exitCollection = new ExitCollection();
		items = new Inventory();
		this.setDescription(description);
		this.setLabel(label);
		exits = new HashMap();
		this.npc = npc;
	}
	
	public boolean addExit (String exitLabel, Exit theExit)
	{
		if (exits.containsKey(exitLabel))
			return false;
		exits.put(exitLabel, theExit);
		return true;
	}

	public Inventory getInventory(){
		return items;
	}

	public ExitCollection getExitCollection (){
		return exitCollection;
	}

	public Exit getExit(String exitLabel){
		return (Exit) exits.get(exitLabel);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String availableExits() {
		StringBuilder returnMsg = new StringBuilder();
		for (Object label: this.exits.keySet()) {
			returnMsg.append("[" + label.toString() + "] ");
		}
		return returnMsg.toString();
	}

	public String getNPCDescription() {
		String response = "";
		if(this.npc != null){
			response = this.npc.getName() + " is here and says "+npc.getConversation();
			if(this.npc.isHostile()){
				response += "This "+this.npc.getName()+" is hostile. Do you want to engage or run? " +
						"Use attack command to attack.";
			}
		} else {
			response = "You are alone here.";
		}

		return response;
	}

	public boolean containsExit(String exitLabel) {
		return exits.containsKey(exitLabel);
	}

	public String toString() {
		return "**********\n" + this.label + "\n**********\n"
				+ "Exits found :: " + availableExits() + "\n**********\n"
				+ this.description + "\n**********\n" + this.getNPCDescription()+"\n";
	}

	public NonPlayerCharacter getNpc(){
		return npc;
	}
}
