package me.Guns.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.GUI.Component.StudiumButton;
import me.GUI.Component.StudiumComponent;
import me.Guns.Main;
import me.Guns.Screen.CreateScreen;

public class GunsButton extends StudiumButton{

	//Title
	private String title;
	//If text centered
	private boolean textCentred;
	
	//Constructor
	public GunsButton(float x, float y, String title, StudiumComponent parent)
	{
		super(x, y, font.getBounds(title).width, font.getBounds(title).height + 10, parent);
		
		setBgColor(new Color(.8f, .8f, 0, 0));
		
		this.title = title;
	}
	
	//Drawing button
	static BitmapFont font = Main.fontSmall;
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
		
		font.setColor(Color.WHITE);
		if(isTextCentred())
			font.draw(batch, this.title, this.getX() + getWidth()/2 - font.getBounds(title).width/2, this.getY() -  font.getBounds(title).height/2 + 5);
		else
			font.draw(batch, this.title, this.getX(), this.getY() -  font.getBounds(title).height/2 + 5);
	}
	public void draw(SpriteBatch batch, Color textColor) 
	{
		font.setColor(textColor);
		draw(batch);
	}

	/**Getters & Setters**/
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public boolean isTextCentred() 
	{
		return textCentred;
	}
	public void setTextCentred(boolean textCentred)
	{
		this.textCentred = textCentred;
	}
	
}
