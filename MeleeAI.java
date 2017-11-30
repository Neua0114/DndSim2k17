import java.util.ArrayList;

public class MeleeAI {
	
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
	
	//Method to move the Creature one turn's amount of movement
	public void turnMovement(int moveSpeed, int enemyXPos, int enemyYPos) {
		int moveAmount = moveSpeed;
		
		while (moveAmount != 0) {
			if (this.yPos < enemyYPos - 1) {
				this.yPos += 1;
				moveAmount -= 5;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
			} else if (this.yPos > enemyYPos + 1) {
				this.yPos -= 1;
				moveAmount -= 5;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
			} else if ((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos < enemyXPos) {
				this.xPos += 1;
				moveAmount -= 5;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
			} else if ((this.yPos == enemyYPos + 1 || this.yPos == enemyYPos - 1) && this.xPos > enemyXPos) {
				this.xPos -= 1;
				moveAmount -= 5;
				System.out.println( this.attachedCreature.getName() + " has moved 5 feet towards the enemy");
			}else {
				System.out.println( this.attachedCreature.getName() + " is next to the enemy");
				moveAmount = 0;
			}
		}
		System.out.println(this.xPos + " x position");
		System.out.println(this.yPos + " y position");
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
	
}
