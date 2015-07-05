package me.Guns.Prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.Guns.Objects;
import me.Guns.GunPart.Barrel;
import me.Guns.GunPart.Sight;
import me.Guns.GunPart.Stock;
import me.Guns.GunPart.Trigger;

public class Prototype {

	//Name
	private String name = "New";
	//Price
	private int price = 600;
	
	//Stock
	private int stock = -1;
	//Trigger
	private int trigger = 0;
	//Barrel
	private int barrel = 0;
	//Sight
	private int sight = -1;
	//Silencer
	private int silencer = -1;
	
	//Amount
	private int amount;
	
	//Draw gun
	public void draw(SpriteBatch batch, float x, float y)
	{
		//Stock
		if(getStock() != null)
		{
			Texture s = getStock().getTexture();
			batch.draw(s, x + getTrigger().getStockAttach().x - getStock().getTriggerAttach().x, y - getTrigger().getStockAttach().y + getStock().getTriggerAttach().y);
		}
		//Sight
		if(getSight() != null)
		{
			Texture s = getSight().getTexture();
			batch.draw(s, x + getTrigger().getSightAttach().x - getSight().getTriggerAttach().x, y - getTrigger().getSightAttach().y + getSight().getTriggerAttach().y);
		}
		//Trigger
		Texture t = getTrigger().getTexture();
		batch.draw(t, x, y);
		//Barrel
		Texture b = getBarrel().getTexture();
		batch.draw(b, x + getTrigger().getBarrelAttach().x - getBarrel().getTriggerAttach().x, y + t.getHeight() - b.getHeight() + getBarrel().getTriggerAttach().y - getTrigger().getBarrelAttach().y);
	}
	
	Texture stockBg = new Texture(Gdx.files.internal("graphics/stock.png"));
	Texture triggerBg = new Texture(Gdx.files.internal("graphics/trigger.png"));
	Texture barrelBg = new Texture(Gdx.files.internal("graphics/barrel.png"));
	Texture sightBg = new Texture(Gdx.files.internal("graphics/sight.png"));
	Texture error = new Texture(Gdx.files.internal("graphics/error.png"));
	public void drawParts(SpriteBatch batch, float x, float y)
	{
		//Stock
		batch.draw(stockBg, x - triggerBg.getWidth() - 5, y);
		if(getTrigger().isStockAllowed())
		{
			if(this.stock > -1)
				batch.draw(getStock().getTexture(), x - 5 - getStock().getTexture().getWidth(), y);
		}
		else
		{
			this.stock = -1;
			batch.draw(error, x - getTrigger().getTexture().getWidth() + stockBg.getWidth()/2 - error.getWidth(), y + stockBg.getHeight()/2 - error.getHeight()/2);
		}
		//Trigger
		batch.draw(triggerBg, x, y);
		batch.draw(getTrigger().getTexture(), x, y);
		//Barrel
		batch.draw(barrelBg, x + triggerBg.getWidth() + 5, y);
		batch.draw(getBarrel().getTexture(), x +  triggerBg.getWidth() + 5 + barrelBg.getWidth()/2 - getBarrel().getTexture().getWidth()/2, y + barrelBg.getHeight()/2 - getBarrel().getTexture().getHeight()/2);
		//Sight
		batch.draw(sightBg, x, y + triggerBg.getHeight() + 5);
		if(getTrigger().isSightAllowed())
		{
			if(this.sight > -1)
				batch.draw(getSight().getTexture(), x, y + 53);
		}
		else
		{
			this.sight = -1;
			batch.draw(error, x + triggerBg.getWidth()/2 - error.getWidth()/2, y + 77 - error.getHeight()/2);
		}
	}
	
	//Copy
	public Prototype copy()
	{
		Prototype p = new Prototype();
		p.setName(getName());
		p.setBarrel(this.barrel);
		p.setTrigger(this.trigger);
		p.setStock(this.stock);
		p.setSight(this.sight);
		return p;
	}
	
	/**Getters & Setters**/
	public Trigger getTrigger()
	{
		return Objects.triggers.get(this.trigger);
	}
	public void setTrigger(int trigger) 
	{
		this.trigger = trigger;
	}
	
	public Barrel getBarrel() 
	{
		return Objects.barrels.get(this.barrel);
	}
	public void setBarrel(int barrel) 
	{
		this.barrel = barrel;
	}
	
	public Stock getStock()
	{
		if(this.stock == -1 || Objects.stocks.size() == 0)
			return null;
		
		return Objects.stocks.get(this.stock);
	}
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	
	public Sight getSight()
	{
		if(this.sight == -1 || Objects.sights.size() == 0)
			return null;
		
		return Objects.sights.get(this.sight);
	}
	public void setSight(int sight)
	{
		this.sight = sight;
	}

	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public int getCost()
	{
		int cost = getTrigger().getCost() + getBarrel().getCost();
		
		if(getStock() != null)
			cost += getStock().getCost();
		if(getSight() != null)
			cost += getSight().getCost();
		
		return cost;
	} 
	
	public int getDifficulty()
	{
		int difficulty = getTrigger().getDifficulty() + getBarrel().getDifficulty();
		
		if(getStock() != null)
			difficulty += getStock().getDifficulty();
		if(getSight() != null)
			difficulty += getSight().getDifficulty();
		
		return difficulty;
	}

	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
}
