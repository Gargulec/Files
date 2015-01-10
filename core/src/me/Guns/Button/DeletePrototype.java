package me.Guns.Button;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;

public class DeletePrototype extends GunsButton{

	//Prototype
	Prototype prototype;
	
	//Constructor
	public DeletePrototype(float x, float y, StudiumComponent parent, Prototype prototype) 
	{
		super(x, y, "Delete", parent);
		this.prototype = prototype;
	}
	
	//Clicked
	public void leftClick()
	{
		Game.prototypes.remove(prototype);
		for(Factory f : Game.factories)
		{
			if(f.getProduction() != null)
				if(f.getProduction() == prototype)
					f.setProduction(null);
		}
		
		StudiumScreen.change(Main.main, Main.complex);
	}
	
	//Draw
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
	}

}
