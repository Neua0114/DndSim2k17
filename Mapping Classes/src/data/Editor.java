package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;
import static helpers.StateManager.*;

public class Editor {

	
	private TileType[] tileTypes;
	private int tileIndex;
	
	public Editor(TileGrid grid){
		
		this.tileTypes = new TileType[11];
		this.tileTypes[0] = TileType.Floor;
		this.tileTypes[1] = TileType.CornerNorthWest;
		this.tileTypes[2] = TileType.CornerNorthEast;
		this.tileTypes[3] = TileType.CornerSouthWest;
		this.tileTypes[4] = TileType.CornerSouthEast;
		this.tileTypes[5] = TileType.WallNorth;
		this.tileTypes[6] = TileType.WallSouth;
		this.tileTypes[7] = TileType.WallEast;
		this.tileTypes[8] = TileType.WallWest;
		this.tileTypes[9] = TileType.HallEastWest;
		this.tileTypes[10] = TileType.HallNorthSouth;
		this.tileIndex = 0;
		

	}
	
	//Sets the tile to current Tile Type
	public void Draw() {
		grid.SetTile((int) Math.floor(Mouse.getX()/SCALE), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/SCALE), tileTypes[tileIndex]);
		
	}
	
	//Draw entities
	public void Draw(int index, boolean characters) {
		if (characters) {
			character.get(index).Draw();
		}
		else{
			monster.get(index).Draw();
		}
	}
	
	//Change tile type
	public void ChangeTile(int num)
	{
		tileIndex = num;
	}
	
	
	
}
