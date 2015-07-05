package me.Guns.Button;

import lib.gui.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;

public class ProductionAssign extends GunsButton{
	
	//Constructor
	public ProductionAssign(float x, float y) 
	{
		super(x, y, "Assign");
	}
	
	//Clicked
	public void leftClick()
	{
		AssignScreen.country = null;
		AssignScreen.factory = ProduceScreen.factoryOption.factory;
		StudiumScreen.change(Main.main, Main.assign);
	}

}
