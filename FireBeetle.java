
public class FireBeetle extends Creature{
	int STR = 8;
	int DEX = 10;
	int CON = 12;
	int INT= 1;
	int WIS = 7;
	int CHA = 3;
	int HP = 4;
	int SPE = 30;
	int AC = 13;
	int HIT = 1;
	
	public FireBeetle(String charName)
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
			attackStr = Roll.Roller(6) - 1;
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
