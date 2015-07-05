package me.Guns.Button;

import me.Guns.Window.CountryView;

public class SubstractExportAmount extends GunsButton{

	//Constructor
	public SubstractExportAmount(float x, float y) 
	{
		super(x, y, "-");
	}
	
	//Clicked
	public void leftClick()
	{
		if(CountryView.country.getExportAmount() > 0)
			CountryView.country.setExportAmount(CountryView.country.getExportAmount() - 1);
	}

}
