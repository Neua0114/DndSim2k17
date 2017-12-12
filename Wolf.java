
public class Wolf extends Creature{
	String abilities[] = {"PackTactics"};
	int STR = 12;
	int DEX = 15;
	int CON = 12;
	int INT= 3;
	int WIS = 12;
	int CHA = 6;
	int HP = 11;
	int SPE = 40;
	int AC = 13;
	int HIT = 4;
	
	public Wolf(String charName)
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
			attackStr = Roll.Roller(4) + Roll.Roller(4) + 2;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 2;
		return initiative;
	}
	
	//if another ally is within 5 feet of the target then the wolf gets advantage
	public void PackTactics(Creature opponent)
	{
		int roll1 = Roll.Roller(20) + HIT;
		int roll2 = Roll.Roller(20) + HIT;
		
		if (roll1 > roll2)
		{
				if(roll1 >= opponent.ac)
				{
					attackStr = Roll.Roller(4) + 2;
					opponent.beAttacked(attackStr);
				}
			
			else
				if(roll2 >= opponent.ac)
				{
					attackStr = Roll.Roller(4) + 2;
					opponent.beAttacked(attackStr);
				}
		}
	}
}
