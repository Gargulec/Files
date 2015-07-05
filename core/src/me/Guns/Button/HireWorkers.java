package me.Guns.Button;

import me.Guns.Window.FactoryOption;

public class HireWorkers extends GunsButton{
	
	//Amount
	int amount;

	//Constructor
	public HireWorkers(float x, float y, String title, int amount) 
	{
		super(x, y, title);
		
		this.amount = amount;
	}
	
	//Clicked
	public void leftClick()
	{
		FactoryOption.factory.addWorkers(amount);
	}

}
