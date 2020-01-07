package se.codequest.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import se.codequest.CodeQuest;
import se.codequest.Settings;
import se.codequest.controller.CharacterController;
import se.codequest.level.TutorialLvl;
import se.codequest.model.Camera;
import se.codequest.model.character.Character;
import se.codequest.model.character.CharacterNPC;
import se.codequest.model.GameObj;
import se.codequest.model.TERRAIN;
import se.codequest.model.TileMap;
import se.codequest.util.AnimationSet;
import se.codequest.util.SaveGamePrefs;

public class GameScreen implements Screen
{
	private Character character;
	private CharacterNPC npcOponent;
	private Texture characterImg; 
	private Texture grass1;
	private Texture grass2;
	private SpriteBatch batch;
	private CharacterController controller;
	private TileMap tileMap;
	private Camera camera;
	private CodeQuest app;
	private DialogBox box;
	private StorylineScreen dialog;
	private Stage stage;
	private TutorialLvl level;
	boolean isPaused = false;
//	private FileHandle gameFile;
	
	Character character2;
	Texture characterImg2;
	
	public GameScreen(CodeQuest app)
	{
		this.app = app;
		characterImg = new Texture("res/unpacked/character_standing_south.png");
		characterImg2 = new Texture("res/images/wizard.png");
		grass1 = new Texture("res/grass.png");
		grass2 = new Texture("res/grass2.png");
		batch = new SpriteBatch();
		
		TextureAtlas atlas = app.getAssetManager().get("res/packed/textures.atlas", TextureAtlas.class);
		AnimationSet animations  = new AnimationSet(
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_north"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_south"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_east"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_west"), PlayMode.LOOP_PINGPONG),
				atlas.findRegion("character_standing_north"),
				atlas.findRegion("character_standing_south"),
				atlas.findRegion("character_standing_east"),
				atlas.findRegion("character_standing_west")
				); 
        
		AnimationSet animationsNPC  = new AnimationSet(
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_north"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_south"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_east"), PlayMode.LOOP_PINGPONG),
				new Animation(0.4f / 2f, atlas.findRegions("character_walking_west"), PlayMode.LOOP_PINGPONG),
				atlas.findRegion("character_standing_north"),
				atlas.findRegion("character_standing_south"),
				atlas.findRegion("character_standing_east"),
				atlas.findRegion("character_standing_west")
				); 
		
		
		tileMap = new TileMap(20, 20);
		character = new Character(tileMap, 0, 0, animations);
		character2 = new Character(tileMap, 10, 12, animations);
		level = new TutorialLvl(tileMap, box.question1Correct);
    
		// creates player with playerX, playerY position where default is 0 for starting new game.
		character = new Character(tileMap, SaveGamePrefs.playerX, SaveGamePrefs.playerY, animations);
		npcOponent = new CharacterNPC(tileMap, 0 , 3 , animationsNPC);
		controller = new CharacterController(character);
		camera = new Camera();
		stage = new Stage( new ScreenViewport());
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void render(float delta)
	{
		controller.update(delta, isPaused);
		character.update(delta);
		npcOponent.update(delta);
		character2.update(delta);

		camera.update(character.getWorldX() + 0.5f, character.getWorldY() + 0.5f);
		
		batch.begin();
		
		float worldStartX = Gdx.graphics.getWidth() / 2 - (camera.getCamera_X() * Settings.SCALED_TILE_SIZE);
		float worldStartY = Gdx.graphics.getHeight() / 2 - (camera.getCamera_Y() * Settings.SCALED_TILE_SIZE);
		
		for(int x = 0; x < tileMap.getWidth(); x++) 
		{
			for(int y = 0; y < tileMap.getHeight(); y++ )
			{
				Texture render;
				if(tileMap.getTile(x, y).getTerrain() == TERRAIN.GRASS_1)
				{
					render = grass1;
				}else {
					render = grass2;
				}
				batch.draw(render, 
						worldStartX + x * Settings.SCALED_TILE_SIZE, 
						worldStartY + y * Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE);
			}
		}
		
		for(int x = 0; x < tileMap.getWidth(); x++) 
		{
			for(int y = 0; y < tileMap.getHeight(); y++ )
			{
				if(tileMap.getTile(x, y).getGameObj() != null)
				{
				
					batch.draw(tileMap.getTile(x, y).getGameObj().getImg(), 
						worldStartX + x * Settings.SCALED_TILE_SIZE, 
						worldStartY + y * Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE * 1.5f);
				}
			}
		}
		
		batch.draw(character.getSprite(), 
				worldStartX + character.getWorldX() * Settings.SCALED_TILE_SIZE,
				worldStartY + character.getWorldY() * Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE * 1.5f);
		batch.draw(npcOponent.getSprite(), 
				worldStartX + npcOponent.getWorldX() * Settings.SCALED_TILE_SIZE,
				worldStartY + npcOponent.getWorldY() * Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE * 1.5f);
		batch.draw(characterImg2, 
				worldStartX + character2.getWorldX() * Settings.SCALED_TILE_SIZE,
				worldStartY + character2.getWorldY() * Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE,
				Settings.SCALED_TILE_SIZE * 1.5f);
		
		// First interaction with the user and the character
		if((SaveGamePrefs.playerX == 0) && (SaveGamePrefs.playerY == 1) && box.interaction1Status == false)
		{
			((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 6));
		}

		// Question 1 
		if((SaveGamePrefs.playerX == 6) && (SaveGamePrefs.playerY == 4) && box.question1Correct == false)
		{
			((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 1));
			if(box.question1Correct)	
			{
				tileMap.getTile(7, 4).getGameObj().destruct();
				((Game)Gdx.app.getApplicationListener()).setScreen(new StorylineScreen(app, 4));
			}
		}
		
		// 2nd interaction with the user and the wizard
		if((SaveGamePrefs.playerX == 11) && (SaveGamePrefs.playerY == 12) && box.interaction2Status == false)
		{
			((Game)Gdx.app.getApplicationListener()).setScreen(new DialogBox(app, stage, 7));
		}
		
		// 2nd interaction with the user and the wizard
		if((SaveGamePrefs.playerX == 8) && (SaveGamePrefs.playerY == 4) && dialog.dialog1Status == false)
		{
			((Game)Gdx.app.getApplicationListener()).setScreen(new StorylineScreen(app, 4));
		}

		
		batch.end();
    
		// Call the pause screen if the escape button is pressed
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE))
		{
					
			if (isPaused == false)
			{
				isPaused = true;
				((Game)Gdx.app.getApplicationListener()).setScreen(new PauseScreen(app, stage));
			}

			else
				isPaused = false;
		}
		//System.out.println(SaveGamePrefs.playerX);
		//System.out.println(SaveGamePrefs.playerY);
				
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void show() 
	{
		Gdx.input.setInputProcessor(controller);
	}
}