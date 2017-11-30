package data;
import static helpers.Artist.*;
public class TileGrid {
	
	public Tile[][] map;
	private int scale;
	private int width;
	private int height;
	public TileGrid() {
		map = new Tile[width/scale][height/scale];
		for(int i = 0; i <map.length;i++) {
			for(int j = 0; j< map[i].length; j++) {
				
				map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.Floor);
				
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		this.scale = SCALE;
		this.width = WIDTH;
		this.height = HEIGHT;
		
		//Create the new Tile map 
		map = new Tile[width/scale][height/scale];
		for(int i = 0; i <map.length;i++) {
			for(int j = 0; j< map[i].length; j++) {

				switch(newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.Floor);
					break;
				case 1: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.CornerNorthWest);
					break;
				case 2: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.CornerNorthEast);				
					break;
				case 3: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.CornerSouthWest);
					break;
				case 4: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.CornerSouthEast);
					break;
				case 5: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.WallNorth);
					break;
				case 6: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.WallEast);
					break;
				case 7: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.WallSouth);
					break;
				case 8: 
					map[i][j] = new Tile(i *scale, j*scale, scale,scale, TileType.WallWest);
					break;
				
				}
				
				
			}
			
		}
	}
	
	//Draw the tile Grid
	public void Draw() {
		for(int i = 0; i <map.length;i++) {
			for(int j = 0; j< map[i].length; j++) {
				
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(),t.getX(), t.getY(), t.getWidth(), t.getHeight());
				
			}
		}
	}
	
	//Set the current tile
	public void SetTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord *scale, yCoord * scale, scale,scale, type);
	}
	
	//Get tile using int
	public Tile GetTile(int xCoord, int yCoord) {
		return map[xCoord][yCoord];
	}

	//Get tile using float
	public Tile GetTile(float xCoord, float yCoord) {
		return map[(int) xCoord / SCALE][(int) yCoord/ SCALE];
	}
	

}
