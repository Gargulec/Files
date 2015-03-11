package me.Guns.Screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.sun.prism.GraphicsPipeline.ShaderType;

import me.GUI.Component.StudiumLabel;
import me.GUI.Screen.StudiumScreen;
import me.Guns.Game;
import me.Guns.Main;
import me.Guns.Objects;
import me.Guns.Button.GunsButtonGoTo;
import me.Guns.Technology.Technology;

public class ResearchScreen extends StudiumScreen{

	/**Labels**/
	StudiumLabel nameText, descText, costText, reqText;
	StudiumLabel name, desc, cost, requirement;
	
	Texture bg = new Texture(Gdx.files.internal("graphics/background2.png"));
	
	//Constructor
	public ResearchScreen() 
	{
		nameText = new StudiumLabel(560, Gdx.graphics.getHeight() - 75, null, "Name", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(nameText);
		name = new StudiumLabel(560, Gdx.graphics.getHeight() - 95, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(name);
		
		costText = new StudiumLabel(560, Gdx.graphics.getHeight() - 125, null, "Research cost", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(costText);
		cost = new StudiumLabel(560, Gdx.graphics.getHeight() - 145, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(cost);
		
		reqText = new StudiumLabel(560, Gdx.graphics.getHeight() - 175, null, "Requires", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(reqText);
		requirement = new StudiumLabel(560, Gdx.graphics.getHeight() - 195, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(requirement);
		
		descText = new StudiumLabel(560, Gdx.graphics.getHeight() - 225, null, "Description", new Color(.7f, .7f, .7f, 1), Main.fontSmall);
		add(descText);
		desc = new StudiumLabel(560, Gdx.graphics.getHeight() - 245, null, "Test", new Color(1, 1, 1, 1), Main.fontSmall);
		add(desc);
	}
	
	//Game update
	static ArrayList<Technology> onScreen = new ArrayList<Technology>();
	static int techID = -1;
	public void update()
	{
		float x = Gdx.input.getX() + offset.x;
		float y = Gdx.input.getY() + offset.y;
		
		techID = -1;
		
		for(Technology t : onScreen)
		{
			if(x > t.getPosition().x && x < t.getPosition().x + 48)
			{
				if(y > t.getPosition().y - 48 && y < t.getPosition().y)
				{
					techID = t.getID();
				}
			}
		}
		
		//Clearing onScreenTechs array
		onScreen.clear();
		
		//Updating labels
		if(techID > -1)
		{
			Technology t = Technology.search(techID);
			//Name
			name.setText(t.getName());
//			nameText.setActive(true);
			//Cost
			cost.setText(t.getResearchCost() + " pts");
//			costText.setActive(true);
			//Requirement
			requirement.getTextList().clear();
			for(int id : t.getRequiredTechs())
			{
				Technology tt = Technology.search(id);
				if(tt != null)
					requirement.getTextList().add(tt.getName());
			}
			requirement.setActive(true);
//			reqText.setActive(true);
			//Description
			descText.setY(Gdx.graphics.getHeight() - 225 - (20*(requirement.getTextList().size()-1)));
			desc.setTextList(t.getDescription());
			desc.setY(Gdx.graphics.getHeight() - 245 - (20*(requirement.getTextList().size()-1)));
			desc.setActive(true);
		}
		else
		{
			name.setText("");
//			nameText.setActive(false);
			cost.setText("");
//			costText.setActive(false);
			requirement.setActive(false);
//			reqText.setActive(false);
			descText.setY(Gdx.graphics.getHeight() - 225);
			desc.setActive(false);
//			descText.setActive(false);
		}
		
		//Moving camera
		int cameraSpeed = 10;
		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
			cameraSpeed = 30;
		
		if(Gdx.input.isKeyPressed(Keys.D))
			offset.set(offset.x + cameraSpeed, offset.y);
		else if(Gdx.input.isKeyPressed(Keys.A))
			offset.set(offset.x - cameraSpeed, offset.y);
		if(Gdx.input.isKeyPressed(Keys.S))
			offset.set(offset.x, offset.y + cameraSpeed);
		else if(Gdx.input.isKeyPressed(Keys.W) && offset.y >= 10)
			offset.set(offset.x, offset.y - cameraSpeed);
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
		//Drawing background
		batch.draw(bg, 0, 0);
		
		//Drawing lines
		for(Technology t : Objects.technologies)
		{
			if(t.getPosition().x > offset.x - 50 && t.getPosition().x < offset.x + Gdx.graphics.getWidth() + 50)
			{
				if(t.getPosition().y > offset.y - 50 && t.getPosition().y < offset.y + Gdx.graphics.getHeight() + 50)
				{
					//Requirement lines
					batch.end();
					shapeRenderer.begin(ShapeType.Line);
					Gdx.gl.glLineWidth(1);
					shapeRenderer.setColor(.1f, .1f, .1f, 1);
					for(int id : t.getRequiredTechs())
					{
						Technology tt = Technology.search(id);
						if(tt != null)
							shapeRenderer.line(t.getPosition().x - offset.x + 23, Gdx.graphics.getHeight() - t.getPosition().y + offset.y + 23, tt.getPosition().x - offset.x + 23, Gdx.graphics.getHeight() - tt.getPosition().y + offset.y + 23);
					}
					shapeRenderer.end();
					batch.begin();
				}
			}
		}
		//Drawing technologies
		for(Technology t : Objects.technologies)
		{
			if(t.getPosition().x > offset.x - 50 && t.getPosition().x < offset.x + Gdx.graphics.getWidth() + 50)
			{
				if(t.getPosition().y > offset.y - 50 && t.getPosition().y < offset.y + Gdx.graphics.getHeight() + 50)
				{
					//Background
					batch.draw(tech, t.getPosition().x - offset.x, Gdx.graphics.getHeight() - t.getPosition().y + offset.y);
					//Technology image
					batch.draw(t.getImage(), t.getPosition().x - offset.x, Gdx.graphics.getHeight() - t.getPosition().y + offset.y);
					
					onScreen.add(t);
				}
			}
		}
		
		//Drawing values bg
		batch.end();
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(.3f, .3f, .3f, 1);
		shapeRenderer.rect(540, 220, 240, 340);
		shapeRenderer.end();
		batch.begin();
		
		//Drawing components
		super.draw();
	}
	
}
