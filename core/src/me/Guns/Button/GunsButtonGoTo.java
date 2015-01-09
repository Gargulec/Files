package me.Guns.Button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.GUI.Component.StudiumButton;
import me.GUI.Component.StudiumButtonGoTo;
import me.GUI.Component.StudiumComponent;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Main;
import me.Guns.Screen.ProduceScreen;

public class GunsButtonGoTo extends StudiumButtonGoTo{

	//Title
	private String title;
	
	//Constructor
	public GunsButtonGoTo(float x, float y, String title, StudiumComponent parent, StudiumScreen purpose)
	{
		super(x, y, font.getBounds(title).width, 30, parent, Main.main, purpose);
		
		setBgColor(new Color(0, 0, 0, 0));
		
		this.title = title;
	}
	
	//Drawing button
	static BitmapFont font = Main.fontSmall;
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
		
		font.setColor(Color.WHITE);
		font.draw(batch, this.title, this.getX(), this.getY() + font.getBounds(title).height/2);
		
	}

	public void clicked(int button) 
	{
		super.clicked(button);
		ProduceScreen.factoryOption.closed();
	}
	
}
