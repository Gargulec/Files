package me.Guns.Button;

import lib.gui.StudiumScreen;
import me.Guns.Main;
import me.Guns.Prototype.Prototype;
import me.Guns.Screen.MapScreen;

public class ChooseCountry extends GunsButton{

	//Assigned prototype
	Prototype prototype;
	
	//Constructor
	public ChooseCountry(float x, float y, Prototype prototype) 
	{
		super(x, y, "Choose");
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
