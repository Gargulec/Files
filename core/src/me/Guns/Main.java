package me.Guns;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Country.Country;
import me.Guns.Event.TerroristAttack;
import me.Guns.Factory.Factory;
import me.Guns.Files.Load;
import me.Guns.Message.Message;
import me.Guns.Screen.AssignScreen;
import me.Guns.Screen.ComplexScreen;
import me.Guns.Screen.CreateScreen;
import me.Guns.Screen.MainMenu;
import me.Guns.Screen.MapScreen;
import me.Guns.Screen.MessageScreen;
import me.Guns.Screen.ProduceScreen;
import me.Guns.Screen.PrototypesListScreen;
import me.Guns.Screen.RatingScreen;
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
	public static me.Guns.Game game;
	
	/**Game Screens**/
	public static MainMenu menu;
	public static ComplexScreen complex;
	public static CreateScreen create;
	public static ProduceScreen produce;
	public static PrototypesListScreen prototypes;
	public static ResearchScreen research;
	public static StatsScreen stats;
	public static AssignScreen assign;
	public static MapScreen map;
	public static MessageScreen message;
	public static RatingScreen rating;
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
		map = new MapScreen();
		message = new MessageScreen();
		rating = new RatingScreen();
		create.createButtons();
		research.createButtons();
		stats.createButtons();
		complex.createButtons();
		map.createButtons();
		message.createButtons();
		rating.createButtons();
		
		game = new me.Guns.Game();
		
		/**TESTS ONLY**/
		me.Guns.Game.factories.add(new Factory());
		me.Guns.Game.factories.add(new Factory());
		
		me.Guns.Game.countries.add(new Country("Poland", 40000000));
		me.Guns.Game.countries.add(new Country("Germany", 3000));
		me.Guns.Game.countries.add(new Country("France", 2400));
		
		me.Guns.Game.events.add(new TerroristAttack());
		
		me.Guns.Game.messages.add(new Message("Attack!", new String[2], false));
		me.Guns.Game.messages.add(new Message("New propositon!", new String[2], true));
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
		
		//Game loop
		game.gameLoop();
	}
	
}
