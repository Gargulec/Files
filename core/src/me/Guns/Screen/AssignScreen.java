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
import me.Guns.Button.ChooseCountry;
import me.Guns.Button.ChooseWeapon;
import me.Guns.Button.DeletePrototype;
import me.Guns.Button.EditPrototype;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Button.ProductionAssign;
import me.Guns.Button.NextPart;
import me.Guns.Country.Country;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;

public class AssignScreen extends StudiumScreen{

	//Choosen factory
	public static Factory factory;
	//Choosen country
	public static Country country;
	
	//Constructor
	public AssignScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
	}
	
	//Opened
	public void show() 
	{
		reload();
	}
	
	//Creating buttons
	public void reload()
	{
		removeAllComponents();
		//Labels
		add(new StudiumLabel(80, Gdx.graphics.getHeight() - 75, null, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(500, Gdx.graphics.getHeight() - 75, null, "Amount", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(280, Gdx.graphics.getHeight() - 75, null, "Look", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		//Buttons
		add(new GunsButtonGoTo(80, 80, "Back", null, Main.complex));
		
		int offset = 0;
		for(Prototype p : Game.prototypes)
		{
			if(factory != null)
				add(new ChooseWeapon(630, Gdx.graphics.getHeight() - 105 - offset, null, p));
			else
				add(new ChooseCountry(630, Gdx.graphics.getHeight() - 105 - offset, null, p));
			offset += 50;
		}
	}
	
	//Draw
	public void draw()
	{
		//Drawing components
		super.draw();
		//Drawing prototypes
		int offset = 0;
		for(Prototype p : Game.prototypes)
		{
			//Weapon name
			Main.fontSmall.draw(batch, p.getName(), 80, Gdx.graphics.getHeight() - 105 - offset);
			//Weapon amount
			Main.fontSmall.draw(batch, "" + p.getAmount(), 500, Gdx.graphics.getHeight() - 105 - offset);
			//Weapon look
			p.draw(batch, 260, Gdx.graphics.getHeight() - 115 - offset - 15);
			offset += 50;
		}
	}
	
}
