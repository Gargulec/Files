package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MapScreen;

public class ChooseCountry extends GunsButton{

	//Assigned prototype
	Prototype prototype;
	
	//Constructor
	public ChooseCountry(float x, float y, StudiumComponent parent, Prototype prototype) 
	{
		super(x, y, "Choose", parent);
		this.prototype = prototype;
	}
	
	//Clicked
	public void leftClick()
	{
		MapScreen.countryView.country.setExportedWeapon(this.prototype);
		MapScreen.countryView.opened();
		StudiumScreen.change(Main.main, Main.map);
	}

}
