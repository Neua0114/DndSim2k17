

public class FighterChar extends Creature {
	
	String utilityArray[] = {"defStance", "secondWind"};
	
	//Instance Variables
	
	//SowrdFighter Character Statistics
		int STR = 3;
		int DEX = -1;
		int CON = 2;
		int INTEL = 1;
		int WIS = 0;
		int CHA = 2;
		int MAXHEALTH = 12;
		int AC = 18;
		int MOVESPEED = 35;
		int HP = 12;
		
		
		
		
	//Other instance variables
		String charName;
		Boolean hasArmor = true;
		int stamina = 1;
		
		//Constructor which sets the statistics of the fighter
		public FighterChar(String charName){
			this.setName(charName);
			str = STR;
			dex = DEX;
			con = CON;
			intel = INTEL;
			wis = WIS;
			cha = CHA;
			maxHealth = MAXHEALTH;
			ac = AC;
			movespeed = MOVESPEED;
			hp = HP;
			
		}
			
			
		//Fighter prints out what statistics he has.
			public void Speak() {
				System.out.println("I'm a swordfighter. I start with heavy armor and a short sword. Here's a list of my stats: ");
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
						
			//function for attacking a monster with the calculated attackStr.
			public void attack(Creature opponent) {
				int AttackRoll = Roll.Roller(20) + 5;
				System.out.println("Your attack roll is: " + AttackRoll);
				
				if(AttackRoll >= opponent.ac) {
					attackStr = Roll.Roller(8) + 5;
					
					System.out.println("You have hit your opponent!");
					System.out.println("Your attack Strength is: " + attackStr);
					 
					System.out.println("Attacking" + " with my sword.");
					opponent.beAttacked(attackStr);
				}
				else {
					System.out.println("You have missed the opponent.");
				}
				
			}
			
			
			//Special Abilities
			
			//Fighter enters a defensive stance and gains 1 point to his/her armor class
			public void defStance() {
				if(hasArmor == true) {
					ac +=1;
				}
				
				else {
					ac +=0;
				}
			}
			
			//Fighter gain gain health based off of a 10 sided dice roll + the player level.
			public void secondWind() {
				int num = Roll.Roller(10);
				int heal;
				
				if(stamina >= 1) {
					heal = playerLvl + num;
					System.out.println("Healing for: " + heal);
					hp = hp + heal;
					stamina--;
					System.out.println("Stamina is: " + stamina);
				}
				else {
					System.out.println("You have already used SecondWind.");
				}
				
				if(hp > 12) {
					hp = maxHealth;
					System.out.println("Your new health is maxed at: " + maxHealth);
				}
				
				
				
				
			}
			
			


			

}
