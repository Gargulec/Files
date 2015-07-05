package me.Guns.Window;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import lib.gui.StudiumLabel;
import lib.gui.StudiumTextField;
import lib.gui.StudiumWindow;
import me.Guns.Main;
import me.Guns.Button.CloseFactoryOptions;
import me.Guns.Button.HireWorkers;
import me.Guns.Button.ProductionAssign;
import me.Guns.Button.StopProduction;
import me.Guns.Factory.Factory;
import me.Guns.TextField.FactoryName;

public class FactoryOption extends StudiumWindow{

	//Factory
	public static Factory factory;
	
	//Labels
	StudiumLabel workers;
	//TextFields
	StudiumTextField factoryName = new FactoryName(10, getHeight() - 55);
	
	//Costructor
	public FactoryOption(float x, float y)
	{
		super(x, y, 300, 240);
		
		setBgColor(new Color(0.3f, .3f, .3f, 1));
	}
	
	//Opened
	public void opened() 
	{
		reload();
	}
	
	//Reload
	public void reload()
	{
		getChildren().clear();
		
		//Labels
		add(new StudiumLabel(10, getHeight() - 20, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 85, "Production", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(150, getHeight() - 85, "Producing", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 155, "Hire", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 230, "Destroy", new Color(.9f, 0, 0, 1), Main.fontSmall));
		workers = new StudiumLabel(0, getHeight() - 155, "", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(workers);
		//Text fields
		factoryName.setText(factory.getName());
		add(factoryName);
		//Buttons
		add(new ProductionAssign(10, getHeight() - 110));
		StopProduction sp = new StopProduction(10, getHeight() - 130);
		sp.check();
		add(sp);
		add(new CloseFactoryOptions(getWidth() - 20, getHeight() - 20));
		add(new HireWorkers(10, getHeight() - 180, "+1 Worker", 1));
		add(new HireWorkers(150, getHeight() - 180, "+10 Workers", 10));
		add(new HireWorkers(10, getHeight() - 200, "+5 Workers", 5));
		add(new HireWorkers(150, getHeight() - 200, "+50 Workers", 50));
	}
	
	//Draw
	public void draw(SpriteBatch batch, ShapeRenderer renderer) 
	{
		super.draw(batch, renderer);
		
		if(isActive())
		{
			//Workers amount
			workers.setText(factory.getWorkers() + " Workers");
			workers.setX(getWidth() - 20 - Main.fontSmall.getBounds(workers.getText()).width);
			//Product image
			if(factory.getProduction() != null)
				factory.getProduction().draw(batch, getX() + 155, getHeight() + getY() - 140);
		}
	}
	
	
}