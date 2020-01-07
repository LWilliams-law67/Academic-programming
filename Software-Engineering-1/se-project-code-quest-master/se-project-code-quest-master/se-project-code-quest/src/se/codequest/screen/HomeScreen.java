package se.codequest.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import se.codequest.*;
import se.codequest.util.SaveGamePrefs; 

public class HomeScreen implements Screen{
	Stage stage;
	Skin skin;
	Table table;
	Label heading;
	private CodeQuest app;
	
	public HomeScreen(CodeQuest app) 
	{
		this.app = app;
	}
	
	public void show()
	{
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		heading = new Label("CODE QUEST", skin);
		heading.setFontScale(2);
		heading.setColor(Color.WHITE);
		heading.setPosition(0, 100);
		
		TextButton play = new TextButton("START", skin);
		TextButton load = new TextButton("LOAD", skin);
		TextButton exit = new TextButton("EXIT", skin);
		
		play.setColor(Color.BLUE);
		load.setColor(Color.GREEN);
		exit.setColor(Color.RED);
		
		play.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y)
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new StorylineScreen(app, 1));
				table.clear();
				dispose();
			}
		});
		
		load.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y)
			{
				SaveGamePrefs.loadFile();
				((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
				table.clear();
				dispose();
			}
		});
		
		exit.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y)
			{
				Gdx.app.exit();
			}
		});
		
		
		table.add(heading);
		table.row();
		table.add(play);
		table.row();
		table.add(load);
		table.row();
		table.add(exit);
		stage.addActor(table);
	}
	
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	public void dispose()
	{
		stage.dispose();
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

}
