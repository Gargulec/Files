package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MapScreen;
import me.Guns.Screen.ProduceScreen;

public class CloseFactoryView extends GunsButton{

	//Constructor
	public CloseFactoryView(float x, float y, StudiumComponent parent) 
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
		MapScreen.countryView.setActive(false);
	}

}
