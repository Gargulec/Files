package me.Guns.GunPart;

import java.util.ArrayList;

import me.Guns.Game;
import me.Guns.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Barrel extends GunPart{

	//To trigger attach point
	private Vector2 triggerAttach = new Vector2();
	
	//Constructor
	public Barrel(String name, ArrayList<String> desc, int cost, int difficulty, Texture texture)
	{
		super(name, desc, cost, difficulty, texture);
		//Setting id
		setID(Objects.barrels.size());
		//Adding to list
		Objects.barrels.add(this);
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
