package me.Guns.Button;

import me.Guns.Window.CountryView;

public class AddExportAmount extends GunsButton{

	//Constructor
	public AddExportAmount(float x, float y) 
	{
		super(x, y, "+");
	}
	
	//Clicked
	public void leftClick()
	{
		CountryView.country.setExportAmount(CountryView.country.getExportAmount() + 1);
	}

}
