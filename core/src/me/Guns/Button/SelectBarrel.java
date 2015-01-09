package me.Guns.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.GUI.Component.StudiumComponent;
import me.Guns.Screen.CreateScreen;

public class SelectBarrel extends GunsButton{

	//Constructor
	public SelectBarrel(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "", parent);
		
		//Width
		setWidth(96);
		//Height
		setHeight(48);
	}
	
	//Draw
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
	
		float y = Gdx.graphics.getHeight() - Gdx.input.getY();
		if((CreateScreen.partView && CreateScreen.selectedPart == 2) || 
				((Gdx.input.getX() > getX() && Gdx.input.getX() < getX() + getWidth()) && ((y > getY() && y < getY() + getHeight()))))
			setBgColor(new Color(1, 1, 1, .3f));
		else
			setBgColor(new Color(1, 1, 1, 0));
	}
	
	//Clicked
	public void leftClick()
	{
		//2 = Barrel
		CreateScreen.selectedPart = 2;
	}

}
