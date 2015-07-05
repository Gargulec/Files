package me.Guns.Window;

import me.Guns.Game;
import me.Guns.Main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import lib.gui.StudiumLabel;

public class StatsWindow extends lib.gui.StudiumWindow{
	
	//Money
	lib.gui.StudiumLabel money;
	
	//Constructor
	public StatsWindow(float x, float y)
	{
		super(x, y, 200, 50);
		
		setBgColor(new Color(.2f, .2f, .2f, 1));
		
		//Lables
		add(new StudiumLabel(10, 30, "Money", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		money = new StudiumLabel(10, 12, "", new Color(.1f, .5f, .1f, 1), Main.fontSmall);
		add(money);
	}
	
	public void draw(SpriteBatch batch, ShapeRenderer renderer) 
	{
		super.draw(batch, renderer);
	
		//Update
		money.setText(Game.money + "$");
	}

}
