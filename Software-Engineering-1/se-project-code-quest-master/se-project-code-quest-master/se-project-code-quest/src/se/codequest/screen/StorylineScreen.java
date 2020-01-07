package se.codequest.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import se.codequest.CodeQuest;

public class StorylineScreen implements Screen{
	
	String userText;
	Stage stage;
	Skin skin;
	TextButton next;
	TextButton skip;
	Table table;
	Label heading;
	Label story;
	Image mazePreview;
	int storylineNum;
	private CodeQuest app;
	public static boolean dialog1Status;

	
	Texture backgroundTexture;
	
	public StorylineScreen(CodeQuest app, int storylineNum) 
	{
		this.app = app;
		stage = new Stage();
		this.storylineNum = storylineNum;
		dialog1Status = false;
		newStoryline();
	}
	
	public void newStoryline()
	{
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		table = new Table(skin);
		

		if(storylineNum == 1)
		{
			table.setBounds(0, 100, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			heading = new Label("Welcome Adventurer!", skin);
			Label dialog1 = new Label("Your coding skills are needed to help defeat the menacing monster SegFaulto!", skin);
			Label dialog2 = new Label("SegFaulto has been terrorizing the land by stealing the villagers' memory.", skin);
			Label dialog3 = new Label("Do you think you have what it takes to code your way to victory?", skin);
			Label dialog4 = new Label("Yes? Well then c'mon there's no time to waste!", skin);

			heading.setFontScale(2);
			heading.setColor(Color.GREEN);
			heading.setPosition(0, 100);
			
			table.add(heading);
			table.row();
			table.row();

			table.add(dialog1);
			table.row();
			table.add(dialog2);
			table.row();
			table.add(dialog3);
			table.row();
			table.add(dialog4);
			table.row();
			
			next = new TextButton("next", skin);
			skip = new TextButton("skip", skin);
			
			next.setColor(Color.BLUE);
			skip.setColor(Color.RED);
			
			next.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					((Game)Gdx.app.getApplicationListener()).setScreen(new StorylineScreen(app, 2));
				}
			});
			
			
			skip.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
				}
			});
		}
		else if(storylineNum == 2)
		{
			table.setBounds(0, 40, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			heading = new Label("Level 1: Exploration", skin);
			Label dialog1 = new Label("\nBefore you defeat SegFaulto, there are many obstacles you'll have to face.\n"
					+ "There will be things blocking your path to SegFaulto, but fear not...\n"
					+ "your coding knowledge will help you prevail!!!!!!\n", skin);

			heading.setFontScale(2);
			heading.setColor(Color.ORANGE);
			heading.setPosition(0, 100);
			
			table.add(heading);
			table.row();
			table.row();

			table.add(dialog1);
			table.row();
			
			next = new TextButton("next", skin);
			skip = new TextButton("skip", skin);
			
			next.setColor(Color.BLUE);
			skip.setColor(Color.RED);
			
			next.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					((Game)Gdx.app.getApplicationListener()).setScreen(new StorylineScreen(app, 3));
				}
			});
			
			
			skip.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
				}
			});
		}
		
		else if(storylineNum == 3)
		{
			table.setBounds(0, 80, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			heading = new Label("Level 1: Exploration", skin);
			Label dialog1 = new Label("\nThis level is all about exploration.\n "
					+ "Explore around and get special hints from the villagers.\n "
					+ "Use the directional arrows to move your character around the map\n"
					+ "and use your knowledge of Java to move to the next area.\n "
					+ "And remember...\n"
					+ "\"This is a software powered world\"\n"
					+ "~ Satya Nadella", skin);

			heading.setFontScale(2);
			heading.setColor(Color.ORANGE);
			heading.setPosition(0, 100);
			
			table.add(heading);
			table.row();
			table.row();

			table.add(dialog1);
			table.row();
			
			next = new TextButton("play", skin);
			
			next.setColor(Color.BLUE);
			
			next.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
				}
			});
		}
		
		else if(storylineNum == 4)
		{
			table.setBounds(0, 40, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			heading = new Label("Great job traveler!", skin);
			Label dialog1 = new Label("\nYou're moving in the right direction but be careful.\n "
					+ " The great wizard ArrayListio rules this area\n ...and he's not so friendly", skin);
			

			heading.setFontScale(2);
			heading.setColor(Color.ORANGE);
			heading.setPosition(0, 100);
			
			table.add(heading);
			table.row();
			table.row();

			table.add(dialog1);
			table.row();
			
			next = new TextButton("play", skin);
			
			next.setColor(Color.BLUE);
			
			next.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y)
				{
					dialog1Status = true;
					((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
				}
			});
		}
		
		table.add(next);
		table.row();
		table.add(skip);
		table.row();
		stage.addActor(table);
	}
	
	

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();	
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
