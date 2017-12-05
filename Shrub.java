
public class Shrub extends Creature{
	int STR = 3;
	int DEX = 8;
	int CON = 11;
	int INT= 10;
	int WIS = 10;
	int CHA = 6;
	int HP = 10;
	int SPE = 20;
	int AC = 9;
	int HIT = 1;
	
	public Shrub(String charName)
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
			attackStr = Roll.Roller(4) - 1;
			if(attackStr == 0)
			{
				attackStr += 1;
			}
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) - 1;
		return initiative;
	}
}
