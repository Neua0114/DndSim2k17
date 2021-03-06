
public class RangerChar extends Creature {
	
	String rangeCombatArray[] = {"fireAttack", "sparkAttack"};
	
	//Instance Variables
	int STR = 1;
	int DEX = 3;
	int CON = 1;
	int INTEL = 0;
	int WIS = 3;
	int CHA = -1;
	int MAXHEALTH = 11;
	int AC = 15;
	int HP = 11;

	//Other instance variables
	String charName;
	int fireArrows = 2;
	int sparkArrows = 1;
	
	RangerChar(String charName){
		this.setName(charName);
		str = STR;
		dex = DEX;
		con = CON;
		intel = INTEL;
		wis = WIS;
		cha = CHA;
		maxHealth = MAXHEALTH;
		ac = AC;
		hp = HP;
	}
	
	//Prints out the stats of each character.
	public void Speak() {
		System.out.println("I'm a Ranger. I start with a bow. Here's a list of my stats: ");
		System.out.println("Strength: " + str);
		System.out.println("Dexterity: " + dex);
		System.out.println("Constitution: " + con);
		System.out.println("Intelligence: " + intel);
		System.out.println("Wisdom: " + wis);
		System.out.println("Charisma: " + cha);
		System.out.println("Health Points: " + hp);
		System.out.println("Armor Class: " + ac);
	}
	
	//Method for the Initiative roll.
	public int Initiative() {
		int roll1 = Roll.Roller(20);
		return roll1 + dex;
	}
	
	//Method for attacking an opponent
	public void attack(Creature opponent) {
		int AttackRoll = Roll.Roller(20) + 5;
		
		if(AttackRoll >= opponent.ac) {
			attackStr = Roll.Roller(8) + 3;
			System.out.println("You have hit the enemy with your arrow!");
			System.out.println("Your attack strength is: " + attackStr);
			opponent.beAttacked(attackStr);
		}
		
		else {
			System.out.println("You have missed your opponent.");
		}
		
	}
	
	
	
	//Special Abilities
	
	//Method for attacking a monster with a fire arrow.
	public void fireAttack(Creature opponent) {
		
		int AttackRoll = Roll.Roller(20) + 5;
		
		if(fireArrows > 0) {
			if(AttackRoll >= opponent.ac) {
				int fireAttackStr = Roll.Roller(3) + 2;
				attackStr = Roll.Roller(8) + 3;
				
				System.out.println("You have hit the enemy with your fire arrow!");
				System.out.println("Your attack strength is: " + (attackStr + fireAttackStr));
				opponent.beAttacked(attackStr + fireAttackStr);
				
				fireArrows--;
			}
			
			else {
				System.out.println("You have missed your opponent.");
				fireArrows--;
			}
		}
		
		else {
			System.out.println("You have no more fire arrows in your quiver.");
		}
		
	}
	
	//Method for attacking a monster with a spark arrow
	public void sparkAttack(Creature opponent) {
		int AttackRoll = Roll.Roller(20) + 5;
		
		if(sparkArrows > 0) {
			if(AttackRoll >= opponent.ac) {
				int sparkAttackStr = Roll.Roller(4) + 3;
				attackStr = Roll.Roller(8) + 3;
				
				System.out.println("You have hit the enemy with your spark arrow!");
				System.out.println("Your attack strength is: " + (attackStr + sparkAttackStr));
				opponent.beAttacked(attackStr + sparkAttackStr);
				
				sparkArrows--;
			}
			
			else {
				System.out.println("You have missed your opponent.");
				sparkArrows--;
			}
		}
		
		else {
			System.out.println("You have no more spark arrows in your quiver.");
		}
	}
	
	
	
	
	
	
}
