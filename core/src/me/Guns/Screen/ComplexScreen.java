package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import me.GUI.Component.StudiumLabel;
import me.GUI.Component.StudiumTextField;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.TextField.FactoryName;

public class ComplexScreen extends StudiumScreen{

	//Constructor
	public ComplexScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(100, 300, "Create new gun", null, Main.create));
		add(new GunsButtonGoTo(100, 250, "Produce", null, Main.produce));
		add(new GunsButtonGoTo(100, 200, "Prototypes list", null, Main.prototypes));
		add(new GunsButtonGoTo(100, 150, "Research", null, Main.research));
		add(new GunsButtonGoTo(100, 100, "Stats", null, Main.stats));
	}
	
	//Draw
	public void draw()
	{
		//Drawing components
		super.draw();
	}
	
}
