package se.codequest.model.character;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;

import se.codequest.model.DIRECTION;
import se.codequest.model.TileMap;
import se.codequest.util.AnimationSet;
import se.codequest.util.SaveGamePrefs;

/*
 * Character class stores the players character information such as position on map
 * Movement state for animations
 */
public class Character 
{
	private TileMap map;
	private int x;
	private int y;
	
	private int sourceX, sourceY;
	private int destinationX, destinationY;
	private float worldX, worldY;
	private DIRECTION CharacterFacing;
	
	private float animationTimer;
	private float walkTimer;
	private float ANIMATION_TIME = 0.5f;
	
	private AnimationSet animations;
	private boolean frameMovement;
	private CHARACTER_STATE state;
	
	public Character(TileMap map, int x, int y, AnimationSet animations) 
	{
		this.map = map;
		this.x = x;
		this.y = y;
		this.worldX = x;
		this.worldY = y;
		this.CharacterFacing = DIRECTION.SOUTH;
		this.animations = animations;
		this.state = CHARACTER_STATE.STANDING;
		map.getTile(x, y).setCharacter(this);
	}

	public int getX() 
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public float getWorldX() 
	{
		return worldX;
	}

	public float getWorldY() 
	{
		return worldY;
	}
	
	public void update(float delta) 
	{
		if(state == CHARACTER_STATE.WALKING) 
		{
			animationTimer += delta;
			walkTimer += delta;
			worldX = Interpolation.linear.apply(sourceX, destinationX, animationTimer/ANIMATION_TIME);
			worldY = Interpolation.linear.apply(sourceY, destinationY, animationTimer/ANIMATION_TIME);
			
			if(animationTimer > ANIMATION_TIME)
			{
				float overlapingTime = animationTimer - ANIMATION_TIME;
				walkTimer -= overlapingTime;
				finishMove();
				if(frameMovement)
				{
					moveCharacter(CharacterFacing);
				}else 
				{
					walkTimer = 0f;
				}
			}
		}
		frameMovement = false;
	}
	/*
	 * Moves character in the direction specified by the user from the
	 * controller class @dx and @dy (direction x and direction y)
	 */
	public boolean moveCharacter(DIRECTION direction) 
	{
//		System.out.println("worldX : " + worldX);
//		System.out.println("worldY : " + worldY);
		
		if(state == CHARACTER_STATE.WALKING) 
		{
			if(CharacterFacing == direction) 
			{
				frameMovement = true;
			}
			return false;
		}
		
		if(x + direction.getDX() >= map.getWidth() || x + direction.getDX() < 0 
				|| y + direction.getDY() >= map.getHeight() || y + direction.getDY() < 0) 
		{
			return false;
		}
		
		if(map.getTile(x + direction.getDX(), y + direction.getDY()).getCharacter() != null) 
		{
			return false;
		}
		
		if(map.getTile(x + direction.getDX(), y + direction.getDY()).getGameObj() != null 
				&& map.getTile(x + direction.getDX(), y + direction.getDY()).getGameObj().isWalkable() == false)
		{
			return false;
		}
		
		initializeMove(direction);
		map.getTile(x, y).setCharacter(null);
		x += direction.getDX();
		y += direction.getDY();
		map.getTile(x, y).setCharacter(this);
		
		return true;

	}
	
	/*
	 * exchanges the current coordinates @oldX & @oldY with the new destination 
	 */
	private void initializeMove(DIRECTION direction)
	{
		this.CharacterFacing = direction;
		this.sourceX = x;
		this.sourceY = y;
		this.destinationX = x + direction.getDX();
		this.destinationY = y + direction.getDY();
		this.worldX = x;
		this.worldY = y;
		animationTimer = 0f;
		state = CHARACTER_STATE.WALKING;
	}
	
	private void finishMove() 
	{
		state = CHARACTER_STATE.STANDING;
		this.worldX = destinationX;
		this.worldY = destinationY;
		this.sourceX = 0;
		this.sourceY = 0;
		this.destinationX = 0;
		this.destinationY = 0;
		
		//update position for saving and loading
		SaveGamePrefs.setPlayerX((int) this.worldX);
		SaveGamePrefs.setPlayerY((int) this.worldY);
		SaveGamePrefs.save();
				
	}
	
	public TextureRegion getSprite() 
	{
		if(state == CHARACTER_STATE.WALKING)
		{
			return (TextureRegion) animations.getWalking(CharacterFacing).getKeyFrame(walkTimer);
		}else if(state == CHARACTER_STATE.STANDING) 
		{
			return animations.getStanding(CharacterFacing);
		}
		return animations.getStanding(DIRECTION.SOUTH);	
	}
}
