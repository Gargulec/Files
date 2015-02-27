package me.Guns.Files;

import java.util.ArrayList;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import me.Guns.Game;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;
import me.Guns.Technology.Technology;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Load {

	//Loading items
	public static void loadStandardItems()
	{
		FileHandle[] files = Gdx.files.local("res/items").list();
		ArrayList<FileHandle> items = new ArrayList<FileHandle>();
		
		for(FileHandle f : files)
		{
			if(f.extension().equalsIgnoreCase("itm"))
			{
				items.add(f);
			}
		}
		
		for(FileHandle f : items)
		{
			String type = value("type", f);
			String name = value("name", f);
			String desc = value("desc", f);
			int cost = Integer.parseInt(value("cost", f));
			int difficulty = Integer.parseInt(value("difficulty", f));
			
			if(type.equalsIgnoreCase("trigger"))
			{
				Trigger t = new Trigger(name, null, cost, difficulty, new Texture(Gdx.files.local("res/items/" + f.nameWithoutExtension() + ".png")));
				//Barrel attach
				String b = value("barrelAttach", f).replaceAll("\\s", "");
				Vector2 barrelAttach = new Vector2(Integer.parseInt(b.split(",")[0]), Integer.parseInt(b.split(",")[1]));
				t.setBarrelAttach(barrelAttach);
				//Stock attach
				if(value("stockAllowed", f).contains("true"))
				{
					String s = value("stockAttach", f).replaceAll("\\s", "");
					Vector2 stockAttach = new Vector2(Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1]));
					t.setStockAttach(stockAttach);
				}
				else
					t.setStockAllowed(false);
				//Sight attach
				if(value("sightAllowed", f).contains("true"))
				{
					String s = value("sightAttach", f).replaceAll("\\s", "");
					Vector2 sightAttach = new Vector2(Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1]));
					t.setSightAttach(sightAttach);
				}
				else
					t.setSightAllowed(false);
			}
			else if(type.equalsIgnoreCase("barrel"))
			{
				String t = value("triggerAttach", f).replaceAll("\\s", "");
				Vector2 triggerAttach = new Vector2(Integer.parseInt(t.split(",")[0]), Integer.parseInt(t.split(",")[1]));
				Barrel b = new Barrel(name, null, cost, difficulty, new Texture(Gdx.files.local("res/items/" + f.nameWithoutExtension() + ".png")));
				b.setTriggerAttach(triggerAttach);
			}
			else if(type.equalsIgnoreCase("stock"))
			{
				String t = value("triggerAttach", f).replaceAll("\\s", "");
				Vector2 triggerAttach = new Vector2(Integer.parseInt(t.split(",")[0]), Integer.parseInt(t.split(",")[1]));
				Stock s = new Stock(name, null, cost, difficulty, new Texture(Gdx.files.local("res/items/" + f.nameWithoutExtension() + ".png")));
				s.setTriggerAttach(triggerAttach);
			}
			else if(type.equalsIgnoreCase("sight"))
			{
				String t = value("triggerAttach", f).replaceAll("\\s", "");
				Vector2 triggerAttach = new Vector2(Integer.parseInt(t.split(",")[0]), Integer.parseInt(t.split(",")[1]));
				Sight s = new Sight(name, null, cost, difficulty, new Texture(Gdx.files.local("res/items/" + f.nameWithoutExtension() + ".png")));
				s.setTriggerAttach(triggerAttach);
			}
			
			System.out.println("Added new " + type + " - \"" + name + "\"!");
		}
	}
	
	//Loading technologies
	public static void loadTechnologies()
	{
		FileHandle[] files = Gdx.files.local("res/technologies").list();
		ArrayList<FileHandle> items = new ArrayList<FileHandle>();
		
		for(FileHandle f : files)
		{
			if(f.extension().equalsIgnoreCase("tch"))
			{
				items.add(f);
			}
		}
		
		for(FileHandle f : items)
		{
			int id = valueInt("id", f);
			//Checking if exists
			if(Technology.search(id) == null)
			{
				//Name
				String name = value("name", f);
				//Position
				int x = Integer.parseInt(value("position", f).split(",")[0].trim());
				int y = Integer.parseInt(value("position", f).split(",")[1].trim());
				Vector2 position = new Vector2(x, y);
				//Description
				ArrayList<String> desc = new ArrayList<String>();
				for(String s : value("desc", f).split("/n/"))
					desc.add(s);
				//Cost
				int cost = valueInt("cost", f);
				//Required techs
				ArrayList<Integer> required = new ArrayList<Integer>();
				if(!value("required", f).equals(""))
				{
					for(String s : value("required", f).split(","))
						required.add(Integer.parseInt(s.trim()));
				}
				
				new Technology(id, name, position, desc, cost, required, new Texture(Gdx.files.local("res/technologies/" + f.nameWithoutExtension() + ".png")));
				
				System.out.println("Added new technolgy - \"" + name + "\"!");
			}
			else
				System.err.println("There is already technology with that id!");
		}
	}
	
	//Load value
	public static String value(String valueName, FileHandle file)
	{
		String[] lines = file.readString().split("\n");
		
		for(String s : lines)
		{
			if(s.contains(valueName + ":"))
			{
				return s.split(":")[1].replaceAll("\\r\\n|\\r|\\n", " ").trim();
			}
		}
		
		return "";
	}
	public static int valueInt(String valueName, FileHandle file)
	{
		String[] lines = file.readString().split("\n");
		
		for(String s : lines)
		{
			if(s.contains(valueName + ":"))
			{
				return Integer.parseInt(s.split(":")[1].replaceAll("\\r\\n|\\r|\\n", " ").trim());
			}
		}
		
		return 0;
	}
	
}
