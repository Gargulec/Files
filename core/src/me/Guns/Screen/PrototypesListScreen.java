package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import lib.gui.StudiumLabel;
import lib.gui.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.DeletePrototype;
import me.Guns.Button.EditPrototype;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Button.NextPart;
import me.Guns.Prototype.Prototype;

public class PrototypesListScreen extends StudiumScreen{

	//Actual prototype
	public static Prototype prototype = new Prototype();
	
	//Constructor
	public PrototypesListScreen()
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
		add(new StudiumLabel(80, Gdx.graphics.getHeight() - 75, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(500, Gdx.graphics.getHeight() - 75, "Amount", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(280, Gdx.graphics.getHeight() - 75, "Look", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		//Buttons
		add(new GunsButtonGoTo(80, 80, "Back", Main.map));
		
		int offset = 0;
		for(Prototype p : Game.prototypes)
		{
			add(new EditPrototype(630, Gdx.graphics.getHeight() - 95 - offset, p));
			add(new DeletePrototype(630, Gdx.graphics.getHeight() - 115 - offset, p));
			offset += 50;
		}
	}
	
	//Game update
	public void update()
	{
	
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
