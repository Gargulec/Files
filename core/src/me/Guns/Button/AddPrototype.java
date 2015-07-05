package me.Guns.Button;

import lib.gui.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Screen.CreateScreen;

public class AddPrototype extends GunsButton{

	//Constructor
	public AddPrototype(float x, float y) 
	{
		super(x, y, "Create");
	}
	
	//Clicked
	public void leftClick()
	{
		Game.prototypes.add(CreateScreen.prototype.copy());
		StudiumScreen.change(Main.main, Main.prototypes);
	}

}
