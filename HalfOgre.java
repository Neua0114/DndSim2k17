
public class HalfOgre extends Creature{
	String abilities[] = {"rangedattack"};
	int STR = 17;
	int DEX = 10;
	int CON = 14;
	int INT = 7;
	int WIS = 8;
	int CHA = 10;
	int HP = 30;
	int SPE = 30;
	int AC = 12;
	int HIT = 5;
	
	public HalfOgre(String charName)
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
			attackStr = Roll.Roller(8) + Roll.Roller(8) + 3;
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
			int initiative = Roll.Roller(20);
			return initiative;
		}
}
