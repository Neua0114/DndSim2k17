
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
		hpCount = 1;
		ammoCount = 15;
		goldCount = 0;
	}
	
	//Add health potion(s) to inventory
	/**
	 * @param value the number of potions to be added to then inventory
	 */
	public void addHP(int value) {
		hpCount+=value;
	}
	
	//Return number of health potions remaining
	/**
	 * @return The amount of health potions remaining
	 */
	public int getHP() {
		return hpCount;
	}
	
	//Function to heal
	/**
	 * @return The amount of health to heal
	 */
	public int heal() {
		if (hpCount > 0) {
			hpCount--;
			return Roll.Roller(4) + Roll.Roller(4) + 2;
		}
		else {
			System.out.println("No health potions remaining.");
			return 0;
		}
	}
	
	//Add ammo to inventory
	/**
	 * @param value The amount of ammo to add to the inventory
	 */
	public void addAmmo(int value) {
		ammoCount+=value;
	}
	
	//Return quantity of ammo remaining
	/**
	 * @return The current amount of ammunition
	 */
	public int getAmmoCount() {
		return ammoCount;
	}
	
	//Function to use ammo
	
	/**
	 * @return True or false depending on if there is ammo to be fired
	 */
	public boolean useAmmo() {
		if (ammoCount > 0) {
			ammoCount--;
			return true;
		}
		else {
			System.out.println("No ammo.");
			return false;
		}
	}
	
	//Add gold to pouch
	/**
	 * @param value The amount of gold to add to the pouch
	 */
	public void addGold(int value) {
		goldCount+=value;
	}
	
	//Return current gold
	/**
	 * @return The amount of gold the charachter has
	 */
	public int getGoldCount() {
		return goldCount;
	}
	
	//Function to spend gold
	/**
	 * @param cost How much gold the character is trying to spend
	 * @return Whether or not they character has enough gold
	 */
	public boolean spend(int cost) {
		if (goldCount - cost >= 0) {
			goldCount -= cost;
			return true;
		}
		else {
			System.out.println("Insufficient Funds.");
			return false;
		}
	}

}
