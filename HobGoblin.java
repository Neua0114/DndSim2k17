
public class HobGoblin extends Creature{
	String abilities[] = {"MartialAdvantage"};
	int STR = 13;
	int DEX = 12;
	int CON = 12;
	int INT = 10;
	int WIS = 10;
	int CHA = 9;
	int HP = 11;
	int SPE = 30;
	int AC = 18;
	int HIT = 3;
	
	public HobGoblin(String charName)
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
	//can be close range or far range at same damage and hit chance ranged is from 150/600ft
	public void attack(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
		
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(8) + 1;
			opponent.beAttacked(attackStr);
		}	
	}
	
	public int Initiative()
	{
		int initiative = Roll.Roller(20) + 1;
		return initiative;
	}
	
	//lets hobgoblin do 2d6 damage to an opponent if it is within 5 feet of an ally that is not incapacitated
	public void MartialAdvantage(Creature opponent)
	{
		int roll = Roll.Roller(20) + HIT;
		
		if(roll >= opponent.ac)
		{
			attackStr = Roll.Roller(8) + 1;
			int newattackStr = attackStr + Roll.Roller(6) + Roll.Roller(6);
			opponent.beAttacked(newattackStr);
		}
		
	}
}
