package me.Guns;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;

import me.Guns.Country.Country;
import me.Guns.Event.Event;
import me.Guns.Factory.Factory;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Silencer;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;
import me.Guns.Message.Message;
import me.Guns.Prototype.Prototype;
import me.Guns.Technology.Technology;

public class Game {

	//Money
	public static int money = 10000;
	
	//Created guns list
	public static ArrayList<Prototype> prototypes = new ArrayList<Prototype>();
	//List of factories
	public static ArrayList<Factory> factories = new ArrayList<Factory>();
	//List of countries
	public static ArrayList<Country> countries = new ArrayList<Country>();
	//List of events
	public static ArrayList<Event> events = new ArrayList<Event>();
	
	/**Technologies**/
	public static ArrayList<Technology> technologies = new ArrayList<Technology>();
	public static ArrayList<Integer> researched = new ArrayList<Integer>();
	
	/**In-game item lists**/
	//Trigger list
	public static ArrayList<Trigger> triggers = new ArrayList<Trigger>();
	//Barrels list
	public static ArrayList<Barrel> barrels = new ArrayList<Barrel>();
	//Stocks list
	public static ArrayList<Stock> stocks = new ArrayList<Stock>();
	//Sights list
	public static ArrayList<Sight> sights = new ArrayList<Sight>();
	//Silencers list
	public static ArrayList<Silencer> silencers = new ArrayList<Silencer>();
	
	//List of messages
	public static ArrayList<Message> messages = new ArrayList<Message>();
	
	/**Game loop**/
	public float timer;
	Random r = new Random();
	public void gameLoop()
	{
		timer += Gdx.graphics.getDeltaTime();
		
		if(timer >= 2.0)
		{
			//Generating events
			if(r.nextInt(100) <= 30)
				Event.newEvent();
			//Factory production
			for(Factory f : factories)
				f.produce();
			//Selling
			for(Country c : countries)
				c.sell();
			//Updating
			for(Country c : countries)
				c.update();
			
			timer = 0;
		}
	}
	
}
