package me.Guns.TextField;

import com.badlogic.gdx.math.Vector2;

import me.GUI.Component.StudiumComponent;
import me.GUI.Component.StudiumTextField;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Main;
import me.Guns.Window.FactoryOption;

public class PrototypeName extends StudiumTextField{

	//Constructor
	public PrototypeName(float x, float y, StudiumComponent parent) 
	{
		super(x, y, 200, 26, parent);
		
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
	}
	
}
