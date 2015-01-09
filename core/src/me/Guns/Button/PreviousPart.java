package me.Guns.Button;

import me.GUI.Component.StudiumComponent;
import me.Guns.Game;
import me.Guns.Screen.CreateScreen;

public class PreviousPart extends GunsButton{

	//Constructor
	public PreviousPart(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "Prev", parent);
	}
	
	//Clicked
	public void leftClick()
	{
		//Trigger
		if(CreateScreen.selectedPart == 1)
		{
			if(CreateScreen.prototype.getTrigger().getID() > 0)
				CreateScreen.prototype.setTrigger(CreateScreen.prototype.getTrigger().getID() - 1);
			else
				CreateScreen.prototype.setTrigger(Game.triggers.size() - 1);
		}
		//Barrel
		else if(CreateScreen.selectedPart == 2)
		{
			if(CreateScreen.prototype.getBarrel().getID() > 0)
				CreateScreen.prototype.setBarrel(CreateScreen.prototype.getBarrel().getID() - 1);
			else
				CreateScreen.prototype.setBarrel(Game.barrels.size() - 1);
		}
	}

}
