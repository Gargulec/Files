package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Country.Country;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MapScreen;
import me.Guns.Window.CountryView;

public class CountryInfo extends GunsButton{

	//Assigned country
	Country country;
	
	//Constructor
	public CountryInfo(float x, float y, StudiumComponent parent, Country country) 
	{
		super(x, y, country.getName(), parent);
		this.country = country;
	}
	
	//Clicked
	public void leftClick()
	{
		CountryView.country = this.country;
		MapScreen.countryView.opened();
		MapScreen.countryView.setActive(true);
	}

}
