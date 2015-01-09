package me.Guns.GunPart;

import java.util.ArrayList;

import me.Guns.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Silencer extends GunPart{

	//To trigger attach point
	private Vector2 barrelAttach = new Vector2();
	
	//Constructor
	public Silencer(String name, ArrayList<String> desc, int cost, int difficulty, Texture texture)
	{
		super(name, desc, cost, difficulty, texture);
		//Setting id
		setID(Game.silencers.size());
		//Adding to list
		Game.silencers.add(this);
	}

	//Getters & Setters
	public Vector2 getBarrelAttach() 
	{
		return barrelAttach;
	}
	public void setBarrelAttach(Vector2 barrelAttach) 
	{
		this.barrelAttach = barrelAttach;
	}

}
