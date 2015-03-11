package me.Guns;

import java.util.ArrayList;

import me.Guns.Event.Event;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Silencer;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;
import me.Guns.Technology.Technology;

public class Objects {

	//List of events
	public static ArrayList<Event> events = new ArrayList<Event>();
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
	/**Technologies**/
	public static ArrayList<Technology> technologies = new ArrayList<Technology>();
}
