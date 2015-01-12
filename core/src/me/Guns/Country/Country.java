package me.Guns.Country;

import me.Guns.Prototype.Prototype;

import com.badlogic.gdx.Game;
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
	private float interest = 0.5f;
	//Weapon requirements
	private int requirements;
	//Military power
	private int power;
	
	//Exported weapon
	private Prototype exportedWeapon;
	private int amount;
	private int exportAmount;
	
	//Constructor
	public Country(String name, int population)
	{
		setName(name);
		setPopulation(population);
	}
	
	//Selling guns
	public void sell()
	{
		if(getExportedWeapon() != null)
		{
			//Exporting guns
			if(getExportedWeapon().getAmount() > exportAmount)
			{
				setAmount(getAmount() + getExportAmount());
				getExportedWeapon().setAmount(getExportedWeapon().getAmount() - getExportAmount());
			}
			else
			{
				setAmount(getAmount() + getExportedWeapon().getAmount());
				getExportedWeapon().setAmount(0);
			}
			
			/**Selling guns**/
			double selledGuns = 0;
			if(getExportAmount() > 0)
			{
				if(getExportedWeapon().getAmount() >= getExportAmount())
					selledGuns = Math.floor(getExportAmount() * getInterest());
			}
			else if(getAmount() > 0)
			{
				selledGuns = Math.floor(getAmount() * getInterest());
				if(getAmount() == 1)
					selledGuns = 1;
			}	
			
			//Calculating profit
			int profit = (int)selledGuns * getExportedWeapon().getPrice();
			me.Guns.Game.money += profit;
			//Substracting gun amount
			setAmount((int)(getAmount() - selledGuns));
		}
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
	
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) 
	{
		this.interest = interest;
	}
	
	public int getReqirements()
	{
		return requirements;
	}
	public String getReqirementsString()
	{
		switch(getReqirements())
		{
			case 0:
				return "We are buyin' every weapon!";
			case 1:
				return "Don't even try to sell us some crap!";
			case 2:
				return "Only usable weapons, please!";
			case 3:
				return "We are accepting only the best guns.";
			case 4:
				return "Perfect, modern weapon is what we need.";
			default:
				return "";
		}
	}
	public void setReqirements(int requirements)
	{
		this.requirements = requirements;
	}
	
	public int getPower()
	{
		return power;
	}
	public void setPower(int power) 
	{
		this.power = power;
	}
	
	public Prototype getExportedWeapon() 
	{
		return exportedWeapon;
	}
	public void setExportedWeapon(Prototype exportedWeapon) 
	{
		this.exportedWeapon = exportedWeapon;
	}

	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public int getExportAmount()
	{
		return exportAmount;
	}
	public void setExportAmount(int exportAmount)
	{
		this.exportAmount = exportAmount;
	}
	
}
