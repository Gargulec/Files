package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import lib.gui.StudiumComponent;
import lib.gui.StudiumScreen;

import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.CountryInfo;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Country.Country;
import me.Guns.Window.CountryView;

public class MapScreen extends StudiumScreen{

	//Country view
	public static CountryView countryView;
	
	//Map image
	Texture bg, map;
	
	//Constructor
	public MapScreen()
	{		
		bg = new Texture(Gdx.files.internal("graphics/background2.png"));
		map = new Texture(Gdx.files.internal("graphics/map.png"));
		map.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		countryView = new CountryView(Gdx.graphics.getWidth()/2 - 160, Gdx.graphics.getHeight()/2 - 160);
	}
	
	//Creating buttons
	public void createButtons()
	{
		StudiumComponent b = new StudiumComponent(0, 8, Gdx.graphics.getWidth(), 32);
		b.setBgColor(new Color(.1f, .1f, .1f, .38f));
		add(b);
		add(new GunsButtonGoTo(30, 10, "Create new gun", Main.create));
		add(new GunsButtonGoTo(230, 10, "Produce", Main.produce));
		add(new GunsButtonGoTo(350, 10, "Prototypes list", Main.prototypes));
		add(new GunsButtonGoTo(560, 10, "Research", Main.research));
		add(new GunsButtonGoTo(710, 10, "Stats", Main.stats));
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
			add(new CountryInfo(80, Gdx.graphics.getHeight() - 100 - offset, c));
			offset += 30;
		}
		
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
		//Drawing background
		batch.draw(bg, 0, 0, 1920, 1080);
		//Drawing map screen
		batch.draw(map, 0, 0);
		//Drawing components
		super.draw();
	}
	
}
