package me.Guns.Factory;

import com.badlogic.gdx.Gdx;

import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.FactoryInfo;
import me.Guns.Button.ProductionAssign;
import me.Guns.Prototype.Prototype;

public class Factory {

	//Factory name
	private String name = "1234567890123456";
	//Factory level
	private int level;
	//Num of workers
	private int workers = 100;
	//Produced prototype
	private Prototype production;
	//Stopped
	private boolean stopped = false;
	
	//Producing weapon
	int progress;
	public void produce()
	{
		if(production != null && !stopped)
		{
			if(Game.money >= this.production.getCost())
			{
				progress += workers;
				
				if(progress >= production.getDifficulty())
				{
					int numOfProducted = progress/production.getDifficulty();
					progress = progress%production.getDifficulty();
					this.production.setAmount(this.production.getAmount() + numOfProducted);
					Game.money -= this.production.getCost();
					System.out.println("Produced!");
				}
			}
		}
	}
	
	//Adding workers
	public void addWorkers(int amount)
	{
		setWorkers(getWorkers() + amount); 
	}
	
	//Building new factory
	public static void buildNewFactory()
	{
		Factory f = new Factory();
		Game.factories.add(f);
	}
	
	/**Getters & Setters**/
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}

	public int getWorkers() 
	{
		return workers;
	}
	public void setWorkers(int workers)
	{
		this.workers = workers;
	}

	public Prototype getProduction() 
	{
		return production;
	}
	public void setProduction(Prototype production) 
	{
		this.production = production;
	}

	public boolean isStopped() 
	{
		return stopped;
	}
	public void setStopped(boolean stopped)
	{
		this.stopped = stopped;
	}

	public String status()
	{
		if(isStopped())
			return "Stopped";
		else if(getProduction() == null)
			return "Waiting for orders";
		else
			return "Producing";
	}
}
