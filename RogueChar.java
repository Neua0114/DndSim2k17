
public class RogueChar extends Creature {
	
	//Instance Variables
		int STR = 0;
		int DEX = 3;
		int CON = 0;
		int INTEL = 1;
		int WIS = 1;
		int CHA = 3;
		int MAXHEALTH = 8;
		int AC = 14;
		int MOVESPEED = 25;
		int HP = 8;
		
	//Other Instance Variables
		String charName;
		Boolean lucky = false;
		

		//Constructor which sets the statistics of the rogue.
		RogueChar(String charName){
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
		
		//Speaking function
		public void Speak() {
			System.out.println("I'm a Rogue. I start with a dagger and a short sword. Here's a list of my stats: ");
			System.out.println("Strength: " + str);
			System.out.println("Dexterity: " + dex);
			System.out.println("Constitution: " + con);
			System.out.println("Intelligence: " + intel);
			System.out.println("Wisdom: " + wis);
			System.out.println("Charisma: " + cha);
			System.out.println("Health Points: " + hp);
			System.out.println("Armor Class: " + ac);
		}
		
		//The roll for the order of the rogue's respective turn in the simulator
		public int Initiative() {
			int roll1 = Roll.Roller(20);
			return roll1 + dex;
		}
		
		
		//function for attacking a monster with the calculated attackStr.
		public void attack(Creature opponent) {
			
				//Whether or not you hit with a sword
				int swordAttack = Roll.Roller(20) + 5;
				
				//Whether or not you hit with a dagger
				int daggerAttack = Roll.Roller(20) + 3;
				int sneakAttack = Roll.Roller(6);
				
				
				
				//Lucky function
				if(!lucky && swordAttack == 6) {
					lucky = true;
					swordAttack = Roll.Roller(20) + 5;
				}
				if(!lucky && daggerAttack == 6) {
					lucky = true;
					daggerAttack = Roll.Roller(20) + 5;
				}
				
				
				
				//Short sword Attack + sneak attack loop
				if(swordAttack > opponent.ac && sneakAttackCount ==0) {
					attackStr = Roll.Roller(6) + 3;
					System.out.println("You have hit your opponent!");
					System.out.println("Attack Strength is: " + attackStr);
					System.out.println("Sneak attack strength is: " + sneakAttack);
					System.out.println("Attacking with my shortsword plus a sneak attack.");
					opponent.beAttacked(attackStr + sneakAttack);
					sneakAttackCount++;
				}
				
				//Normal attack with a sword
				else if(swordAttack > opponent.ac) {
					attackStr = Roll.Roller(6) + 3;
					System.out.println("You have hit your opponent!");
					System.out.println("Attack Strength is: " + attackStr);
					System.out.println("Attacking with my shortsword.");
					opponent.beAttacked(attackStr);
				}
				else {
					System.out.println("You have missed the opponent with the shortsword.");
				}
				
				
				
				//Dagger attack + sneak attack loop
				if(daggerAttack >= opponent.ac && sneakAttackCount == 0) {
					attackStr = Roll.Roller(4) + 3;
					System.out.println("You have hit your opponent!");
					System.out.println("Attack Strength is: " + attackStr);
					System.out.println("Sneak attack strength is: " + sneakAttack);
					System.out.println("Attacking with my dagger plus a sneak attack.");
					opponent.beAttacked(attackStr + sneakAttack);
					sneakAttackCount++;
				}
				
				//Normal dagger attack
				else if(daggerAttack >= opponent.ac) {
					attackStr = Roll.Roller(4) + 3;
					System.out.println("You have hit your opponent!");
					System.out.println("Attack Strength is: " + attackStr);
					System.out.println("Attacking" + "with my dagger.");
					opponent.beAttacked(attackStr);
				}
				
				else {
					System.out.println("You have missed the opponent with the dagger.");
				}
			
			
			
		}
		
		//Special Abilities
		
		//Increases movement speed so the rogue can move more squares at a time
		public void agileMovement(){
			movespeed +=10;
		}
		
		
		
		
		

}
