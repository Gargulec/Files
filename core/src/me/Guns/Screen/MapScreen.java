package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.CountryInfo;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Country.Country;
import me.Guns.Window.CountryView;

public class MapScreen extends StudiumScreen{

	//Country view
	public static CountryView countryView;
	
	//Constructor
	public MapScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
		countryView = new CountryView(Gdx.graphics.getWidth()/2 - 160, Gdx.graphics.getHeight()/2 - 160);
	}
	
	//Creating buttons
	public void createButtons()
	{
	}
	
	//Opened
	public void show()
	{
		reload();
	}

	//Reload
	public void reload()
	{
		int offset = 0;
		for(Country c : Game.countries)
		{
			add(new CountryInfo(80, Gdx.graphics.getHeight() - 100 - offset, null, c));
			offset += 30;
		}
		
		add(new GunsButtonGoTo(80, 80, "Back", null, Main.complex));

		add(countryView);
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
