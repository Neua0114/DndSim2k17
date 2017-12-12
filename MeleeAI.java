import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class MeleeAI {

	
	//CODE TESTS (FOR NO ERRORS)
	//TODO: Make sure set Target doesn't fail on empty enemy array (All enemies Dead)
	//TODO: Make sure that the Movement/Combat Method can handle dead enemies. (already does if the main driver handles death)
	
	//BEFORE COMBAT: (TODO: ADD into functions to streamline these things)
	//1. Pass the array of enemies to every character in combat
	//2. Call set target method
	//TODO: Make a variable of allies to pass in
	//3. Pass the X and Y coordinates to every character in combat
	
	//TRYING TO BREAK CODE:
	//Test fights with all characters and creatures
	//Test different positions
	//Test no enemies
	//Test No allies
	//Test Inventory integration
	
	Creature attachedCreature;
	Boolean hasAttacked;
	Boolean hasMoved;
	
	//Position of the character in the 2D array
	int xPos;
	int yPos;
	
	//an arraylist of current living enemies to fight
	ArrayList<Creature> enemies;
	
	//current largest enemy threat
	Creature bigDangerEnemy;
	
	//constructor for the MeleeAI class
	public MeleeAI(Creature attachedCreat) {
		this.attachedCreature = attachedCreat;
		this.hasAttacked = false;
		this.hasMoved = false;
	}
	
	//Method to move the Creature one turn's amount of movement and attack if able
	public void turnMovement(int moveSpeed, int enemyXPos, int enemyYPos, Creature enemy) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int moveAmount = moveSpeed;
		hasAttacked = false;
		while (moveAmount > 0 || hasAttacked == false) {
			//checks to see if adjacent to an enemy
			if (((this.xPos == enemyXPos - 1 || this.xPos == enemyXPos + 1) && this.yPos == enemyYPos) || 
					((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos == enemyXPos)) {
			
					//attachedCreature.attack(enemy);
					useAttackAbility(this.attachedCreature.meleeAbilities, enemy);
					moveAmount = 0;
					this.hasAttacked = true;
					System.out.println(this.attachedCreature.getName() + " has attacked " + enemy.getName());
				//otherwise move like normal
			}else {	
				if (moveAmount > 0) {
					moveAmount = basicRushMovement(moveAmount, enemyXPos, enemyYPos, enemy);			
				} else {
					moveAmount = 0;
					this.hasAttacked = true;
				}
			}
		}
		
		//Prints out the final x and y position of the character
		System.out.println(this.xPos + " x position");
		System.out.println(this.yPos + " y position");
	}
	
	
	//Method to do basic rush movement
	public int basicRushMovement(int moveSpeed, int enemyXPos, int enemyYPos, Creature enemy) {	
			if (this.yPos < enemyYPos - 1) {
				this.yPos += 1;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
				return moveSpeed - 5;
			} else if (this.yPos > enemyYPos + 1) {
				this.yPos -= 1;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
				return moveSpeed - 5;
			} else if ((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos < enemyXPos) {
				this.xPos += 1;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
				return moveSpeed - 5;
			} else if ((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos > enemyXPos) {
				this.xPos -= 1;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
				return moveSpeed - 5;
			}else {
				System.out.println( this.attachedCreature.getName() + " is finished moving");
				this.hasAttacked = true;
				return 0;
			}
	}
	
	//Method to get the current enemies to fight 
	public void getEnemies(ArrayList<Creature> enemiesToFight) {
		this.enemies = enemiesToFight;
	}
	
	//Method to get the location of the attached creature
	public void setXYPositions(int xPosition, int yPosition) {
		this.xPos = xPosition;
		this.yPos = yPosition;
	}
	
	//Method to set the current target of this character
	public void setTarget() {
		int i = 1;
		bigDangerEnemy = this.enemies.get(0);
		while (i < this.enemies.size()) {
			if (this.enemies.get(i).hp > bigDangerEnemy.hp)
			bigDangerEnemy = this.enemies.get(i);
			i++;
		}
	}
	
	
	//getter for bigDangerEnemy
	public Creature getBigDangerEnemy() {
		return this.bigDangerEnemy;
	}
	
	//setter for the enemy ArrayList
	public void setEnemies(ArrayList<Creature> enemies) {
		this.enemies = enemies;
	}
	
	//Method for using abilities of class
	public void useAttackAbility(String[] mAbilities, Creature enemy) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int sizeArra = mAbilities.length;
		Random rand = new Random();
		int value = rand.nextInt(sizeArra);
		
		Method method = this.attachedCreature.getClass().getMethod(mAbilities[value], Creature.class);
		method.invoke(this.attachedCreature, enemy);
	}
	
}
