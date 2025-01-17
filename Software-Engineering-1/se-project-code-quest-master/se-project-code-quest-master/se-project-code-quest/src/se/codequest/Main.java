package se.codequest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main 
{

	public static void main(String[] args) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Code Quest";
		config.height = 400;
		config.width = 600;
		config.vSyncEnabled = true;
		
		new LwjglApplication(new CodeQuest(), config);
	}
}
