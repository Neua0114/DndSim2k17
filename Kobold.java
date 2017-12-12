
public class Kobold extends Creature{
	String abilities[] = {"PackTactics"};
	int STR = 7;
	int DEX = 15;
	int CON = 9;
	int INT= 8;
	int WIS = 7;
	int CHA = 8;
	int HP = 5;
	int SPE = 30;
	int AC = 12;
	int HIT = 4;
	
	public Kobold(String charName)
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
	//can be close range or far range at same damage and hit chance ranged is from 30/120ft
	public void attack(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
		
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(4) + 2;
			opponent.beAttacked(attackStr);
		}	
	}
	//if another ally is within 5 feet of the target then the kobold gets advantage
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
		}
		else
			if(roll2 >= opponent.ac)
			{
				attackStr = Roll.Roller(4) + 2;
				opponent.beAttacked(attackStr);
			}
	}
}
