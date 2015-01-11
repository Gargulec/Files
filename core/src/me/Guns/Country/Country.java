package me.Guns.Country;

import com.badlogic.gdx.graphics.Color;

public class Country {

	//Name
	private String name;
	//Color
	private Color color;
	//Map position
	private int mapPosition;
	
	//Population
	private int population;
	//Weapon interest
	private int interest;
	//Weapon minimal grade
	private int minimalGrade;
	//Military power
	private int power;
	
	//Constructor
	public Country(String name, int population)
	{
		setName(name);
		setPopulation(population);
	}
	
	/**Getters**/
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Color getColor() 
	{
		return color;
	}
	public void setColor(Color color) 
	{
		this.color = color;
	}

	public int getMapPosition()
	{
		return mapPosition;
	}
	public void setMapPosition(int mapPosition) 
	{
		this.mapPosition = mapPosition;
	}

	public int getPopulation() 
	{
		return population;
	}
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) 
	{
		this.interest = interest;
	}
	
	public int getMinimalGrade() {
		return minimalGrade;
	}
	public void setMinimalGrade(int minimalGrade)
	{
		this.minimalGrade = minimalGrade;
	}
	
	public int getPower()
	{
		return power;
	}
	public void setPower(int power) 
	{
		this.power = power;
	}
	
}
