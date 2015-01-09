package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;

public class ProductionAssign extends GunsButton{
	
	//Constructor
	public ProductionAssign(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Assign", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		AssignScreen.factory = ProduceScreen.factoryOption.factory;
		StudiumScreen.change(Main.main, Main.assign);
	}

}
