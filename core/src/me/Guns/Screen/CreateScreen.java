package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import lib.gui.StudiumLabel;
import lib.gui.StudiumScreen;
import me.Guns.Main;
import me.Guns.Button.AddPrototype;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Button.NextPart;
import me.Guns.Button.PreviousPart;
import me.Guns.Button.SelectBarrel;
import me.Guns.Button.SelectSight;
import me.Guns.Button.SelectStock;
import me.Guns.Button.SelectTrigger;
import me.Guns.Prototype.Prototype;
import me.Guns.TextField.PrototypeName;

public class CreateScreen extends StudiumScreen{

	//Actual prototype
	public static Prototype prototype = new Prototype();
	
	//Selected part
	public static int selectedPart;
	
	//Cost
	StudiumLabel partName;
	StudiumLabel partCost;
	
	StudiumLabel totalCost;
	StudiumLabel totalDifficulty;
	
	//Constructor
	public CreateScreen()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
		//Labels
//		add(new StudiumLabel(100, Gdx.graphics.getHeight() - 126, null, "Create new gun", Color.WHITE, Main.fontSmall));
		add(new StudiumLabel(80, Gdx.graphics.getHeight() - 75, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(80, Gdx.graphics.getHeight() - 140, "Price", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		//Part statistic label
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 75, "Part name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		partName = new StudiumLabel(350, Gdx.graphics.getHeight() - 95, "Test", Color.WHITE, Main.fontSmall); 
		add(partName);
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 125, "Damage", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 175, "Accuracy", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 225, "Speed", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 275, "Weight", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 325, "Cost", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		partCost = new StudiumLabel(350, Gdx.graphics.getHeight() - 34, "", Color.WHITE, Main.fontSmall);
		add(partCost);
		
		add(new StudiumLabel(350, Gdx.graphics.getHeight() - 375, "Description", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		//*****************Gun statistic label********************************//
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 75, "Damage", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 125, "Accuracy", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 175, "Speed", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 225, "Weight", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
//		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 275, null, "Volume", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 275, "Gun cost", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		totalCost = new StudiumLabel(550, Gdx.graphics.getHeight() - 295, "", Color.WHITE, Main.fontSmall);
		add(totalCost);
		add(new StudiumLabel(550, Gdx.graphics.getHeight() - 325, "Prod. difficulty", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		totalDifficulty = new StudiumLabel(550, Gdx.graphics.getHeight() - 345, "", Color.WHITE, Main.fontSmall);
		add(totalDifficulty);
		//Text field
		add(new PrototypeName(80, Gdx.graphics.getHeight() - 110));
		add(new PrototypeName(80, Gdx.graphics.getHeight() - 175));
		
		add(new StudiumLabel(90, 240, "Change part", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(80, 80, "Back", Main.map));
//		add(new ChangeTrigger(100, 150, null));
//		add(new ChangeBarrel(220, 150, null));
		add(new AddPrototype(640, 80));
		
		//Parts buttons
		add(new SelectTrigger(140, 280));
		add(new SelectBarrel(193, 280));
		add(new SelectStock(87, 280));
		add(new SelectSight(140, 333));
		
		add(new NextPart(150, 215));
		add(new PreviousPart(90, 215));
	}
	
	//Game update
	public void update()
	{
		//Total cost
		totalCost.setText(prototype.getCost() + "$");
		//Total difficulty
		totalDifficulty.setText(prototype.getDifficulty() + "");
		/**Gun parts**/
		partName.setText("");
		partCost.setText("");
		//Trigger
		if(selectedPart == 1)
		{
			partName.setText(prototype.getTrigger().getName());
			partCost.setText(prototype.getTrigger().getCost() + "$");
		}
		//Barrel
		else if(selectedPart == 2)
		{
			partName.setText(prototype.getBarrel().getName());
			partCost.setText(prototype.getBarrel().getCost() + "$");
		}
		//Stock
		else if(selectedPart == 3)
		{
			if(prototype.getStock() != null)
			{
				partName.setText(prototype.getStock().getName());
				partCost.setText(prototype.getStock().getCost() + "$");
			}
		}
		//Sight
		else if(selectedPart == 4)
		{
			if(prototype.getSight() != null)
			{
				partName.setText(prototype.getSight().getName());
				partCost.setText(prototype.getSight().getCost() + "$");
			}
		}
	}
	
	//Draw
	public static boolean partView = false;
	public void draw()
	{
		partView = false;
		if((Gdx.input.getX() > 60 && Gdx.input.getX() < 320) && (((Gdx.graphics.getHeight() - Gdx.input.getY()) > 180 && (Gdx.graphics.getHeight() - Gdx.input.getY()) < 420)))
		{
			partView = true;
		}
		//Drawing components
		super.draw();
		//Drawing prototype
		if(partView)
			prototype.drawParts(batch, 140, 280);
		else
			prototype.draw(batch, 140, 300);
	}
	
}
