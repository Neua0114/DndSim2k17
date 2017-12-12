package data;
import static helpers.Artist.*;
import static helpers.StateManager.*;
public class TileGrid {
	
	public Tile[][] map;

	public TileGrid() {
		map = new Tile[mapWidth][mapHeight];
		for(int i = 0; i <map.length;i++) {
			for(int j = 0; j< map[i].length; j++) {
				
				map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.Floor);
				
			}
		}
	}
	
	public TileGrid(int[][] newMap) {

		
		//Create the new Tile map 
		map = new Tile[mapWidth][mapHeight];
		for(int i = 0; i <map.length;i++) {
			for(int j = 0; j< map[i].length; j++) {

				switch(newMap[i][j]) {
				case 0:
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.Floor);
					break;
				case 1: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.CornerNorthWest);
					break;
				case 2: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.CornerNorthEast);				
					break;
				case 3: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.CornerSouthWest);
					break;
				case 4: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.CornerSouthEast);
					break;
				case 5: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.WallNorth);
					break;
				case 6: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.WallEast);
					break;
				case 7: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.WallSouth);
					break;
				case 8: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.WallWest);
					break;
					
				case 9: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.HallEastWest);
					break;
					
				case 10: 
					map[i][j] = new Tile(i *SCALE, j*SCALE, TileType.HallNorthSouth);
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
				DrawQuadTex(t.getTexture(),t.getX(), t.getY(), SCALE, SCALE);
				
			}
		}
	}
	
	//Set the current tile
	public void SetTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord *SCALE, yCoord * SCALE, type);
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
