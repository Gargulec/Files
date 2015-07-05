package me.Guns;

import me.Guns.Country.Country;
import me.Guns.Event.TerroristAttack;
import me.Guns.Factory.Factory;
import me.Guns.Files.Load;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Trigger;
import me.Guns.Message.Message;
import me.Guns.Screen.*;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import lib.gui.StudiumLabel;
import lib.gui.StudiumScreen;

public class Main extends Game {

	public static Main main;
	public static me.Guns.Game game;
	
	/**Game Screens**/
	public static MainMenu menu;
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
		Trigger rustyTrigger = new Trigger("Rusty Trigger", null, 100, 10, new Texture(Gdx.files.internal("graphics/triggerRusty.png")));
		rustyTrigger.setBarrelAttach(new Vector2(31, 14));
		Barrel rustyBarrel = new Barrel("Rusty Barrel", null, 150, 10, new Texture(Gdx.files.internal("graphics/barrelRusty.png")));
		rustyBarrel.setTriggerAttach(new Vector2(0, 31));
		Load.loadStandardItems();
		//Loading technologies
		Load.loadTechnologies();
		
		//Screens
		menu = new MainMenu();
		create = new CreateScreen();
		produce = new ProduceScreen();
		prototypes = new PrototypesListScreen();
		research = new ResearchScreen();
		stats = new StatsScreen();
		assign = new AssignScreen();
		map = new MapScreen();
		message = new MessageScreen();
		rating = new RatingScreen();
		create.createButtons();
		research.createButtons();
		stats.createButtons();
		map.createButtons();
		message.createButtons();
		rating.createButtons();
		
		game = new me.Guns.Game();
		
		/**TESTS ONLY**/
		me.Guns.Game.factories.add(new Factory());
		me.Guns.Game.factories.add(new Factory());
		
//		me.Guns.Game.countries.add(new Country("Poland", 40000000));
//		me.Guns.Game.countries.add(new Country("Germany", 3000));
//		me.Guns.Game.countries.add(new Country("France", 2400));
		
//		Objects.events.add(new TerroristAttack());
		
		me.Guns.Game.messages.add(new Message("Attack!", new String[2], 0));
		/****/
		
		//Static windows
		StudiumScreen.change(this, map);
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
