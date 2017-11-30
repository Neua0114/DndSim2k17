package helpers;

import static helpers.Artist.BeginSession;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.SCALE;
import static helpers.Artist.WIDTH;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import data.Editor;
import data.Entity;
import data.TileGrid;
import gui.EditSelect;
import gui.MainMenu;

public class StateManager {
	
	//Custom variable for the current state of the game
	public static enum State {
		MENU, SIMULATION, EDITOR
	}
	
	public static State state = State.MENU;
	public static MainMenu menu = new MainMenu();
	public static boolean start = false;
	
	private static Entity[] entities;
	private static TileGrid grid;
	private static Editor editor;
	private static int entityTurn = 0;
	private static boolean leftMouseDown = false;
	private static int mode = 0;
	public static boolean toggle = true;
	
	public static void Update() {
		
		//Check the state of the game
		switch(state) {
		case MENU:
			//Sets the open menu to visible
			if (!menu.isVisible()) {
				menu.setVisible(true);

			}
			break;
			
		case SIMULATION:
			//Remove menu
			menu.setVisible(false);
			
			//Runs the first initiation to create the session, map, grid, and Entities array
			if (!start) {
				BeginSession();
				start = true;
				
				int[][] map = new int[WIDTH/SCALE][HEIGHT/SCALE];
				for(int i=0;i<WIDTH/SCALE - 1;i++) {
					for(int j=0;j<HEIGHT/SCALE - 1;j++) {
					
						map[i][j] = 0;
					
					}
				}
			
			
				grid = new TileGrid(map);
				entities = new Entity[1];
				entities[0] = new Entity(QuickLoad("Orc"), grid.GetTile(5,5), grid, SCALE, SCALE);
			}
			
			//Waits for input from Keys, will wait for input from AI
			while(Keyboard.next()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_D && Keyboard.getEventKeyState()){
					entities[entityTurn].moveEast();
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_A && Keyboard.getEventKeyState()){
					entities[entityTurn].moveWest();
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_W && Keyboard.getEventKeyState()){
					entities[entityTurn].moveNorth();
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()){
					entities[entityTurn].moveSouth();
				}
			}
			
			//Draws the grid and Entities on the map
			DrawGrid();
			DrawEntities();
			break;
			
		case EDITOR:
			//Remove menu
			menu.setVisible(false);
			
			//Runs first initiation
			if (!start) {
				BeginSession();
				start = true;
				
				int[][] map = new int[WIDTH/SCALE][HEIGHT/SCALE];
				for(int i=0;i<WIDTH/SCALE - 1;i++) {
					for(int j=0;j<HEIGHT/SCALE - 1;j++) {
					
						map[i][j] = 0;
					
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
			if(Mouse.isButtonDown(0)) {
				editor.setTile();
			}
			leftMouseDown = Mouse.isButtonDown(0);
			
		
			//Draws the grid
			DrawGrid();
				
			break;
		
		}
	}
	
	//Draws Grid
	public static void DrawGrid() {
		grid.Draw();
	}
	
	//Draws all entities in array
	public static void DrawEntities() {
		for(int i=0; i<entities.length; i++) {
			entities[i].Draw();
		}
	}
	
	//Toggle variable for action waiting
	public static void toggle() {
		if (toggle)
			toggle = false;
		else 
			toggle = true;
	}
	
	
}
