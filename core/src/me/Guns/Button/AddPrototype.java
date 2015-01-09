package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
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
	}

}
