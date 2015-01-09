package me.Guns;

import java.util.ArrayList;

import me.Guns.Factory.Factory;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Silencer;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;
import me.Guns.Prototype.Prototype;

public class Game {

	//Money
	public static int money = 10000;
	
	//Created guns list
	public static ArrayList<Prototype> prototypes = new ArrayList<Prototype>();
	
	//List of factories
	public static ArrayList<Factory> factories = new ArrayList<Factory>();
	
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
	
}
