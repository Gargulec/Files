package me.Guns.Files;

import java.util.ArrayList;

import me.Guns.Game;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Load {

	//Loading items
	public static void loadStandardItems()
	{
		FileHandle[] files = Gdx.files.local("items").list();
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
				Trigger t = new Trigger(name, null, cost, difficulty, new Texture(Gdx.files.local("items/" + f.nameWithoutExtension() + ".png")));
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
				Barrel b = new Barrel(name, null, cost, difficulty, new Texture(Gdx.files.local("items/" + f.nameWithoutExtension() + ".png")));
				b.setTriggerAttach(triggerAttach);
			}
			else if(type.equalsIgnoreCase("stock"))
			{
				String t = value("triggerAttach", f).replaceAll("\\s", "");
				Vector2 triggerAttach = new Vector2(Integer.parseInt(t.split(",")[0]), Integer.parseInt(t.split(",")[1]));
				Stock s = new Stock(name, null, cost, difficulty, new Texture(Gdx.files.local("items/" + f.nameWithoutExtension() + ".png")));
				s.setTriggerAttach(triggerAttach);
			}
			else if(type.equalsIgnoreCase("sight"))
			{
				String t = value("triggerAttach", f).replaceAll("\\s", "");
				Vector2 triggerAttach = new Vector2(Integer.parseInt(t.split(",")[0]), Integer.parseInt(t.split(",")[1]));
				Sight s = new Sight(name, null, cost, difficulty, new Texture(Gdx.files.local("items/" + f.nameWithoutExtension() + ".png")));
				s.setTriggerAttach(triggerAttach);
			}
			
			System.out.println("Added new " + type + " - \"" + name + "\"!");
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
	
}
