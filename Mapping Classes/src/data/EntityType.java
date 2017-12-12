package data;

public enum EntityType {
	
	//Types of Entities
	MonBeetle("MonBeetle"),
	MonGoblin("MonGoblin"),
	MonHalfOgre("MonHalfOgre"),
	MonHobgoblin("MonHobgoblin"),
	MonKobold("MonKobold"),
	MonOgre("MonOgre"),
	MonShrub("MonShrub"),
	MonSkeleton("MonSkeleton"),
	MonTree("MonTree"),
	MonWarHorse("MonWarHorse"),
	CharCleric("CharCleric"),
	CharWizard("CharWizard"),
	CharRogue("CharRogue"),
	CharRanger("CharRanger"),
	CharFighter("CharFighter");
	
	public String textureName;

	
	EntityType(String textureName){
		this.textureName = textureName;
		
	}
	
	
}
