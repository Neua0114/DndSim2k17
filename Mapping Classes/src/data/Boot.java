package data;


import org.lwjgl.opengl.Display;

import helpers.StateManager;

public class Boot {
	
	//Boolean for wait loop
	public static boolean run = true;
	public Boot() {
		
		
		//Open first menu and wait for response
		StateManager.Update();
		while(run)
		{
			StateManager.Update();
				
		}
		
		
		//Main run for actions
		while(!Display.isCloseRequested())
		{
			
			
			StateManager.Update();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	//Toggle run boolean
	public static void toggleRun() {
		if (run)
			run = false;
		else
			run = true;
	}
	
	public static void main(String[] args) {
		new Boot();
	}
	
}
