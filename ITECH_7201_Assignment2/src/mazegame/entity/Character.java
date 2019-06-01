package mazegame.entity;

public class Character {
	private int agility;
    private int lifePoints;
    private String name;
    private int strength;
    
//    public Mazegame.Entity.Dice m_Dice;
//    public Mazegame.Entity.Party m_Party;
//    public Mazegame.Entity.Item m_Item;
	private Inventory m_inventory;
    private Shield m_Shield;
    private Weapon m_Weapon;
    private Armour m_Armour;
    
    public Character()
    {
    }

    public Character(String name, int agility, int lifePoints, int strength){
    	this.name = name;
    	this.agility = agility;
    	this.lifePoints = lifePoints;
    	this.strength = strength;
	}

    public Character(String name)
    {
        this.setName(name);
    }

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getStrength() {
		return strength;
	}

	private void setStrength(int strength) {
		this.strength = strength;
	}

	public void equipWeapon(Weapon weapon){
    	this.m_Weapon = weapon;
	}

	public void equipArmour(Armour armour){
    	this.m_Armour = armour;
	}

	public void equipShield(Shield shield){
    	this.m_Shield = shield;
	}

	public String getEquippedWeaponLabel(){
		if(m_Weapon != null){
			return this.m_Weapon.getLabel();
		}
		return "";
	}

	public String getEquippedArmourLabel(){
    	if(m_Armour != null){
			return this.m_Armour.getLabel();
		}
    	return "";
	}

	public String getEquippedShieldLabel(){
		if(m_Shield != null){
			return this.m_Shield.getLabel();
		}
		return "";
	}

	public Weapon getEquippedWeapon(){
    	return m_Weapon;
	}

	public Armour getEquippedArmour(){
    	return m_Armour;
	}

	public Shield getEquippedShield(){
    	return m_Shield;
	}
}
