package se.codequest.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import se.codequest.model.DIRECTION;
import se.codequest.model.character.Character;
public class CharacterController extends InputAdapter
{
	private Character character;
	
	private boolean left, right, up, down;

	public CharacterController(Character character) 
	{
		this.character = character;
	}
	
	
	@Override
	public boolean keyDown(int keyPressed) 
	{
		if (keyPressed == Keys.UP) 
		{
			up = true;
		}
		
		if (keyPressed == Keys.DOWN) 
		{
			down = true;
		}
		
		if (keyPressed == Keys.LEFT) 
		{
			left = true;
		}
		
		if (keyPressed == Keys.RIGHT) 
		{
			right = true;
		}
		
		return false;
	}
	
	@Override
	public boolean keyUp(int keyReleased)
	{
		if(keyReleased == Keys.UP) 
		{
			up = false;
		}
		
		if(keyReleased == Keys.DOWN) 
		{
			down = false;
		}
		
		if(keyReleased == Keys.LEFT) 
		{
			left = false;
		}
		
		if(keyReleased == Keys.RIGHT) 
		{
			right = false;
		}
		
		return false;
	}
	
	public void update(float delta, boolean isPaused)
	{
		if(!isPaused)	{
			if(up) 
			{
				character.moveCharacter(DIRECTION.NORTH);
				return;
			}
			
			if(down) 
			{
				character.moveCharacter(DIRECTION.SOUTH);
				return;
			}
			
			if(left) 
			{
				character.moveCharacter(DIRECTION.WEST);
				return;
			}
			
			if(right) 
			{
				character.moveCharacter(DIRECTION.EAST);
				return;
			}
		}
			
	}
}
