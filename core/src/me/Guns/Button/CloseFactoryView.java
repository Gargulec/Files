package me.Guns.Button;

import me.Guns.Screen.MapScreen;

public class CloseFactoryView extends GunsButton{

	//Constructor
	public CloseFactoryView(float x, float y) 
	{
		super(x, y, "X");
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
