package helpers;

import static helpers.Artist.BeginSession;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.*;

import java.util.ArrayList;

//import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import data.Editor;
import data.Entity;
import data.EntityType;
import data.TileGrid;
import gui.EditSelect;
import gui.Load;
import gui.MainMenu;
import gui.Scale;

public class StateManager {
	
	//Custom variable for the current state of the game
	public static enum State {
		LOAD, SCALE, MENU, SIMULATION, EDITOR
	}
	
	public static State state = State.MENU;
	public static MainMenu menu = new MainMenu();
	public static Scale scale = new Scale();
	public static Load load = new Load();
	public static boolean start = false;
	public static int[][] map ;
	public static int mapWidth;
	public static int mapHeight;
	public static ArrayList<Entity> monster = new ArrayList<Entity>();
	public static ArrayList<Entity> character = new ArrayList<Entity>();
	public static TileGrid grid;
	private static Editor editor;
	private static boolean leftMouseDown = false;
	public static boolean toggle = true;
	
	//0 = Tile 1 = Characters 2 = Monsters
	public static int editing;
	public static int characterIndex = 0;
	public static int monsterIndex = 0;
	public static EntityType curType;
	
	public static void Update() {
		
		//Check the state of the game
		switch(state) {
		case SCALE:
			
			
			grid = new TileGrid(map);
			editor = new Editor(grid);
			
			//Sets the open menu to visible
			if (!scale.isVisible()) {
				scale.setVisible(true);

			}
			break;
			
		case LOAD:
			//Sets the open menu to visible
			if (!load.isVisible()) {
				load.setVisible(true);

			}
			break;
		
		case MENU:
			//BeginSession();
			//window.setVisible(false);
			//Sets the open menu to visible
			if (!menu.isVisible()) {
				menu.setVisible(true);

			}
			
			break;
			
			
			
		case SIMULATION:
			//Remove menu
			menu.setVisible(false);
			
			
			
			
			
			
			break;
			
		case EDITOR:
			//Remove menu
			menu.setVisible(false);
			
			//Runs first initiation
			if (!start) {
				BeginSession();
				updateDisplay();
				start = true;
			
				map = new int[mapWidth][mapHeight];
				for(int i=0;i<mapWidth;i++) {
					for(int j=0;j<mapHeight;j++) {
					
						if (i == 0 && j == 0) {
							map[i][j] = 1;
						}else if (i == 0 && j == mapHeight-1) {
							map[i][j] = 3;
						}else if (i == mapWidth-1 && j == 0) {
							map[i][j] = 2;
						}else if (i == mapWidth-1 && j == mapHeight-1) {
							map[i][j] = 4;
						}else if (i == 0) {
							map[i][j] = 8;
						}else if (i == mapWidth-1) {
							map[i][j] = 6;
						}else if (j == 0) {
							map[i][j] = 5;
						}else if (j == mapHeight-1) {
							map[i][j] = 7;
						}else {
							map[i][j] = 0;
						}	
					}
				}
				grid = new TileGrid(map);
				editor = new Editor(grid);
				//Creates the edit menu
				EditSelect editMenu = new EditSelect();
				editMenu.setEdit(editor);
				editMenu.setVisible(true);

			}
			
			
			
			//Checks if the button is click and changes tile
			if(Mouse.isButtonDown(0) && !leftMouseDown) {
				if (editing == 0)
					editor.Draw();
				else if (editing == 1) {
					if(!grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)).getOccupied()) {
						character.add(new Entity(QuickLoad(curType.textureName), grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)), curType));
						characterIndex++;
					}
				}
				else if(editing == 2) {
					if(!grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)).getOccupied()) {
						monster.add(new Entity(QuickLoad(curType.textureName), grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)), curType));
						monsterIndex++;
					}
				}
				else if(editing == 3) {
				
					if(grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)).getOccupied()) {
						for(int i = 0; i< character.size(); i++) {
							if(character.get(i).getLocation() == grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE))) {
								character.remove(i);
								grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)).changeOccupied();
							}
						}
						for(int i = 0; i< monster.size(); i++) {
							if(monster.get(i).getLocation() == grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE))) {
								monster.remove(i);
								grid.GetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE)).changeOccupied();
							}
						}
						
					}
				}
				
				
				
			}
			leftMouseDown = Mouse.isButtonDown(0);
			
		
			//Draws the grid
			DrawGrid();
			DrawEntities();
			break;
		
		}
	}
	
	//Draws Grid
	public static void DrawGrid() {
		grid.Draw();
	}
	
	//Draws all entities in array
	public static void DrawEntities() {
		for(int i=0; i<monster.size(); i++) {
			monster.get(i).setUpTexture();
			monster.get(i).setOccupied();
			monster.get(i).Draw();
		}
		for(int i=0; i<character.size(); i++) {
			character.get(i).setUpTexture();
			character.get(i).setOccupied();
			character.get(i).Draw();
		}
	}
	
	//Toggle variable for action waiting
	public static void toggle() {
		if (toggle)
			toggle = false;
		else 
			toggle = true;
	}
	
	//Toggle variable for action waiting
	public static void setEditing(int num) {
			editing = num;
	}
		
	public static void createGrid() {
		grid = new TileGrid(map);
	}
}
