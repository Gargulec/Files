package me.Guns.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Technology.Technology;

public class ResearchScreen extends StudiumScreen{

	/**Labels**/
	StudiumLabel name, descText, desc, cost, requirement;
	
	//Constructor
	public ResearchScreen() 
	{
		add(new StudiumLabel(580, Gdx.graphics.getHeight() - 75, null, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		name = new StudiumLabel(580, Gdx.graphics.getHeight() - 95, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(name);
		add(new StudiumLabel(580, Gdx.graphics.getHeight() - 125, null, "Research cost", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		cost = new StudiumLabel(580, Gdx.graphics.getHeight() - 145, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(cost);
		add(new StudiumLabel(580, Gdx.graphics.getHeight() - 175, null, "Requires", new Color(.7f, .7f, .7f, 1), Main.fontSmall));
		desc = new StudiumLabel(580, Gdx.graphics.getHeight() - 195, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(desc);
		descText = new StudiumLabel(580, Gdx.graphics.getHeight() - 225, null, "Description", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(descText);
		desc = new StudiumLabel(580, Gdx.graphics.getHeight() - 245, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(desc);
	}
	
	//Game update
	public void update()
	{
		bgImg = new Texture(Gdx.files.internal("graphics/background2.png"));
	}
	
	//Creating buttons
	public void createButtons()
	{
		add(new GunsButtonGoTo(80, 80, "Back", null, Main.complex));
	}
	
	//Draw
	Texture tech = new Texture(Gdx.files.internal("graphics/tech.png"));
	static Vector2 offset = new Vector2();
	public void draw()
	{
		//Drawing components
		super.draw();
		
		//Drawing technologies
		for(Technology t : Game.technologies)
		{
			if(t.getPosition().x > offset.x - 50 && t.getPosition().x < offset.x + Gdx.graphics.getWidth() + 50)
			{
				if(t.getPosition().y > offset.y - 50 && t.getPosition().y < offset.y + Gdx.graphics.getHeight() + 50)
				{
					System.err.println("Drawing technology(" + t.getID() + ")!");
					//Background
					batch.draw(tech, t.getPosition().x, Gdx.graphics.getHeight() - t.getPosition().y);
					//Technology image
					batch.draw(t.getImage(), t.getPosition().x, Gdx.graphics.getHeight() - t.getPosition().y);
				}
			}
		}
	}
	
}
