import java.util.ArrayList;
import java.util.stream.IntStream;

public class dataTable {
	//ArrayList holding different characters
	private ArrayList<String[]> stat = new ArrayList<String[]>();
	//Array of column titles for table
	private final String[] statName = {"Name", "Death", "Life Status", "Damage", "Ammo Used"};
	//Holds the number of stats in the table
	private int statCount;
	//Array holding the max length of each column
	private int[] statSize;
	//Temporaryish string 
	private String[] temp;
	//Total character length of table
	private int totlen;
	
	//Constructor
	public dataTable() {
		statCount = statName.length;
		statSize = new int[statCount];
		temp = new String[statCount];
		//Sets statSize at each index to be default length of the names
		for (int i = 0;i<statName.length;i++) {statSize[i] = statName[i].length();}
	}
	//Add character to results
	public void addChar(String[] statArray) {
		stat.add(statArray);
		update();
	}
	//Refresh totlen
	public void setTotLen() {
		totlen = IntStream.of(statSize).sum();
		totlen += statCount*5;
	}
	//Update all values
	public void update() {
		//Checks each of the values and sets statSize to the maximum
		for (int i = 0; i < stat.size();i++) {
			for (int j = 0; j < statCount;j++) {
				temp = stat.get(i);
				if (temp[j].length() >= statSize[j]) {statSize[j] = temp[j].length();}
			}
		}
		//Checks to make sure every character has the same amount of values
		for (int i = 0; i < stat.size();i++) {
			if (stat.get(i).length >= statCount) {
				statCount = stat.get(i).length;
			}
		}
		//Makes sure totlen is most up to date
		setTotLen();
	}
	public void printTable() {
		//Update a final time
		update();
		//Draw all aspects of the table
		for (int j = 0; j < statCount;j++) {
			System.out.printf("| %-"+statSize[j]+"s  |",  statName[j]);
		}
		System.out.println("");
	
		for (int i =0;i<totlen;i++) {System.out.print("-");} System.out.println("");
		
		for (int i = 0; i < stat.size();i++) {
			for (int j = 0; j < statCount;j++) {
				System.out.printf("| %-"+statSize[j]+"s  |",  stat.get(i)[j]);
			}
			System.out.println("");
			for (int k =0;k<totlen;k++) {System.out.print("-");} 
			System.out.println("");
		}
	}
}
