
public class Ogre extends Creature{
	String abilities[] = {"rangedattack"};
	int STR = 19;
	int DEX = 8;
	int CON = 16;
	int INT = 5;
	int WIS = 7;
	int CHA = 7;
	int HP = 59;
	int SPE = 40;
	int AC = 11;
	int HIT = 6;
	
	public Ogre(String charName)
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
			attackStr = Roll.Roller(8) + Roll.Roller(8) + 4;
			opponent.beAttacked(attackStr);
		}	
	}
	//range is 30/120 feet
	public void rangedattack(Creature opponent)
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
		int initiative = Roll.Roller(20) - 1;
		return initiative;
	}
}
