package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MapScreen;
import me.Guns.Screen.ProduceScreen;

public class ExportAssign extends GunsButton{
	
	//Constructor
	public ExportAssign(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Assign", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		AssignScreen.factory = null;
		AssignScreen.country = MapScreen.countryView.country; 
		StudiumScreen.change(Main.main, Main.assign);
	}

}
