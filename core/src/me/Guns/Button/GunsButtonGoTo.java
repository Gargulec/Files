package me.Guns.Button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import lib.gui.StudiumButtonGoTo;
import lib.gui.StudiumScreen;
import me.Guns.Main;
import me.Guns.Screen.ProduceScreen;

public class GunsButtonGoTo extends StudiumButtonGoTo{
	
	//Title
	private String title;
	
	//Constructor
	public GunsButtonGoTo(float x, float y, String title, StudiumScreen purpose)
	{
		super(x, y, font.getBounds(title).width, 30, Main.main, purpose);
		
		setBgColor(new Color(0, 0, 0, 0));
		
		this.title = title;
	}
	
	//Drawing button
	static BitmapFont font = Main.fontSmall;
	public void draw(SpriteBatch batch, ShapeRenderer renderer) 
	{
		super.draw(batch, renderer);
		
		font.setColor(Color.WHITE);
		font.draw(batch, this.title, this.getX(), this.getY() + font.getBounds(title).height/2);
		
	}

	public void clicked(int button) 
	{
		super.clicked(button);
		ProduceScreen.factoryOption.closed();
	}
	
}
