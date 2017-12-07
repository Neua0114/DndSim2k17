package d20battler;

import java.util.Arrays;

public class D20setup {
	static int idcountTotal;
	static int idcount1;
	static int idcount2;
	static int[][] map;
	static Creature[] units1;
	static Creature[] units2;
	static int[][] initiative;
	static int initCounter;
	static int mapsize;
	

	public D20setup() {

	}


	public static void main(String[] args) {
		idcountTotal = 0;
		idcount1 = 0;
		idcount2 = 0;
		mapsize = 15;
		initCounter = 0;
		
		units1 = new Creature[5];
		units2 = new Creature[5];
		for(int i = 0; i < 5; i++)
	    {
	        units1[i] = new Creature(i+1, 1, i, mapsize);
	        idcountTotal++;
	        idcount1++;
	        units2[i] = new Creature(i+1, 8, i, mapsize);
	        idcountTotal++;
	        idcount2++;
	    }
		initiative = new int[idcountTotal][3];
		for (int i = 0; i < idcount1; i++)
		{
			initiative[initCounter][0] = units1[i].Initiative();
			initiative[initCounter][1] = 1;
			initiative[initCounter][2] = units1[i].getId();
			initCounter++;
		}
		for (int i = 0; i < idcount1; i++)
		{
			initiative[initCounter][0] = units2[i].Initiative();
			initiative[initCounter][1] = 2;
			initiative[initCounter][2] = units2[i].getId();
			initCounter++;
		}
		map = updateMap();
		printMap();
		System.out.println(Arrays.toString(units1));
		System.out.println(Arrays.toString(units2));
		
		for (int i = 0; i < 10; i++) {
			aiCycle();
			map = updateMap();
			printMap();
			System.out.println(Arrays.toString(units1));
			System.out.println(Arrays.toString(units2));
		}

	}
	
	public static void printMap() {
		for (int x = 0; x < mapsize; x++) {
			for (int y = 0; y < mapsize; y++) {
				System.out.print(map[x][y]);
			}
			System.out.println();
		}
	}
	
	public static int[][] updateMap() {
		int[][] map = new int[mapsize][mapsize];
		for (int i = 0; i < idcount1; i++) {
			map[units1[i].getY()][units1[i].getX()] = units1[i].getId();
		}
		for (int i = 0; i < idcount2; i++) {
			map[units2[i].getY()][units2[i].getX()] = units2[i].getId();
		}
		return map;
	}

	private static void aiCycle() {
		for (int i = 0; i < idcountTotal; i++) {
			if (initiative[i][1] == 1)
			{
				units1[initiative[i][2]].ai();
			}				
			else
			{
				units2[initiative[i][2]].ai();
			}				
		}
	}
}
