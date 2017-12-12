package d20battler;

import java.util.*;

public class D20setup {
	static int idcountTotal;
	static int idcount1;
	static int idcount2;
	static char[][] map;
	static Creature[] units1;
	static Creature[] units2;
	static int[][] initiative;
	static int initCounter;
	static int mapsize;
	
	static Creature whatsit;
	static FighterChar whoozit;
	

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
		
		for (int i = 0; i < 10; i++) {
			aiCycle();
			map = updateMap();
			printMap();
			System.out.println(Arrays.toString(units1));
			System.out.println(Arrays.toString(units2));
		}

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
			if (initiative[i][1] == 1)
			{
				units1[initiative[i][2]].updateTargetList(units2);
				units1[initiative[i][2]].ai();
			}				
			else
			{
				units2[initiative[i][2]].updateTargetList(units1);
				units2[initiative[i][2]].ai();
			}				
		}
	}
}
