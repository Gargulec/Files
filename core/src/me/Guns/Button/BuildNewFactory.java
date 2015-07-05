package me.Guns.Button;

import me.Guns.Game;
import me.Guns.Factory.Factory;

public class BuildNewFactory extends GunsButton{

	//Constructor
	public BuildNewFactory(float x, float y) 
	{
		super(x, y, "Build new factory");
	}
	
	//Clicked
	public void leftClick()
	{
		if(Game.factories.size() < 12)
			Factory.buildNewFactory();
	}

}
