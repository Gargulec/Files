package me.Guns.Event;

import java.util.ArrayList;
import java.util.Random;

import me.Guns.Game;
import me.Guns.Country.Country;
import me.Guns.Message.Message;

public class TerroristAttack extends Event{

	//Attacked country
	Country attackedCountry;
	
	//Random
	Random r = new Random();

	//Constructor
	public TerroristAttack() 
	{
		super("Terroris attack", "");
	}

	//Generating
	public void generate() 
	{
		//Choosing country
		ArrayList<Country> possibleTargets = new ArrayList<Country>();
		for(Country c : Game.countries)
		{
//			if(c.getPower() > 15)
				possibleTargets.add(c);
		}
		this.attackedCountry = possibleTargets.get(r.nextInt(possibleTargets.size()));
	}
	
	//Action
	public void act() 
	{
		//Num of victims
		int victims = r.nextInt(100);
		getAttackedCountry().setPopulation(getAttackedCountry().getPopulation() - victims);
		//Counting weapon interest
		getAttackedCountry().setInterest(getAttackedCountry().getInterest() + victims/100f);
		if(getAttackedCountry().getInterest() > 1)
			getAttackedCountry().setInterest(1);
		//Counting buying madness
		getAttackedCountry().setBuyingMadness(r.nextInt(40) + 10);
		//Adding message
		Game.messages.add(new Message("Terrorist attack!", new String[1], 2));
	}
	
	/**Getters & Setters**/
	public Country getAttackedCountry()
	{
		return this.attackedCountry;
	}
	
}
