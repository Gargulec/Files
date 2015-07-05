package me.Guns.Button;

import me.Guns.Game;
import me.Guns.Objects;
import me.Guns.Screen.CreateScreen;

public class NextPart extends GunsButton{

	//Constructor
	public NextPart(float x, float y) 
	{
		super(x, y, "Next");
	}
	
	//Clicked
	public void leftClick()
	{
		//Trigger
		if(CreateScreen.selectedPart == 1)
		{
			if(CreateScreen.prototype.getTrigger().getID() < Game.triggersUnlocked.size() - 1)
				CreateScreen.prototype.setTrigger(CreateScreen.prototype.getTrigger().getID() + 1);
			else
				CreateScreen.prototype.setTrigger(0);
		}
		//Barrel
		else if(CreateScreen.selectedPart == 2)
		{
			if(CreateScreen.prototype.getBarrel().getID() < Game.barrelsUnlocked.size() - 1)
				CreateScreen.prototype.setBarrel(CreateScreen.prototype.getBarrel().getID() + 1);
			else
				CreateScreen.prototype.setBarrel(0);
		}
		//Stock
		else if(CreateScreen.selectedPart == 3)
		{
			if(CreateScreen.prototype.getStock() == null)
				CreateScreen.prototype.setStock(0);
			else
			{
				if(CreateScreen.prototype.getStock().getID() < Objects.stocks.size() - 1)
					CreateScreen.prototype.setStock(CreateScreen.prototype.getStock().getID() + 1);
				else
					CreateScreen.prototype.setStock(0);
			}
		}
		//Sight
		else if(CreateScreen.selectedPart == 4)
		{
			if(CreateScreen.prototype.getSight() == null)
				CreateScreen.prototype.setSight(0);
			else
			{
				if(CreateScreen.prototype.getSight().getID() < Objects.sights.size() - 1)
					CreateScreen.prototype.setSight(CreateScreen.prototype.getSight().getID() + 1);
				else
					CreateScreen.prototype.setSight(0);
			}
		}
	}

}
