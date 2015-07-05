package me.Guns.Window;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import lib.gui.StudiumLabel;
import lib.gui.StudiumWindow;
import me.Guns.Main;
import me.Guns.Button.AddExportAmount;
import me.Guns.Button.CloseFactoryOptions;
import me.Guns.Button.CloseFactoryView;
import me.Guns.Button.ExportAssign;
import me.Guns.Button.HireWorkers;
import me.Guns.Button.ProductionAssign;
import me.Guns.Button.StopProduction;
import me.Guns.Button.SubstractExportAmount;
import me.Guns.Country.Country;
import me.Guns.Factory.Factory;
import me.Guns.TextField.FactoryName;

public class CountryView extends StudiumWindow{

	//Factory
	public static Country country;
	
	//Labels
	public StudiumLabel magazineAmount = new StudiumLabel(150, getHeight() - 240, "", new Color(1, 1, 1, 1), Main.fontSmall);
	public StudiumLabel amount = new StudiumLabel(150, getHeight() - 260, "", new Color(1, 1, 1, 1), Main.fontSmall);
	public StudiumLabel exportAmount = new StudiumLabel(150, getHeight() - 280, "", new Color(1, 1, 1, 1), Main.fontSmall);
	
	//Costructor
	public CountryView(float x, float y)
	{
		super(x, y, 320, 320);
		
		setActive(false);
		setBgColor(new Color(.3f, .3f, .3f, 1));
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
		add(new StudiumLabel(10, getHeight() - 40, country.getName(), new Color(1, 1, 1, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 70, "Population", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 90, country.getPopulation() + "", new Color(1, 1, 1, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 120, "Weapon interest", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 140, (int)(country.getInterest()*100) + "%", new Color(1, 1, 1, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 170, "Requirements", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 190, country.getReqirementsString(), new Color(1, 1, 1, 1), Main.fontSmall));
		add(new StudiumLabel(10, getHeight() - 220, "Exported weapon", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		//Buttons
		add(new CloseFactoryView(getWidth() - 20, getHeight() - 20));
		if(country.getExportedWeapon() == null)
			add(new ExportAssign(10, getHeight() - 245));
		else
		{
			add(new ExportAssign(10, getHeight() - 300));
			add(magazineAmount);
			add(amount);
			add(exportAmount);
			add(new AddExportAmount(170, getHeight() - 305));
			add(new SubstractExportAmount(210, getHeight() - 305));
		}
	}
	
	//Draw
	public void draw(SpriteBatch batch, ShapeRenderer renderer) 
	{
		super.draw(batch, renderer);
	
		if(isActive())
		{
			//Exported weapon
			if(country.getExportedWeapon() != null){
				country.getExportedWeapon().draw(batch, getX() + 10, getY() + getHeight() - 280);
				exportAmount.setText("+" + country.getExportAmount()+"/turn");
				amount.setText("Country: " + country.getAmount());
				magazineAmount.setText("Magazines: " + country.getExportedWeapon().getAmount());
			}
		}
	}
	
	
}