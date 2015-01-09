package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;

public class FactoryInfo extends GunsButton{

	//Factory
	Factory factory;
	
	//Constructor
	public FactoryInfo(float x, float y, StudiumComponent parent, Factory factory) 
	{
		super(x, y, "Info", parent);
		this.factory = factory;
	}
	
	//Clicked
	public void leftClick()
	{
		ProduceScreen.factoryOption.factory = this.factory;
		ProduceScreen.factoryOption.opened();
		ProduceScreen.factoryOption.setActive(true);
	}

}
