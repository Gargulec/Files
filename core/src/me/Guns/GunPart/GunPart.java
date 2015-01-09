package me.Guns.GunPart;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class GunPart {

	//ID
	private int id;
	//Name
	private String name;
	//Description
	private ArrayList<String> desc = new ArrayList<String>();
	//Cost
	private int cost;
	//Difficulty
	private int difficulty;
	//Texture
	private Texture texture;
	
	//Constructor
	public GunPart(String name, ArrayList<String> desc, int cost, int dfficulty, Texture texture)
	{
		setName(name);
		setDesc(desc);
		setCost(cost);
		setTexture(texture);
		setDifficulty(dfficulty);
	}
	
	/**Getters & Setters**/
	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public ArrayList<String> getDesc() 
	{
		return desc;
	}
	public void setDesc(ArrayList<String> desc) 
	{
		this.desc = desc;
	}
	
	public int getCost() 
	{
		return cost;
	}
	public void setCost(int cost) 
	{
		this.cost = cost;
	}
	
	public Texture getTexture() 
	{
		return texture;
	}
	public void setTexture(Texture texture) 
	{
		this.texture = texture;
	}

	public int getDifficulty()
	{
		return difficulty;
	}
	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}
	
}
