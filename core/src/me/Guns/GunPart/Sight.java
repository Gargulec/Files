package me.Guns.GunPart;

import java.util.ArrayList;

import me.Guns.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Sight extends GunPart{

	//To trigger attach point
	private Vector2 triggerAttach = new Vector2();
	
	//Constructor
	public Sight(String name, ArrayList<String> desc, int cost, int difficulty, Texture texture)
	{
		super(name, desc, cost, difficulty, texture);
		//Setting id
		setID(Game.sights.size());
		//Adding to list
		Game.sights.add(this);
	}

	//Getters & Setters
	public Vector2 getTriggerAttach() 
	{
		return triggerAttach;
	}
	public void setTriggerAttach(Vector2 triggerAttach) 
	{
		this.triggerAttach = triggerAttach;
	}

}
