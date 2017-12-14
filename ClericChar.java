
public class ClericChar extends Creature {
	
	
	String utilityArray[] = {"heal", "ShielfOfFaith"};
	String meleeCombatArray[] = {"Inflict Wounds"};
	//Instance Variables
			int STR = 3;
			int DEX = -1;
			int CON = 1;
			int INTEL = 0;
			int WIS = 3;
			int CHA = 1;
			int MAXHEALTH = 9;
			int AC = 18;
			int MOVESPEED = 30;
			int HP = 9;
			
			//Other Instance Variables
			String charName;
			int stamina = 1;

			ClericChar(String charName){
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
			
			//Function for showing a cleric's base stats.
			public void Speak() {
				System.out.println("I'm a Cleric. I start with a mace. Here's a list of my stats: ");
				System.out.println("Strength: " + str);
				System.out.println("Dexterity: " + dex);
				System.out.println("Constitution: " + con);
				System.out.println("Intelligence: " + intel);
				System.out.println("Wisdom: " + wis);
				System.out.println("Charisma: " + cha);
				System.out.println("Health Points: " + hp);
				System.out.println("Armor Class: " + ac);
			}
			
			//The roll for the order of the cleric's respective turn in the simulator
			public int Initiative() {
				int roll1 = Roll.Roller(20);
				return roll1 + dex;
			}
			
			//Method for attacking an opponent
			public void attack(Creature opponent) {
				int AttackRoll = Roll.Roller(20) + 4;
				
				if(AttackRoll >= opponent.ac) {
					attackStr = Roll.Roller(6) + 2;
					System.out.println("You have hit the enemy with your mace!");
					System.out.println("Your attack strength is: " + attackStr);
					opponent.beAttacked(attackStr);
					
				}
				else {
					System.out.println("You have missed your opponent.");
				}
				
			}
			
			//Special Abilities
			
			//Heals an ally if they are injured. They cannot go over the maximum health value.
			public void heal(Creature ally) {

				int healStr = Roll.Roller(8) + 2;
				System.out.println("You are healing for: " + healStr);
				ally.beHealed(healStr);
			}
			
			//Gives an ally +2 armor class once a fight
			public void ShieldOfFaith(Creature ally) {
				if(stamina >= 1) {
					ally.ac +=2;
					System.out.println("You cannot use this spell again until the fight is over.");
					stamina--;
				}
				
			}
			//Spell for inflicting damage
			public void InflictWounds(Creature opponent) {
				int AttackRoll = Roll.Roller(20) + 4;
				System.out.println("Your AttackRoll is: " + AttackRoll);
				
				if(AttackRoll> opponent.ac) {
					int spellStr = (Roll.Roller(10)) + (Roll.Roller(10)) + (Roll.Roller(10));
					System.out.println("You have hit the enemy with the Inflict Wounds spell");
					System.out.println("Your spell strength is: " + spellStr);
					opponent.beAttacked(spellStr);
				}
				else {
					System.out.println("You have missed your opponent.");
				}
			}
			
			

}
