package me.Guns.GunPart;

import java.util.ArrayList;

import me.Guns.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Trigger extends GunPart{

	//Barrel position
	private Vector2 barrelAttach = new Vector2();
	//Stock position
	private boolean stockAllowed = true;
	private Vector2 stockAttach = new Vector2();
	//Sight position
	private boolean sightAllowed = true;
	private Vector2 sightAttach = new Vector2();
	
	//Constructor
	public Trigger(String name, ArrayList<String> desc, int cost, int difficulty, Texture texture)
	{
		super(name, desc, cost, difficulty, texture);
		//Setting id
		setID(Game.triggers.size());
		//Adding to list
		Game.triggers.add(this);
	}

	/**Getters & Setters**/
	public Vector2 getBarrelAttach() 
	{
		return barrelAttach;
	}
	public void setBarrelAttach(Vector2 barrelAttach) 
	{
		this.barrelAttach = barrelAttach;
	}

	public Vector2 getStockAttach() 
	{
		return stockAttach;
	}
	public void setStockAttach(Vector2 stockAttach) 
	{
		this.stockAttach = stockAttach;
	}

	public Vector2 getSightAttach() 
	{
		return sightAttach;
	}
	public void setSightAttach(Vector2 sightAttach) 
	{
		this.sightAttach = sightAttach;
	}

	public boolean isStockAllowed()
	{
		return stockAllowed;
	}
	public void setStockAllowed(boolean stockAllowed) 
	{
		this.stockAllowed = stockAllowed;
	}

	public boolean isSightAllowed() 
	{
		return sightAllowed;
	}
	public void setSightAllowed(boolean sightAllowed) 
	{
		this.sightAllowed = sightAllowed;
	}

}
