package me.DarkMine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import me.Guns.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1366;
		config.height = 768;
		config.title = "Guns! Prototype";
		config.resizable = false;
		config.fullscreen = true;
		new LwjglApplication(new Main(), config);
	}
}
