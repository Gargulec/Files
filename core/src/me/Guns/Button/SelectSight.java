package me.Guns.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.GUI.Component.StudiumComponent;
import me.Guns.Screen.CreateScreen;

public class SelectSight extends GunsButton{

	//Constructor
	public SelectSight(float x, float y, StudiumComponent parent) 
	{
		super(x, y, "", parent);
		
		//Width
		setWidth(48);
		//Height
		setHeight(48);
		
		setBgColor(new Color(0, 1, 1, 1));
	}
	
	//Draw
	public void draw(SpriteBatch batch) 
	{
		super.draw(batch);
	
		float y = Gdx.graphics.getHeight() - Gdx.input.getY();
		if((CreateScreen.partView && CreateScreen.selectedPart == 4) || 
				((Gdx.input.getX() > getX() && Gdx.input.getX() < getX() + getWidth()) && ((y > getY() && y < getY() + getHeight()))))
			setBgColor(new Color(1, 1, 1, .3f));
		else
			setBgColor(new Color(1, 1, 1, 0));
	}
	
	//Clicked
	public void leftClick()
	{
		//4 = Sight
		if(CreateScreen.prototype.getTrigger().isSightAllowed())
			CreateScreen.selectedPart = 4;
	}
	public void rightClick()
	{
		CreateScreen.prototype.setSight(-1);
		CreateScreen.selectedPart = 0;
	}

}
