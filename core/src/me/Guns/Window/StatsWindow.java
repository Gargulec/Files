package me.Guns.Window;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumWindow;
import me.Guns.Game;
import me.Guns.Main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StatsWindow extends StudiumWindow{
	
	//Money
	StudiumLabel money;
	
	//Constructor
	public StatsWindow(float x, float y)
	{
		super(x, y, 200, 50);
		
		setBgColor(new Color(.2f, .2f, .2f, 1));
		
		//Lables
		add(new StudiumLabel(10, 30, this, "Money", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		money = new StudiumLabel(10, 12, this, "", new Color(.1f, .5f, .1f, 1), Main.fontSmall);
		add(money);
	}
	
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
	
		//Update
		money.setText(Game.money + "$");
	}

}
