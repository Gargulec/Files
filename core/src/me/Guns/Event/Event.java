package me.Guns.Event;

import java.util.Random;

import me.Guns.Game;
import me.Guns.Objects;

public class Event {

	//Name
	private String name;
	//Description
	private String description;
	
	//Constructor
	public Event(String name, String description)
	{
		setName(name);
		setDescription(description);
	}
	
	//Generating event
	public static void newEvent()
	{
		Random r = new Random();
		
		int event = r.nextInt(Objects.events.size() + 1);
		
		if(event == 0)
			return;
		else
		{
			Objects.events.get(event - 1).generate();
			Objects.events.get(event - 1).act();
		}
	}
	
	//Generating event
	public void generate(){}
	
	//Act
	public void act(){}
	
	/**Getters & Setters**/
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
}
