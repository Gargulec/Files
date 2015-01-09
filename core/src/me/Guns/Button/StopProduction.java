package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Window.FactoryOption;

public class StopProduction extends GunsButton{

	//Constructor
	public StopProduction(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Stop", parent);
		//Width
		setWidth(70);
	}
	
	//Checking factory status
	public void check()
	{
		if(FactoryOption.factory.isStopped())
			setTitle("Resume");
		else
			setTitle("Stop");
	}
	
	//Clicked
	public void leftClick()
	{
		//Stoping/Resuming production
		FactoryOption.factory.setStopped(!FactoryOption.factory.isStopped());
		//Changing text
		if(FactoryOption.factory.isStopped())
			setTitle("Resume");
		else
			setTitle("Stop");
	}

}
