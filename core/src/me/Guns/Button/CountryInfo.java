package me.Guns.Button;

import me.Guns.Country.Country;
import me.Guns.Screen.MapScreen;
import me.Guns.Window.CountryView;

public class CountryInfo extends GunsButton{

	//Assigned country
	Country country;
	
	//Constructor
	public CountryInfo(float x, float y, Country country) 
	{
		super(x, y, country.getName());
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
