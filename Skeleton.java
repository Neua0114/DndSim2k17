
public class Skeleton extends Creature{
	int STR = 10;
	int DEX = 14;
	int CON = 15;
	int INT = 6;
	int WIS = 8;
	int CHA = 5;
	int HP = 13;
	int SPE = 30;
	int AC = 13;
	int HIT = 4;
	
	public Skeleton(String charName)
	{
		this.charName = charName;
		STR = str;
		DEX = dex;
		CON = con;
		INT = intel;
		WIS = wis;
		CHA = cha;
		HP = hp;
		SPE = spe;
		AC = ac;
		
	}
	//can be close range or far range at same damage and hit chance ranged is from 80/320ft
	public void attack(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
		
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(6) + 2;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 2;
		return initiative;
	}
}
