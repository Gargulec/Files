package me.Guns.Message;

import java.util.ArrayList;

import me.Guns.Game;
import me.Guns.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.sun.prism.GraphicsPipeline.ShaderType;

public class Message {

	//Topic
	private String topic;
	//Content
	private String[] content;
	//If important
	private boolean isImportant;
	//To destroy
	private boolean destroy;
	
	//Constructor
	public Message(String topic, String[] content, boolean isImportant)
	{
		setTopic(topic);
		setContent(content);
		setImportant(isImportant);
	}
	
	//Drawing
	public void draw(float x, float y, SpriteBatch batch)
	{
		ShapeRenderer sr = new ShapeRenderer();
		
		//Drawing background
		batch.end();
		sr.begin(ShapeType.Filled);
		if(isImportant())
			sr.setColor(new Color(.7f, 0, 0, 1));
		else
			sr.setColor(new Color(.3f, .3f, .3f, 1));
		sr.rect(x, y, 200, 30);
		sr.end();	
		batch.begin();
		//Drawing topic
		Main.fontSmall.draw(batch, getTopic(), x + 10, y + 5);
	}
	
	//Drawing messages of screen
	public static void drawMessages(float x, float y, SpriteBatch batch)
	{
		int offset = 0;
		ArrayList<Message> active = new ArrayList<Message>();
		for(Message m : Game.messages)
		{
			if(!m.isDestroy())
			{
				m.draw(x, y + offset, batch);
				offset += 30;
				active.add(m);
			}
		}
		//Removing messages
		Game.messages.clear();
		Game.messages = active;
	}
	
	//Checking messages
	public static void checkMessages(float x, float y, int button)
	{
		int offset = 0;
		for(Message m : Game.messages)
		{
			if(!m.isDestroy())
			{
				if(Gdx.input.getX() > x && Gdx.input.getX() < x + 200)
				{
					float mY = (Gdx.graphics.getHeight() - Gdx.input.getY());
					if(mY > y + offset && mY < y + offset + 30)
					{
						if(button == 0)
							m.leftClick();
						else
							m.rightClick();
					}
				}
				offset += 30;
			}
		}
	}
	
	//Left click on message
	public void leftClick()
	{
		System.err.println("Message clicked: " + getTopic());
	}
	//Right click on message
	public void rightClick()
	{
		//Removing message from list
		setDestroy(true);
	}
	
	/**Getters & Setters**/
	public String getTopic() 
	{
		return topic;
	}
	public void setTopic(String topic) 
	{
		this.topic = topic;
	}
	
	public String[] getContent() 
	{
		return content;
	}
	public void setContent(String[] content) 
	{
		this.content = content;
	}
	
	public boolean isImportant() 
	{
		return isImportant;
	}
	public void setImportant(boolean isImportant) 
	{
		this.isImportant = isImportant;
	}

	public boolean isDestroy() 
	{
		return destroy;
	}
	public void setDestroy(boolean destroy)
	{
		this.destroy = destroy;
	}
	
}
