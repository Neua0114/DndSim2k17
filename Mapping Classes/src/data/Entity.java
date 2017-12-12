package data;


import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.StateManager.*;


public class Entity {

	private float x,y;
	private Texture texture;
	private Tile location;
	private EntityType type;
	private String textName;
	
	public Entity(Texture texture, Tile location , EntityType type) {
		this.texture = texture;
		this.x = location.getX();
		this.y = location.getY();
		this.location = location;
		grid.GetTile(x, y).changeOccupied();
		this.type = type;
	}
	
	public Entity(String textName, Tile location , EntityType type) {
		this.x = location.getX();
		this.y = location.getY();
		this.location = location;
		this.type = type;
		this.textName = textName;
	}
	
	//Draw Entity
	public void Draw() {
		DrawQuadTex(texture,x,y,SCALE,SCALE);
	}
	
	//Move entity north
	public void moveNorth() {
		if(canMove(2))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x, y-SCALE).changeOccupied();
			y -= SCALE;
		}
	}
	
	//Move entity south
	public void moveSouth() {
		if(canMove(3))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x, y+SCALE).changeOccupied();
			y += SCALE;
		}
	}

	//Move entity east
	public void moveEast() {
		if(canMove(0))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x+SCALE, y).changeOccupied();
			x += SCALE;
		}
	}
	
	//Move entity west
	public void moveWest() {
		if(canMove(1))
		{
			grid.GetTile(x, y).changeOccupied();
			grid.GetTile(x-SCALE, y).changeOccupied();
			x -= SCALE;
		}
	}
	
	//Check if the entity can move to the tile they are attempting to move to
	public boolean canMove(int direction) {
		boolean canMove = false;
		
		Tile current = grid.GetTile((int)(x/SCALE), (int)(y/SCALE));
		Tile next;
		
		switch(direction) {
		
		//Checks East
		case 0:
			next = grid.GetTile((int)(x/SCALE)+1, (int)(y/SCALE));
			if(current.getType().walkEast && next.getType().walkWest && !grid.GetTile(x+SCALE, y).getOccupied()) 
			canMove = true;
		else
			canMove = false;
			break;
			
		//Check West
		case 1: 
			next = grid.GetTile((int)(x/SCALE)-1, (int)(y/SCALE));
			if(current.getType().walkWest && next.getType().walkEast && !grid.GetTile(x-SCALE, y).getOccupied()) 
				canMove = true;
			else
				canMove = false;
			break;
			
		//Check North
		case 2:
			next = grid.GetTile((int)(x/SCALE), (int)(y/SCALE)-1);
			if(current.getType().walkNorth && next.getType().walkSouth && !grid.GetTile(x, y-SCALE).getOccupied()) 
				canMove = true;
			else
				canMove = false;
			break;
			
		//Check South
		case 3:
			next = grid.GetTile((int)(x/SCALE), (int)(y/SCALE)+1);
			if(current.getType().walkSouth && next.getType().walkNorth && !grid.GetTile(x, y+SCALE).getOccupied()) 
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
	
	public EntityType getType() {
		return type;
	}
	
	public int getX() {
		return (int) x;
	}
	
	public int getY() {
		return (int) y;
	}
	
	public void setUpTexture() {
		if (textName != null) {
			texture = QuickLoad(textName);
		}
		
	}
	
	public void setOccupied() {
		if(grid.GetTile(x, y).getOccupied())
			grid.GetTile(x, y).changeOccupied();
	}
}
