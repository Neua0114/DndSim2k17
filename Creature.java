
public class Creature {
	//Member Variables
	int str;
	int dex;
	int con;
	int intel;
	int wis;
	int cha;
	int maxHealth;
	int ac;
	int movespeed;
	
	protected Boolean death = false;
	protected int hp = 0;
	protected String charName = "";
	int attackStr = 0;
	int healStr = 0;
	int sneakAttackCount = 0;
	int playerLvl = 1;
	
	Inventory I = new Inventory();


	
	
	
	public Creature() {
		
	}
	
	
	//Each Creature speaks as to what statistics they have.
	public void Speak() {
		System.out.println("I'm a Creature. I start with heavy armor and a short sword. Here's a list of my stats: ");
		System.out.println("Strength: " + str);
		System.out.println("Dexterity: " + dex);
		System.out.println("Constitution: " + con);
		System.out.println("Intelligence: " + intel);
		System.out.println("Wisdom: " + wis);
		System.out.println("Charisma: " + cha);
		System.out.println("Health Points: " + maxHealth);
		System.out.println("Armor Class: " + ac);
	}
	
	//Function that attacks an opponent
	public void attack(Creature opponent) {
		opponent.beAttacked(attackStr);
	}
	
	//Function for being attacked
	public void beAttacked(int attackStr) {
		hp = hp-attackStr;
		
		if(maxHealth <= 0) {
			death = true;
			System.out.println("You have died.");
		}
		
		
	}
	
	public void heal(Creature ally) {
		ally.beHealed(healStr);
	}
	
	
	public void beHealed(int healStr) {
		hp += healStr;
		
		if(hp > maxHealth) {
			hp = maxHealth;
			System.out.println("You have been healed above your max health. Excess health lost");
		}
	}
	
	//Set charName
	public void setName(String name) {
		charName = name;
	}
	//Returns name of the creature
	public String getName() {
		return charName;
	}
	//Returns whether or not a creature has died
	public Boolean hasDied() {
		return death;
	}
	
	//Returns the movement speed of each creature
	public int getMoveSpeed() {
		return movespeed;
	}
	
	//Function to heal by health potion
	public void healthPotion() {
		beHealed(I.heal());		
	}
	

}
