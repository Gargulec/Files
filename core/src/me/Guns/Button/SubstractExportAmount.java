package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MapScreen;
import me.Guns.Screen.ProduceScreen;
import me.Guns.Window.CountryView;
import me.Guns.Window.FactoryOption;

public class SubstractExportAmount extends GunsButton{

	//Constructor
	public SubstractExportAmount(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "-", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		if(CountryView.country.getExportAmount() > 0)
			CountryView.country.setExportAmount(CountryView.country.getExportAmount() - 1);
	}

}
