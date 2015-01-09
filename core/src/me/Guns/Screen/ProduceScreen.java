package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import me.GUI.Component.StudiumComponent;
import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.BuildNewFactory;
import me.Guns.Button.FactoryInfo;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Button.ProductionAssign;
import me.Guns.Button.NextPart;
import me.Guns.Button.StopProduction;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;
import me.Guns.Window.FactoryOption;

public class ProduceScreen extends StudiumScreen{

	//Actual prototype
	public static Prototype prototype = new Prototype();
	
	//Fabric options
	public static FactoryOption factoryOption;
	
	//Constructor
	public ProduceScreen()
	{
		background = new Texture(Gdx.files.internal("graphics/background2.png"));
		factoryOption = new FactoryOption(Gdx.graphics.getWidth()/2 - 150, Gdx.graphics.getHeight()/2 - 100);
		factoryOption.setActive(false);
	}
	
	public void show()
	{
		reload();
	}
	
	//Reloading components
	public void reload()
	{
		removeAllComponents();
		//Labels
		add(new StudiumLabel(80, Gdx.graphics.getHeight() - 75, null, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(300, Gdx.graphics.getHeight() - 75, null, "Workers", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(430, Gdx.graphics.getHeight() - 75, null, "Status", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		//Buttons
		add(new GunsButtonGoTo(80, 80, "Back", null, Main.complex));
		add(new BuildNewFactory(80, 120, null));
		int offset = 0;
		for(Factory f : Game.factories)
		{
			add(new FactoryInfo(665, Gdx.graphics.getHeight() - 105 - offset, null, f));
			offset += 30;
		}
		//Factory options
		add(factoryOption);
	}
	 
	//Game update
	public void update()
	{
	
	}
	
	//Draw
	Texture background;
	public void draw()
	{
		//Drawing background
		batch.draw(background, 0, 0);
		//List of factories
		int offset = 0;
		for(Factory f : Game.factories)
		{
			//Name
			Main.fontSmall.draw(batch, f.getName(), 80, Gdx.graphics.getHeight() - 105 - offset);
			//Num of workers
			Main.fontSmall.draw(batch, f.getWorkers() + "", 300, Gdx.graphics.getHeight() - 105 - offset);
			//Status
			Main.fontSmall.draw(batch, f.status(), 430, Gdx.graphics.getHeight() - 105 - offset);
			offset += 30;
		}
		//Drawing components
		super.draw();
	}
	
}
