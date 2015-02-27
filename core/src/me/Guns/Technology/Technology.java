package me.Guns.Technology;

import java.util.ArrayList;

import me.Guns.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Technology {

	//ID
	private int id;
	//Position
	private Vector2 position = Vector2.Zero;
	//Name
	private String name;
	//Description
	private ArrayList<String> description = new ArrayList<String>();
	/**Research points needed to research this tech**/
	private int researchCost;
	//Required techs
	private ArrayList<Integer> requiredTechs = new ArrayList<Integer>();
	//Image
	private Texture image;
	
	//Constructor
	public Technology(int id, String name, Vector2 position, ArrayList<String> description, int researchCost, ArrayList<Integer> requiredTechs, Texture image)
	{
//		id = Game.technologies.size();
		this.id = id;
		this.name = name;
		this.position = position;
		this.description = description;
		this.researchCost = researchCost;
		this.requiredTechs = requiredTechs;
		this.image = image;
		
		Game.technologies.add(this);
	}
	
	/**Searching for technology with id**/
	public static Technology search(int id)
	{
		for(Technology t: Game.technologies)
		{
			if(t.getID() == id)
				return t;
		}
		
		return null;
	}
	
	//Buy technology
	public void buy()
	{
		Game.researched.add(getID());
	}
	
	/**Getters & Setters**/
	public int getID()
	{
		return id;
	}
	
	public Vector2 getPosition()
	{
		return position;
	}
	public void setPosition(Vector2 position) 
	{
		this.position = position;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public ArrayList<String> getDescription() 
	{
		return description;
	}
	public void setDescription(ArrayList<String> description)
	{
		this.description = description;
	}
	
	public int getResearchCost()
	{
		return researchCost;
	}
	public void setResearchCost(int researchCost)
	{
		this.researchCost = researchCost;
	}
	
	public Texture getImage()
	{
		return image;
	}
	public void setImage(Texture image)
	{
		this.image = image;
	}

	public ArrayList<Integer> getRequiredTechs()
	{
		return requiredTechs;
	}
	public void setRequiredTechs(ArrayList<Integer> requiredTechs) 
	{
		this.requiredTechs = requiredTechs;
	}
	
}
