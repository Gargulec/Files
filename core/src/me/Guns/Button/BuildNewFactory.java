package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Factory.Factory;
import me.Guns.Screen.CreateScreen;

public class BuildNewFactory extends GunsButton{

	//Constructor
	public BuildNewFactory(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Build new factory", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		if(Game.factories.size() < 12)
			Factory.buildNewFactory();
	}

}
