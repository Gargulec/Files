package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import lib.gui.StudiumScreen;
import me.Guns.Main;
import me.Guns.Button.GunsButtonGoTo;

public class MessageScreen extends StudiumScreen{

	//Constructor
	public MessageScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(80, 80, "Back", Main.map));
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
