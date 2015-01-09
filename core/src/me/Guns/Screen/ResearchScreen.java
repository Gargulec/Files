package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Main;
import me.Guns.Button.GunsButtonGoTo;

public class ResearchScreen extends StudiumScreen{

	//Game update
	public void update()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
		//Labels
		add(new StudiumLabel(100, Gdx.graphics.getHeight() - 126, null, "Research new technologies", Color.WHITE, Main.fontSmall));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(100, 100, "Back", null, Main.complex));
	}
	
	//Draw
	public void draw()
	{
		//Drawing components
		super.draw();
	}
	
}
