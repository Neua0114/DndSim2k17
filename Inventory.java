
public class Inventory {
	//Declare instance Variables
	//Health potions
	private int hpCount; 
	private final String hp = "Health Potion";
	//Ammunition
	private int ammoCount;
	private final String ammo = "Ammunition";
	//Gold
	private int goldCount;
	private final String gold = "Gold";
	
	//Default constructor
	public Inventory() {
		hpCount = 3;
		ammoCount = 15;
		goldCount = 0;
	}
	
	//Add health potions to inventory
	public void addHP(int value) {
		hpCount+=value;
	}
	
	//Return number of health potions remaining
	public int getHP() {
		return hpCount;
	}
	
	//[WIP] Function to heal
	public int heal(int curHealth, int maxHealth) {
		if (hpCount >= 0) {
			hpCount--;
			int hp = maxHealth - curHealth;
			return hp;
		}
		else {
			return 0;
		}
	}

}
