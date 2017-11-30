package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;
public class Editor {

	
	private TileGrid grid;
	private TileType[] types;
	private int index;
	private int scale;
	
	
	public Editor(TileGrid grid){
		this.grid = grid;
		this.types = new TileType[9];
		this.types[0] = TileType.Floor;
		this.types[1] = TileType.CornerNorthWest;
		this.types[2] = TileType.CornerNorthEast;
		this.types[3] = TileType.CornerSouthWest;
		this.types[4] = TileType.CornerSouthEast;
		this.types[5] = TileType.WallNorth;
		this.types[6] = TileType.WallSouth;
		this.types[7] = TileType.WallEast;
		this.types[8] = TileType.WallWest;
		this.index = 0;
		this.scale = SCALE;
	}
	
	//Sets the tile to current Tile Type
	public void setTile() {
		grid.SetTile((int) Math.floor(Mouse.getX()/scale), (int) Math.floor((HEIGHT - Mouse.getY() - 1)/scale), types[index]);
	}
	
	//Change tile type
	public void ChangeTile(int num)
	{
		index = num;
	}
	
	
	
	
	
	
}
