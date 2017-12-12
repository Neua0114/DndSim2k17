
public class WizardChar extends Creature {
	
	String rangeCombatArray[] = {"FireBolt", "AcidSplash", "FrostRay", "ShockGrasp", "MagicMissle"};
	String utilityArray[] = {"MageArmor"};		
	
	//Instance Variables
	int STR = 0;
	int DEX = 3;
	int CON = 1;
	int INTEL = 3;
	int WIS = 1;
	int CHA = -1;
	int MAXHEALTH = 7;
	int AC = 13;
	int HP = 7;
	
	//Other instance variables.
	String charName;
	Boolean MageArmor = true;
	
	WizardChar(String charName){
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
			System.out.println("I'm a Wizard. I start with a Shortsword. Here's a list of my stats: ");
			System.out.println("Strength: " + str);
			System.out.println("Dexterity: " + dex);
			System.out.println("Constitution: " + con);
			System.out.println("Intelligence: " + intel);
			System.out.println("Wisdom: " + wis);
			System.out.println("Charisma: " + cha);
			System.out.println("Health Points: " + hp);
			System.out.println("Armor Class: " + ac);
		}
		
		public int Initiative() {
			int roll1 = Roll.Roller(20);
			return roll1 + dex;
		}
		
		public void attack(Creature opponent) {
			int AttackRoll = Roll.Roller(20) + 5;
			
			if(AttackRoll >= opponent.ac) {
				attackStr = Roll.Roller(6) + 3;
				System.out.println("You have hit the enemy with your shortsword!");
				System.out.println("Your attack strength is: " + attackStr);
				opponent.beAttacked(attackStr);
			}
			else {
				System.out.println("You have missed your opponent.");
			}
		}
		
		//Special Abilities
		
		//Fire bolt special ability
		public void FireBolt(Creature opponent) {
			int SpellRoll = Roll.Roller(20) + 5;
			
			if(SpellRoll >= opponent.ac) {
				attackStr = Roll.Roller(10);
				System.out.println("You have hit the enemy with a bolt of fire!");
				System.out.println("Fire bolt damage is: " + attackStr);
				opponent.beAttacked(attackStr);
			}
			else {
				System.out.println("Your fire bolt has splashed.");
			}
		}
		
		//Acid splash special ability
		public void AcidSplash(Creature opponent) {
			int SpellRoll = Roll.Roller(20) + 5;
			
			if(SpellRoll >= opponent.ac) {
				attackStr = Roll.Roller(6);
				System.out.println("You have hit the enemy with a splash of acid!");
				System.out.println("Acid splash damage is: " + attackStr);
				opponent.beAttacked(attackStr);
			}
			else {
				System.out.println("Your acid splash has splashed.");
			}
		}
		
		//Ray of Frost special ability
		public void FrostRay(Creature opponent) {
			int SpellRoll = Roll.Roller(20) + 3;
			
			if(SpellRoll >= opponent.ac) {
				attackStr = Roll.Roller(8);
				System.out.println("You have hit the enemy with a ray of frost!");
				System.out.println("Ray of Frost damage is: " + attackStr);
				opponent.beAttacked(attackStr);
			}
			else {
				System.out.println("Your ray of frost has splashed.");
			}
		}
		
		//Shocking Grasp special ability
		public void ShockingGrasp(Creature opponent) {
			int SpellRoll = Roll.Roller(20) + 4;
			
			if(SpellRoll >= opponent.ac) {
				attackStr = Roll.Roller(8);
				System.out.println("You have hit the enemy with a shock melee spell");
				System.out.println("Shock Grasp damage is: " + attackStr);
				opponent.beAttacked(attackStr);
			}
			else {
				System.out.println("Your shock grasp has splashed.");
			}
		}
		
		//Magic Missile special ability. Shoots 3 darts and never misses.
		public void MagicMissile(Creature opponent) {
			attackStr = (Roll.Roller(4) + 1) * 3;
			
			System.out.println("You have hit the enemy with three magic darts!");
			System.out.println("Magic missile damge is: " + attackStr);
			opponent.beAttacked(attackStr);
		}
		
		//Mage Armor special ability. Grants the wizard there armor class plus dexterity for new armor class value. 
		public void MageArmor() {
			if(MageArmor == true) {
				ac += dex;
				MageArmor = false;
			}
			else {
				System.out.println("You have already used this ability in this fight.");
			}
		}
		
		
		
		
}
