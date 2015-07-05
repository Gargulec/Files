package me.Guns.Button;

import me.Guns.Screen.ProduceScreen;

public class CloseFactoryOptions extends GunsButton{

	//Constructor
	public CloseFactoryOptions(float x, float y) 
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
		ProduceScreen.factoryOption.setActive(false);
	}

}
