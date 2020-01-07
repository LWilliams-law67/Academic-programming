package se.codequest.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public final class SaveGamePrefs {
	public static int playerX = 0;
	public static int playerY = 0;
	
	private static Preferences prefs;
	private static FileHandle handle = Gdx.files.local("bin/codequest.json");
	private static SaveData data = new SaveData(playerX, playerY);
	
	public final static void setPlayerX(int x) 
	{
		playerX = x;
		data.setX(x);
	}
	
	public final static void setPlayerY(int y) 
	{
		playerY = y;
		data.setY(y);
	}
	
	public final static void save() 
	{
		prefs = Gdx.app.getPreferences("Save Preferences");
		prefs.putInteger("playerX", playerX);
		prefs.putInteger("playerY", playerY);
		prefs.flush();
		saveFile();
	}
	
	public final static void saveFile()
	{
		Json json = new Json();
		json.setOutputType(OutputType.json);
		handle.writeString(json.prettyPrint(data), false);
	}

	public final static void loadFile()
	{
		boolean exists = Gdx.files.local("bin/codequest.json").exists();
		if(exists)
		{
			Json json = new Json();
			data = json.fromJson(SaveData.class, handle);
			playerX = data.getX();
			playerY = data.getY();
		}
		else 
		{
			System.out.println("file not found.");
			playerX = 0;
			playerY = 0;
		}
	}
}
