package data;

public enum TileType {
	
	//Types of tiles
	Floor("Dark",true,true,true,true),
	CornerNorthEast("CornerNorthEast",false,true,false,true),
	CornerNorthWest("CornerNorthWest",false,true,true,false),
	CornerSouthEast("CornerSouthEast",true,false,false,true),
	CornerSouthWest("CornerSouthWest",true,false,true,false),
	WallNorth("WallNorth",false,true,true,true),
	WallSouth("WallSouth",true,false,true,true),
	WallEast("WallEast",true,true,false,true),
	WallWest("WallWest",true,true,true,false),
	HallEastWest("HallEastWest",true,true,false,false),
	HallNorthSouth("HallNorthSouth",false,false,true,true);
	
	
	String textureName;
	boolean walkNorth;
	boolean walkSouth;
	boolean walkEast;
	boolean walkWest;
	
	TileType(String textureName, boolean walkNorth, boolean walkSouth, boolean walkEast, boolean walkWest){
		this.textureName = textureName;
		this.walkNorth = walkNorth;
		this.walkSouth = walkSouth;
		this.walkEast = walkEast;
		this.walkWest = walkWest;
	}
	
}
