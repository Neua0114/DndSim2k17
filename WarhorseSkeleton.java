
public class WarhorseSkeleton extends Creature{
	int STR = 18;
	int DEX = 12;
	int CON = 15;
	int INT = 2;
	int WIS = 8;
	int CHA = 5;
	int HP = 22;
	int SPE = 60;
	int AC = 13;
	int HIT = 6;
	
	public WarhorseSkeleton(String charName)
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
			attackStr = Roll.Roller(6) + Roll.Roller(6) + 4;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 1;
		return initiative;
	}
}
