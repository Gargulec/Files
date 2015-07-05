package me.Guns.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import me.Guns.Screen.CreateScreen;

public class SelectTrigger extends GunsButton{

	//Constructor
	public SelectTrigger(float x, float y) 
	{
		super(x, y, "");
		
		//Width
		setWidth(48);
		//Height
		setHeight(48);
		
		setBgColor(new Color(0, 1, 1, 1));
	}
	
	//Draw
	public void draw(SpriteBatch batch, ShapeRenderer renderer) 
	{
		super.draw(batch, renderer);
	
		float y = Gdx.graphics.getHeight() - Gdx.input.getY();
		if((CreateScreen.partView && CreateScreen.selectedPart == 1) || 
				((Gdx.input.getX() > getX() && Gdx.input.getX() < getX() + getWidth()) && ((y > getY() && y < getY() + getHeight()))))
			setBgColor(new Color(1, 1, 1, .3f));
		else
			setBgColor(new Color(1, 1, 1, 0));
	}
	
	//Clicked
	public void leftClick()
	{
		//1 = Trigger
		CreateScreen.selectedPart = 1;
	}

}
