package se.codequest.screen;

import com.badlogic.gdx.Screen;

import se.codequest.CodeQuest;

public abstract class AbstractScreen implements Screen 
{
	private CodeQuest app;
	
	public AbstractScreen(CodeQuest app)
	{
		this.app = app;
	}
	
	@Override
	public abstract void dispose();

	@Override
	public abstract void hide();

	@Override
	public abstract void pause();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int arg0, int arg1);

	@Override
	public abstract void resume();
	
	@Override
	public abstract void show();
	
	public CodeQuest getApp()
	{
		return app;
	}	
}
