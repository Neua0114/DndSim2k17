
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
	
	//Added the AI to the creature base class
	MeleeAI controlAi = new MeleeAI(this);
	
	protected Boolean death = false;
	protected int HP = 0;
	protected String charName;
	int attackStr = 0;
	int playerLvl = 1;


	
	
	
	public Creature() {
		
	}
	
	//Function that attacks an opponent
	public void attack(Creature opponent) {
		opponent.beAttacked(attackStr);
	}
	
	//Function for being attacked
	public void beAttacked(int attackStr) {
		HP -=attackStr;
		
		if(HP <= 0) {
			death = true;
		}
		
		
	}
	
	//added to creature by Thomas Rosik
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
	

}
