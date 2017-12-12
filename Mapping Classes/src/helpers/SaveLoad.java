package helpers;

import static helpers.Artist.*;
import static helpers.StateManager.*;
import static helpers.StateManager.grid;
import static helpers.StateManager.map;
import static helpers.StateManager.mapHeight;
import static helpers.StateManager.mapWidth;
import static helpers.StateManager.monster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import data.Entity;
import data.EntityType;
import data.Tile;
import data.TileGrid;


public class SaveLoad {
	
	public static void saveSimulation(String fileName) {
		//Get Map Information 
		String mapData = "";
		for (int i = 0; i < mapWidth; i++){
			for (int j = 0; j < mapHeight; j++){
				mapData += getTileID(grid.GetTile(i, j));
			}
		}
		
		try {
			Properties prop = new Properties();
			prop.setProperty("mapData", mapData);
			
			File file = new File("src/simulations/"+ fileName +".simulation");
			FileOutputStream fileOut = new FileOutputStream(file);
			
			
			//Get and Store Monster Information
			for (int i = 0; i < monster.size(); i++) {
				prop.setProperty("monster."+Integer.toString(i)+".x", Integer.toString(monster.get(i).getX()));
				prop.setProperty("monster."+Integer.toString(i)+".y", Integer.toString(monster.get(i).getY()));
				prop.setProperty("monster."+Integer.toString(i)+".type", monster.get(i).getType().textureName);
			}
			
			//Get and Store Character Information
			for (int i = 0; i < character.size(); i++) {
				prop.setProperty("character."+Integer.toString(i)+".x", Integer.toString(character.get(i).getX()));
				prop.setProperty("character."+Integer.toString(i)+".y", Integer.toString(character.get(i).getY()));
				prop.setProperty("character."+Integer.toString(i)+".type", character.get(i).getType().textureName);
			}
			
			prop.setProperty("numMonsters", Integer.toString(monster.size()));
			prop.setProperty("numCharacters", Integer.toString(character.size()));
			
			prop.setProperty("mapWidth", Integer.toString(mapWidth));
			prop.setProperty("mapHeight", Integer.toString(mapHeight));
			
			prop.setProperty("scale", Integer.toString(SCALE));
			
			prop.store(fileOut, "Simulation Data");
			fileOut.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void loadSimulation(String fileName) {
		Properties prop = new Properties();
		File file = new File("src/simulations/"+ fileName +".simulation");
		
		//Clear array lists
		monster.clear();
		character.clear();
		
		try {
			
			FileInputStream fileIn = new FileInputStream(file);
			prop.load(fileIn);
			mapWidth = Integer.parseInt(prop.getProperty("mapWidth"));
			mapHeight = Integer.parseInt(prop.getProperty("mapHeight"));
			SCALE  = Integer.parseInt(prop.getProperty("scale"));
			
			String tempMap = prop.getProperty("mapData");
			//generate map
			map = new  int[mapWidth][mapHeight];
			for(int i=0; i < mapWidth*mapHeight; i++) {
				for (int j=0; j<mapWidth;j++) {
					for(int k=0; k<mapHeight; k++) {
						map[j][k] = getValue(tempMap.charAt(i));
					}
				}
			}
			
			//createGrid();
			
			//generate monsters
			for(int i = 0; i<Integer.parseInt(prop.getProperty("numMonsters"));i++) {
				int x = Integer.parseInt(prop.getProperty("monster."+Integer.toString(i)+".x"));
				int y = Integer.parseInt(prop.getProperty("monster."+Integer.toString(i)+".y"));
				Tile location = new Tile(x,y);
				String name = prop.getProperty("monster."+Integer.toString(i)+".type");
				EntityType type = getType(name);
				monster.add(new Entity(name,location,type));
			}
			
			//generate characters
			for(int i = 0; i<Integer.parseInt(prop.getProperty("numCharacters"));i++) {
				int x = Integer.parseInt(prop.getProperty("character."+Integer.toString(i)+".x"));
				int y = Integer.parseInt(prop.getProperty("character."+Integer.toString(i)+".y"));
				Tile location = new Tile(x,y);
				String name = prop.getProperty("character."+Integer.toString(i)+".type");
				EntityType type = getType(name);
				character.add(new Entity(name,location,type));
			}
			
			WIDTH = mapWidth * SCALE;
			HEIGHT = mapHeight * SCALE;
			
			fileIn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	private static int getValue(char charAt) {
		
		if (charAt != 'A') {
			return Character.getNumericValue(charAt);
		}else {
			return 10;
		}
	}
	
	private static EntityType getType(String type) {
		EntityType eType = EntityType.CharCleric;
		
		switch(type) {
		case "MonBeetle":
			eType = EntityType.MonBeetle;
			break;
			
		case "MonGoblin":
			eType = EntityType.MonGoblin;
			break;
			
		case "MonHalfOgre":
			eType = EntityType.MonHalfOgre;
			break;
			
		case "MonHobgoblin":
			eType = EntityType.MonHobgoblin;
			break;
			
		case "MonKobold":
			eType = EntityType.MonKobold;
			break;
			
		case "MonOgre":
			eType = EntityType.MonOgre;
			break;
			
		case "MonShrub":
			eType = EntityType.MonShrub;
			break;
			
		case "MonSkeleton":
			eType = EntityType.MonSkeleton;
			break;
			
		case "MonTree":
			eType = EntityType.MonTree;
			break;
			
		case "MonWarHorse":
			eType = EntityType.MonWarHorse;
			break;
			
		case "CharCleric":
			eType = EntityType.CharCleric;
			break;
			
		case "CharWizard":
			eType = EntityType.CharWizard;
			break;
			
		case "CharRogue":
			eType = EntityType.CharRogue;
			break;
			
		case "CharRanger":
			eType = EntityType.CharRanger;
			break;
			
		case "CharFighter":
			eType = EntityType.CharFighter;
			break;
		}
			
		return eType;
	}


	public static String getTileID(Tile t) {
		String ID = "E";
		switch(t.getType()){
		case Floor:
			ID = "0";
			break;
			
		case CornerNorthWest:
			ID = "1";
			break;
				
		case CornerNorthEast:
			ID = "2";
			break;
			
		case CornerSouthWest:
			ID = "3";
			break;
				
		case CornerSouthEast:
			ID = "4";
			break;
			
		case WallNorth:
			ID = "5";
			break;
			
		case WallEast:
			ID = "6";
			break;
				
		case WallSouth:
			ID = "7";
			break;
			
		case WallWest:
			ID = "8";
			break;
			
		case HallEastWest:
			ID = "9";
			break;
			
		case HallNorthSouth:
			ID = "A";
			break;
			
		}
		return ID;
	}
	
}
