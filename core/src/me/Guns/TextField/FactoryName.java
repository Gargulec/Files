package me.Guns.TextField;

import com.badlogic.gdx.math.Vector2;

import lib.gui.StudiumTextField;
import me.Guns.Main;
import me.Guns.Window.FactoryOption;

public class FactoryName extends StudiumTextField{

	//Constructor
	public FactoryName(float x, float y) 
	{
		super(x, y, 200, 26);
		
		//Font
		setFont(Main.fontSmall);
		//Text offset
		setTextOffset(new Vector2(5, 22));
		//Char limit
		setCharLimit(16);
	}

	//Text change
	public void textTyped() 
	{
		if(FactoryOption.factory != null)
			FactoryOption.factory.setName(getText());
		
		System.err.println("Text typed!");
	}
	
}
