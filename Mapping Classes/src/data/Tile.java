package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public class Tile {

	private float x, y;
	private Texture texture;
	private TileType type;
	private boolean isOccupied = false;
	
	public Tile(float x, float y, TileType type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.texture = QuickLoad(type.textureName);
	}
	
	public Tile(float x, float y) {
		this.x = x;
		this.y = y;

	}
	
	//Draw the Tile
	public void Draw() {
		DrawQuadTex(texture,x,y,SCALE,SCALE);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type =type;
	}
	
	
	//Toggle if tile is occupied
	public void changeOccupied(){
		if (isOccupied)
			isOccupied = false;
		else
			isOccupied = true;
	}
	
	
	public boolean getOccupied() {
		return isOccupied;
	}
	
}
