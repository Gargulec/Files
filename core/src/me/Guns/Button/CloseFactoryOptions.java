package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;

public class CloseFactoryOptions extends GunsButton{

	//Constructor
	public CloseFactoryOptions(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "X", parent);
		//Width
		setWidth(20);
		//Height
		setHeight(20);
		//Is text centred
		setTextCentred(true);
	}
	
	//Clicked
	public void leftClick()
	{
		ProduceScreen.factoryOption.setActive(false);
	}

}
