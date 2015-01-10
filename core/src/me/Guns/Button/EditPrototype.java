package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;

public class EditPrototype extends GunsButton{

	//Prototype
	Prototype prototype;
	
	//Constructor
	public EditPrototype(float x, float y, StudiumComponent parent, Prototype prototype) 
	{
		super(x, y, "Edit", parent);
		this.prototype = prototype;
	}
	
	//Clicked
	public void leftClick()
	{
	}

}
