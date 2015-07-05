package me.Guns.Button;

import me.Guns.Prototype.Prototype;

public class EditPrototype extends GunsButton{

	//Prototype
	Prototype prototype;
	
	//Constructor
	public EditPrototype(float x, float y, Prototype prototype) 
	{
		super(x, y, "Edit");
		this.prototype = prototype;
	}
	
	//Clicked
	public void leftClick()
	{
	}

}
