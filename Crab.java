
public class Crab extends Creature {
	int STR = 13;
	int DEX = 15;
	int CON = 11;
	int INT = 11;
	int WIS = 9;
	int CHA = 3;
	int HP = 13;
	int SPE = 30;
	int AC = 15;
	int HIT = 3;
	
	public Crab(String charName)
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
		int oldspe = opponent.spe;
		boolean grapple = false;
		
		if(roll >= opponent.ac)
		{
			grapple = true;
			attackStr = Roll.Roller(6) + 1;
			opponent.beAttacked(attackStr);
			if(grapple == true)
			{
				opponent.spe = 0;
			}
			if(death == true)
			{
				grapple = false;
				opponent.spe = oldspe;
			}
		}
	}	
}
