
public class Tree extends Creature {
	int STR = 19;
	int DEX = 6;
	int CON = 15;
	int INT= 10;
	int WIS = 10;
	int CHA = 7;
	int HP = 59;
	int SPE = 20;
	int AC = 13;
	int HIT = 6;
	
	public Tree(String charName)
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
	
	public void attack(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
		
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(6) + Roll.Roller(6) + Roll.Roller(6) + 4;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) - 2;
		return initiative;
	}
}
