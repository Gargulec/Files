package me.Guns.Button;

import me.Guns.Factory.Factory;
import me.Guns.Screen.ProduceScreen;

public class FactoryInfo extends GunsButton{

	//Factory
	Factory factory;
	
	//Constructor
	public FactoryInfo(float x, float y, Factory factory) 
	{
		super(x, y, "Info");
		this.factory = factory;
	}
	
	//Clicked
	public void leftClick()
	{
		ProduceScreen.factoryOption.factory = this.factory;
		ProduceScreen.factoryOption.opened();
		ProduceScreen.factoryOption.setActive(true);
	}

}
