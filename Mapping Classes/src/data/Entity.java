package data;


import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;


public class Entity {

	private float x,y,width,height;
	private Texture texture;
	private Tile location;
	private TileGrid grid;
	private int scale;
	
	public Entity(Texture texture, Tile location ,TileGrid grid, int width, int height) {
		this.texture = texture;
		this.x = location.getX();
		this.y = location.getY();
		this.width = width;
		this.height = height;
		this.location = location;
		this.grid = grid;
		this.scale = SCALE;
		grid.GetTile(x, y).changeOccupied();
	}
	
	//Draw Entity
	public void Draw() {
		DrawQuadTex(texture,x,y,width,height);
	}
	
	//Move entity north
	public void moveNorth() {
		if(canMove(2))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x, y-scale).changeOccupied();
			y -= scale;
		}
	}
	
	//Move entity south
	public void moveSouth() {
		if(canMove(3))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x, y+scale).changeOccupied();
			y += scale;
		}
	}

	//Move entity east
	public void moveEast() {
		if(canMove(0))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x+scale, y).changeOccupied();
			x += scale;
		}
	}
	
	//Move entity west
	public void moveWest() {
		if(canMove(1))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x-scale, y).changeOccupied();
			x -= scale;
		}
	}
	
	//Check if the entity can move to the tile they are attempting to move to
	public boolean canMove(int direction) {
		boolean canMove = false;
		
		Tile current = grid.GetTile((int)(x/scale), (int)(y/scale));
		Tile next;
		
		switch(direction) {
		
		//Checks East
		case 0:
			next = grid.GetTile((int)(x/scale)+1, (int)(y/scale));
			if(current.getType().walkEast && next.getType().walkWest && !grid.GetTile(x+scale, y).getOccupied()) 
			canMove = true;
		else
			canMove = false;
			break;
			
		//Check West
		case 1: 
			next = grid.GetTile((int)(x/scale)-1, (int)(y/scale));
			if(current.getType().walkWest && next.getType().walkEast && !grid.GetTile(x-scale, y).getOccupied()) 
				canMove = true;
			else
				canMove = false;
			break;
			
		//Check North
		case 2:
			next = grid.GetTile((int)(x/scale), (int)(y/scale)-1);
			if(current.getType().walkNorth && next.getType().walkSouth && !grid.GetTile(x, y-scale).getOccupied()) 
				canMove = true;
			else
				canMove = false;
			break;
			
		//Check South
		case 3:
			next = grid.GetTile((int)(x/scale), (int)(y/scale)+1);
			if(current.getType().walkSouth && next.getType().walkNorth && !grid.GetTile(x, y+scale).getOccupied()) 
				canMove = true;
			else
				canMove = false;
			break;
		}
		
		
		return canMove;
	}
	
	//Get location
	public Tile getLocation() {
		return location;
	}
	
}
