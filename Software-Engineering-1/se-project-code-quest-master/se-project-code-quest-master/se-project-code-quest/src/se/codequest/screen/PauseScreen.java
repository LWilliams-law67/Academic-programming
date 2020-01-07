package se.codequest.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import se.codequest.CodeQuest;

public class PauseScreen implements Screen {
	
	Stage stage;
	Skin skin;
	Dialog dialogBox;
	TextButton resume;
	TextButton main;
	private CodeQuest app;
	Table table;
	Label heading;
	
	public PauseScreen(CodeQuest app, Stage stage) 
	{
		this.app = app;
		this.stage = stage;
		pauseMenu();
	}
		
	private void pauseMenu( ) 
	{
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		heading = new Label("PAUSED", skin);
		heading.setFontScale(2);
		heading.setColor(Color.WHITE);
		heading.setPosition(0, 100);
		
		TextButton resume = new TextButton("RESUME", skin);
		TextButton main = new TextButton("MAIN MENU", skin);
		
		resume.setColor(Color.BLUE);
		main.setColor(Color.RED);
		
		resume.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y)
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(app));
			}
		});
		
		main.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y)
			{
				((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(app));
				stage.clear();
				dispose();
			}
		});
		
		table.add(heading);
		table.row();
		table.add(resume);
		table.row();
		table.add(main);
		stage.addActor(table);

	}
	
	public void show()
	{
		Gdx.input.setInputProcessor(stage);
	}
	
	public void dispose()
	{
		stage.dispose();
	}

	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
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
