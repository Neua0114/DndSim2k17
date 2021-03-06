// Merged this with my own Character.java, should have the features of both.

package d20battler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Creature {

	//Member Variables
	int id;
	int mapsize;
	int x;
	int y;
	char icon;
	
	int str;
	int dex;
	int con;
	int intel;
	int wis;
	int cha;
	int maxHealth;
	int ac;
	int movespeed;
	
	Creature attachedCreature;
	Boolean hasAttacked;
	Boolean hasMoved;
	Boolean isRanged = false;
	int range = 75;
	
	Creature[] targetList;
	Creature target;
	
	protected Boolean death = false;
	protected int hp = 0;
	protected String charName;
	int attackStr = 5;
	int playerLvl = 1;
	
	private boolean goingRight;
	
	//Default constructor
	//Todo:  Add in str, dex, etc (should they be passed in as an array?)
	public Creature(int id, int x, int y, int mapsize) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.mapsize = mapsize;
		this.goingRight = true;
		this.icon = 'w';
	}
	
	public int Initiative() {
		int roll1 = Roll.Roller(20);
		return roll1 + dex;
	}
	
	

	
	
	//The AI script of a creature  
	//Default behavior for testing has been to walk right 2 squares each turn and turn around when hitting a wall.
	public void ai() {
		selectTarget();
		meleeAI(10, target);
	} 
	
	public void meleeAI(int moveSpeed, Creature enemy) {
		int moveAmount = moveSpeed;
		hasAttacked = false;
		while (moveAmount != 0 || hasAttacked == false) {
			//checks to see if adjacent to an enemy
			if ((((this.getX() == target.getX() - 1 || this.getX() == target.getX() + 1) && this.getY() == target.getY()) || 
					((this.getY() == target.getY() + 1 || this.getY() == target.getY() - 1) && this.getX() == target.getX())) || isRangedAttack(target.getX(), target.getY())) {
				this.attack(enemy);
				moveAmount = 0;
				hasAttacked = true;
				System.out.println(this.getId() + " has attacked " + target.getId());
			//otherwise move like normal
			}else {
				if (!isRanged) {
					if (moveAmount > 0) {
	 					if (this.getY() < target.getY() - 1) {
							move(0,1);
							moveAmount -= 5;
							System.out.println( this.getId() + " has moved 5 feet towards the enemy");
						} else if (this.getY() > target.getY() + 1) {
							move(0,-1);
							moveAmount -= 5;
							System.out.println( this.getId() + " has moved 5 feet towards the enemy");
						} else if ((this.getY() == target.getY() + 1 || this.getY() == target.getY() - 1) && this.getX() < target.getX()) {
							move(1,0);
							moveAmount -= 5;
							System.out.println( this.getId() + " has moved 5 feet towards the enemy");
						} else if ((this.getY() == target.getY() + 1 || this.getY() == target.getY() - 1) && this.getX() > target.getX()) {
							move(-1,0);
							moveAmount -= 5;
							System.out.println( this.getId() + " has moved 5 feet towards the enemy");
						}else {
							System.out.println( this.getId() + " is finished moving");
							moveAmount = 0;
							hasAttacked = true;
						}
					}else {
						moveAmount = 0;
						this.hasAttacked = true;
					}
				}else {
					if (moveAmount > 0) {
						if (this.getY() < target.getY() - 1 && !isRangedAttack(target.getX(), target.getY())) {
							move(0,1);
							System.out.println( this.attachedCreature.getName() + " has moved 5 y feet towards the enemy");
							moveAmount -= 5;
						} else if (this.getY() > target.getY() + 1 && !isRangedAttack(target.getX(), target.getY())) {
							move(0,-1);
							System.out.println( this.attachedCreature.getName() + " has moved -5 y feet towards the enemy");
							moveAmount -= 5;
						} else if (((this.getY() == target.getY() + 1 || this.getY() == target.getY() - 1) && this.getX() < target.getX()) && !isRangedAttack(target.getX(), target.getY())) {
							move(1,0);
							System.out.println( this.attachedCreature.getName() + " has moved 5 x feet towards the enemy");
							moveAmount -= 5;
						} else if (((this.getY() == target.getY() + 1 || this.getY() == target.getY() - 1) && this.getX() > target.getX()) && !isRangedAttack(target.getX(), target.getY())) {
							move(-1,0);
							System.out.println( this.attachedCreature.getName() + " has moved -5 x feet towards the enemy");
							moveAmount -= 5;
						}else if (isRangedAttack(target.getX(), target.getY())) {
							System.out.println(this.attachedCreature.getName() + " is within Range");
							moveAmount = 0;
						}else {
							System.out.println( this.attachedCreature.getName() + " is finished moving");
							this.hasAttacked = true;
							moveAmount = 0;
						}
					}else {
						this.hasAttacked = true;
					}
				}
			}
		}
	}
	
	//Moves a creature to a given square x and y units away.  
	public void move(int x, int y)	{
	if (this.getX() + x >= this.getMapsize())
		this.setX(this.getMapsize()-1);
	else if (this.getX() + x < 0)
		this.setX(0);
	else
		this.setX(this.getX() + x);
	if (this.getY() + y >= this.getMapsize())
		this.setY(this.getMapsize()-1);
	else if (this.getY() + y < 0)
		this.setY(0);
	else
		this.setY(this.getY() + y);
	}
	
	//Method for using abilities of class
		public void useAttackAbility(String[] mAbilities, Creature enemy) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			int sizeArra = mAbilities.length;
			Random rand = new Random();
			int value = rand.nextInt(sizeArra);
			
			Method method = this.attachedCreature.getClass().getMethod(mAbilities[value], Creature.class);
			method.invoke(this.attachedCreature, enemy);
		}
		
		//Method to check if the character is ranged and in range 
		//returns moveAmount remaining
		public Boolean isRangedAttack(int enemyXPos, int enemyYPos) {
				if (this.isRanged) {
					//checks if in range
					if ((this.getX() == enemyXPos && (Math.abs(this.getY() - enemyYPos) * 5) <= this.range) || 
							(this.getY() == enemyYPos && (Math.abs(this.getX() - enemyXPos) * 5) <= this.range)) {
						return true;
					}else {
						return false;
					}
				}
			return false;
		}
		
		public void setRange() {
			this.isRanged = true;
		}
	
	//Function that attacks an opponent
	public void attack(Creature opponent) {
		opponent.beAttacked(attackStr);
	}
	
	//Function for being attacked
	public void beAttacked(int attackStr) {
		hp -=attackStr;
		
		if(hp <= 0) {
			death = true;
		}
		
		
	}
	
	//Returns creature's id
	public int getId() {
		return id;
	}

	//Changes creature's id
	public void setId(int id) {
		this.id = id;
	}

	//Returns creature's x-coordinate
	public int getX() {
		return x;
	}

	//Sets x-coordinate
	public void setX(int x) {
		this.x = x;
	}

	//Returns creature's y-coordinate
	public int getY() {
		return y;
	}

	//Sets y-coordinate
	public void setY(int y) {
		this.y = y;
	}
	
	//Returns creature's mapsize
	public int getMapsize() {
		return mapsize;
	}
	
	public char getIcon() {
		return icon;
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
	
	public void updateTargetList(Creature[] newList) {
		targetList = newList;
	}
	
	public void selectTarget() {
		target = targetList[1];
	}
	
	//Returns whether or not a creature has died
	public Boolean hasDied() {
		return death;
	}
	
	//Returns the movement speed of each creature
	public int getMoveSpeed() {
		return movespeed;
	}
		
		@Override
	public String toString() {
		return "Character [id=" + id + ", x=" + x + ", y=" + y + "]";
	}

	public void speak() {
		// TODO Auto-generated method stub
		
	}
	
	//Function to heal by health potion
	public void healthPotion() {
		beHealed(I.heal());		
	}
	//Function to use ammo
	public boolean hasAmmo(int type) {
		return I.hasAmmo(type);
	}
	public void useAmmo(int type) {
		I.useAmmo(type);
	}
	//Function to add or subtract from the ammo directly
	public void adjustAmmo(int type, int count) {
		I.addAmmo(type, count);
	}


}
