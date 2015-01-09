package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.ProduceScreen;
import me.Guns.Window.FactoryOption;

public class HireWorkers extends GunsButton{
	
	//Amount
	int amount;

	//Constructor
	public HireWorkers(float x, float y, StudiumComponent parent, String title, int amount) 
	{
		super(x, y, title, parent);
		
		this.amount = amount;
	}
	
	//Clicked
	public void leftClick()
	{
		FactoryOption.factory.addWorkers(amount);
	}

}
