package d20battler;

import java.util.*;

public class D20setup {
	static int idcountTotal;
	static int idcount1;
	static int idcount2;
	static char[][] map;
	static Creature[] units1;
	static Creature[] units2;
	static int unitsRemaining1;
	static int unitsRemaining2;
	static Creature[] targetableUnits1;
	static Creature[] targetableUnits2;
	static int[][] initiative;
	static int initCounter;
	static int mapsize;
	
	static int result;
	

	public D20setup() {

	}


	public static void main(String[] args) {
		idcountTotal = 0;
		idcount1 = 0;
		idcount2 = 0;
		mapsize = 15;
		initCounter = 0;
		result = 0;
		
		
		units1 = new Creature[5];
		units2 = new Creature[5];
		for(int i = 0; i < 5; i++)
	    {
	        units1[i] = new FighterChar(i, 1, i, mapsize);
	        idcountTotal++;
	        idcount1++;
	        units2[i] = new FighterChar(i, 8, i, mapsize);
	        idcountTotal++;
	        idcount2++;
	    }
		generateInitiative();
		units1[1].speak();

		
		map = updateMap();
		printMap();
		System.out.println(Arrays.toString(units1));
		System.out.println(Arrays.toString(units2));
		
		while (result == 0){
			aiCycle();
			map = updateMap();
			printMap();
			System.out.println(Arrays.toString(units1));
			System.out.println(Arrays.toString(units2));
		}
		
		if (result == 1)
			System.out.println("Team 1 wins!");
		if (result == 2)
			System.out.println("Team 2 wins!");
	}
	
    private static void generateInitiative() {
    	initiative = new int[idcountTotal][3];
		for (int i = 0; i < idcount1; i++)
		{
			initiative[initCounter][0] = units1[i].Initiative();
			initiative[initCounter][1] = 1;
			initiative[initCounter][2] = units1[i].getId();
			initCounter++;
		}
		for (int i = 0; i < idcount2; i++)
		{
			initiative[initCounter][0] = units2[i].Initiative();
			initiative[initCounter][1] = 2;
			initiative[initCounter][2] = units2[i].getId();
			initCounter++;
		}
		sortbyColumn(initiative, 0);
		System.out.println("The initiative order is:");
		for (int i = 0; i < idcountTotal; i++) {
			System.out.println("Team " + initiative[i][1] + " - ID " + initiative[i][2]);
		}
    }


	// Borrowed sort-by-column method for handling initiative
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {
          @Override             
          // Compare values according to columns
          public int compare(final int[] entry1, final int[] entry2) {
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });  // End of function call sort().
    }
	
	public static void printMap() {
		for (int x = 0; x < mapsize; x++) {
			for (int y = 0; y < mapsize; y++) {
				System.out.print(map[x][y]);
			}
			System.out.println();
		}
	}
	
	public static char[][] updateMap() {
		char[][] map = new char[mapsize][mapsize];
		for (int i = 0; i<mapsize; i++) {
			for (int j = 0; j<mapsize; j++) {
				map[i][j] = '+';
			}
		}
		for (int i = 0; i < idcount1; i++) {
			map[units1[i].getY()][units1[i].getX()] = units1[i].getIcon();
		}
		for (int i = 0; i < idcount2; i++) {
			map[units2[i].getY()][units2[i].getX()] = units2[i].getIcon();
		}
		return map;
	}

	private static void aiCycle() {
		for (int i = 0; i < idcountTotal; i++) {
			unitsRemaining1 = 0;
			unitsRemaining2 = 0;
			for (int j = 0; j <idcount1; j++) {
				if(!units1[j].hasDied()){
					unitsRemaining1++;
				}
			}
			for (int j = 0; j <idcount2; j++) {
				if(!units2[j].hasDied()){
					unitsRemaining2++;
				}
			}
			if (unitsRemaining2 == 0)
				result = 1;
			if (unitsRemaining1 == 0)
				result = 2;
			if (result == 0){
				if (initiative[i][1] == 1)
				{
					targetableUnits2 = new Creature[unitsRemaining2];
					for (int j = 0; j <idcount2; j++) {
						if(!units2[j].hasDied()){
							unitsRemaining2--;
							targetableUnits2[unitsRemaining2] = units2[j];
						}						
					}
					units1[initiative[i][2]].updateTargetList(targetableUnits2);
					if (!units1[initiative[i][2]].hasDied())
						units1[initiative[i][2]].ai();
				}				
				else
				{
					targetableUnits1 = new Creature[unitsRemaining1];
					for (int j = 0; j <idcount1; j++) {
						if(!units1[j].hasDied()){
							unitsRemaining1--;
							targetableUnits1[unitsRemaining1] = units1[j];
						}						
					}
					units2[initiative[i][2]].updateTargetList(targetableUnits1);
					if (!units2[initiative[i][2]].hasDied())
						units2[initiative[i][2]].ai();
				}
			}
		}
	}
}
