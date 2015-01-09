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
import me.Guns.Button.ChooseWeapon;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Button.ProductionAssign;
import me.Guns.Button.NextPart;
import me.Guns.Factory.Factory;
import me.Guns.Prototype.Prototype;

public class AssignScreen extends StudiumScreen{

	//Choosen factory
	public static Factory factory;
	
	//Constructor
	public AssignScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
	}
	
	public void show()
	{
		removeAllComponents();
		add(new GunsButtonGoTo(100, 100, "Back", null, Main.produce));
		add(new StudiumLabel(100, Gdx.graphics.getHeight() - 126, null, "Choose gun", Color.WHITE, Main.fontSmall));
		int offset = 0;
		for(Prototype p : Game.prototypes)
		{
			add(new ChooseWeapon(560, Gdx.graphics.getHeight() - 170 - offset, null, p));
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
			//Weapon name & amount
			Main.fontSmall.draw(batch, "Prototype123 x " + p.getAmount(), 100, Gdx.graphics.getHeight() - 160 - offset);
			//Weapon look
			p.draw(batch, 350, Gdx.graphics.getHeight() - 160 - offset);
			offset += 50;
		}
		//Money
		Main.fontSmall.draw(batch, "Money: " + Game.money, 300, Gdx.graphics.getHeight() - 116);
	}
	
}
