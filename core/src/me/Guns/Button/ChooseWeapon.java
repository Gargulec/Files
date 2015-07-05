package me.Guns.Button;

import lib.gui.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.CreateScreen;

public class ChooseWeapon extends GunsButton{

	//Assigned prototype
	Prototype prototype;
	
	//Constructor
	public ChooseWeapon(float x, float y, Prototype prototype) 
	{
		super(x, y, "Choose");
		this.prototype = prototype;
	}
	
	//Clicked
	public void leftClick()
	{
		AssignScreen.factory.setProduction(this.prototype);
		StudiumScreen.change(Main.main, Main.produce);
	}

}
