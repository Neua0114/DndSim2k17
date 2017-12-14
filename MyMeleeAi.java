import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class MyMeleeAi {	
	//BEFORE COMBAT: (TODO: ADD into functions to streamline these things)
	//1. Pass the array of enemies to every character in combat
	//2. Set whether the current character is a ranged character
	//3. Call set target method
	//TODO: Make a variable of allies to pass in
	//4. Pass the X and Y coordinates to every character in combat
	
	//TRYING TO BREAK CODE:
	//Test fights with all characters and creatures
	//Test different positions
	//Test no enemies
	//Test No allies
	//Test Inventory integration
	
	MyCreature attachedCreature;
	Boolean hasAttacked;
	Boolean hasMoved;
	
	Boolean isRanged;
	int range = 75;
	
	
	//Position of the character in the 2D array
	int xPos;
	int yPos;
	
	//an arraylist of current living enemies to fight
	ArrayList<MyCreature> enemies;
	
	ArrayList<MyCreature> allies;
	
	//current largest enemy threat
	MyCreature bigDangerEnemy;
	
	//constructor for the MeleeAI class
	public MyMeleeAi(MyCreature myCreatrue) {
		this.attachedCreature = myCreatrue;
		this.hasAttacked = false;
		this.hasMoved = false;
		this.isRanged = false;
	}
	
	//Method to move the Creature one turn's amount of movement and attack if able
	public void turnMovement(int moveSpeed, int enemyXPos, int enemyYPos, MyCreature enemy) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int moveAmount = moveSpeed;
		hasAttacked = false;
		while (moveAmount > 0 || hasAttacked == false) {
			//System.out.println(this.attachedCreature.getName() + " Can shoot enemy " + isRangedAttack(enemyXPos, enemyYPos));
			//checks to see if adjacent to an enemy
			if ((((this.xPos == enemyXPos - 1 || this.xPos == enemyXPos + 1) && this.yPos == enemyYPos) || 
					((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos == enemyXPos)) || isRangedAttack(enemyXPos, enemyYPos)) {
					useAttackAbility(this.attachedCreature.meleeAbilities, enemy);
					moveAmount = 0;
					this.hasAttacked = true;
					System.out.println(this.attachedCreature.getName() + " has attacked " + enemy.getName());
				//otherwise move like normal
			}else {
				//check to see if the character is ranged and in range of enemy
				if (!isRanged) {
					if (moveAmount > 0) {
						moveAmount = basicRushMovement(moveAmount, enemyXPos, enemyYPos, enemy);			
					} else {
						moveAmount = 0;
						this.hasAttacked = true;
					}
				}else {
					if (moveAmount > 0) {
					moveAmount = basicRangeMovement(moveAmount, enemyXPos, enemyYPos, enemy);
					} else {
						this.hasAttacked = true;
					}
				}
			}
		}
		
		//Prints out the final x and y position of the character
		System.out.println(this.xPos + " x position");
		System.out.println(this.yPos + " y position");
	}
	
	
	//Method to do basic rush movement
	public int basicRushMovement(int moveSpeed, int enemyXPos, int enemyYPos, MyCreature enemy) {	
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
	
	public int basicRangeMovement(int moveSpeed, int enemyXPos, int enemyYPos, MyCreature enemy) {
		if (this.yPos < enemyYPos - 1 && !isRangedAttack(enemyXPos, enemyYPos)) {
			this.yPos += 1;
			System.out.println( this.attachedCreature.getName() + " has moved 5 y feet towards the enemy");
			return moveSpeed - 5;
		} else if (this.yPos > enemyYPos + 1 && !isRangedAttack(enemyXPos, enemyYPos)) {
			this.yPos -= 1;
			System.out.println( this.attachedCreature.getName() + " has moved -5 y feet towards the enemy");
			return moveSpeed - 5;
		} else if (((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos < enemyXPos) && !isRangedAttack(enemyXPos, enemyYPos)) {
			this.xPos += 1;
			System.out.println( this.attachedCreature.getName() + " has moved 5 x feet towards the enemy");
			return moveSpeed - 5;
		} else if (((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos > enemyXPos) && !isRangedAttack(enemyXPos, enemyYPos)) {
			this.xPos -= 1;
			System.out.println( this.attachedCreature.getName() + " has moved -5 x feet towards the enemy");
			return moveSpeed - 5;
		}else if (isRangedAttack(enemyXPos, enemyYPos)) {
			System.out.println(this.attachedCreature.getName() + " is within Range");
			return 0;
		}else {
			System.out.println( this.attachedCreature.getName() + " is finished moving");
			this.hasAttacked = true;
			return 0;
		}
	}
	
	//Method to check if the character is ranged and in range 
	//returns moveAmount remaining
	public Boolean isRangedAttack(int enemyXPos, int enemyYPos) {
			if (this.isRanged) {
				//checks if in range
				if ((this.xPos == enemyXPos && (Math.abs(this.yPos - enemyYPos) * 5) <= this.range) || 
						(this.yPos == enemyYPos && (Math.abs(this.xPos - enemyXPos) * 5) <= this.range)) {
					return true;
				}else {
					return false;
				}
			}
		return false;
	}
	
	//Method to get the current enemies to fight 
	public void getEnemies(ArrayList<MyCreature> enemiesToFight) {
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
	public MyCreature getBigDangerEnemy() {
		return this.bigDangerEnemy;
	}
	
	//setter for the enemy ArrayList
	public void setEnemies(ArrayList<MyCreature> enemies) {
		this.enemies = enemies;
	}
	
	public void setRange() {
		this.isRanged = true;
	}
	
	//Method for using abilities of class
	public void useAttackAbility(String[] mAbilities, MyCreature enemy) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int sizeArra = mAbilities.length;
		Random rand = new Random();
		int value = rand.nextInt(sizeArra);
		
		Method method = this.attachedCreature.getClass().getMethod(mAbilities[value], MyCreature.class);
		method.invoke(this.attachedCreature, enemy);
	}
	
}
