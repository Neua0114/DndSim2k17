
public class BossGoblin extends Creature  {
	String abilities[]= {"MultiAttack"};
	int STR = 10;
	int DEX = 14;
	int CON = 10;
	int INT= 10;
	int WIS = 8;
	int CHA = 10;
	int HP = 21;
	int SPE = 30;
	int AC = 17;
	int HIT = 4;
	
	public BossGoblin(String charName)
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
			attackStr = Roll.Roller(6) + 2;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 2;
		return initiative;
	}
	//boss goblin can attack a second time with disadvantage
	public void MultiAttack(Creature opponent)
	{
		int roll1 = Roll.Roller(20) + HIT;
		int roll2 = Roll.Roller(20) + HIT;
		
		if (roll1 < roll2)
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