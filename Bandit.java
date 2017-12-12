
public class Bandit extends Creature{
	int STR = 11;
	int DEX = 12;
	int CON = 12;
	int INT = 10;
	int WIS = 10;
	int CHA = 10;
	int HP = 11;
	int SPE = 30;
	int AC = 12;
	int HIT = 3;
	
	public Bandit(String charName)
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
			attackStr = Roll.Roller(6) + 1;
			opponent.beAttacked(attackStr);
		}	
	}
	
	//range is 80/320 feet
	public void rangedattack(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
			
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(8) + 4;
			opponent.beAttacked(attackStr);
		}	
	}
			
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 1;
		return initiative;
	}
}
