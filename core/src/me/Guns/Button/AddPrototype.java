package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Screen.CreateScreen;

public class AddPrototype extends GunsButton{

	//Constructor
	public AddPrototype(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Create", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		Game.prototypes.add(CreateScreen.prototype.copy());
		StudiumScreen.change(Main.main, Main.prototypes);
	}

}
