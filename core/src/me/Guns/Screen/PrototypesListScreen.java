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
		//Labels
		add(new StudiumLabel(100, Gdx.graphics.getHeight() - 126, null, "List of your guns", Color.WHITE, Main.fontSmall));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(100, 100, "Back to Complex Screen", null, Main.complex));
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
	}
	
}
