package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Main;
import me.Guns.Button.GunsButtonGoTo;

public class StatsScreen extends StudiumScreen{

	//Lables
	public StudiumLabel income;
	
	//Constructor
	public StatsScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
		//Labels
		add(new StudiumLabel(100, Gdx.graphics.getHeight() - 126, null, "Your statistics", Main.fontSmall));
		income = new StudiumLabel(100, Gdx.graphics.getHeight() - 200, null, "Income  200", Main.fontSmall);
		add(income);
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(100, 100, "Back", null, Main.complex));
	}
	
	//Game update
	public void update()
	{
		
	}
	
	BitmapFont font = new BitmapFont();
	//Draw
	public void draw()
	{
		//Drawing components
		super.draw();
	}
	
}
