package me.Guns;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Factory.Factory;
import me.Guns.Files.Load;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.ComplexScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MainMenu;
import me.Guns.Screen.ProduceScreen;
import me.Guns.Screen.PrototypesListScreen;
import me.Guns.Screen.ResearchScreen;
import me.Guns.Screen.StatsScreen;
import me.Guns.Window.StatsWindow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {

	public static Main main;
	
	/**Game Screens**/
	public static MainMenu menu;
	public static ComplexScreen complex;
	public static CreateScreen create;
	public static ProduceScreen produce;
	public static PrototypesListScreen prototypes;
	public static ResearchScreen research;
	public static StatsScreen stats;
	public static AssignScreen assign;
	/****/
	
	//Fonts
	public static BitmapFont fontSmall, fontMedium, fontBig;
	
	//Creating application
	public void create()
	{
		main = this;
		
		//Fonts
		fontSmall = StudiumLabel.createFontFromTTF(Gdx.files.internal("visitor1.ttf"), 18);
		fontMedium = StudiumLabel.createFontFromTTF(Gdx.files.internal("visitor1.ttf"), 34);
		fontBig = StudiumLabel.createFontFromTTF(Gdx.files.internal("visitor1.ttf"), 50);
		
		//Loading items
		Load.loadStandardItems();
		
		//Screens
		menu = new MainMenu();
		create = new CreateScreen();
		produce = new ProduceScreen();
		prototypes = new PrototypesListScreen();
		research = new ResearchScreen();
		stats = new StatsScreen();
		complex = new ComplexScreen();
		assign = new AssignScreen();
		create.createButtons();
		prototypes.createButtons();
		research.createButtons();
		stats.createButtons();
		complex.createButtons();
		
		/**TESTS ONLY**/
		me.Guns.Game.factories.add(new Factory());
		me.Guns.Game.factories.add(new Factory());
		/****/
		
		//Static windows
		StudiumScreen.addStatic(new StatsWindow(0, Gdx.graphics.getHeight() - 50));
		
		StudiumScreen.change(this, complex);
	}
	
	//Update
	double timer = 0;
	public void render() 
	{
		super.render();
		timer += Gdx.graphics.getDeltaTime();
		if(timer >= 2)
		{
			for(Factory f : me.Guns.Game.factories)
				f.produce();
		
			timer = 0;
		}
	}
	
}
