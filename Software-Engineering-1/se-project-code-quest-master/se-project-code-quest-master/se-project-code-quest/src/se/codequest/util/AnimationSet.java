package se.codequest.util;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.codequest.model.DIRECTION;
import java.util.*;

public class AnimationSet 
{
	private Map <DIRECTION, Animation> walking;
	private Map <DIRECTION, TextureRegion> standing;

	public AnimationSet(
			Animation walkingNorth, 
			Animation walkingSouth, 
			Animation walkingEast, 
			Animation walkingWest, 
			TextureRegion standingNorth, 
			TextureRegion standingSouth, 
			TextureRegion standingEast, 
			TextureRegion standingWest) 
	{
		super();
		walking = new HashMap <DIRECTION, Animation>();
		walking.put(DIRECTION.NORTH, walkingNorth);
		walking.put(DIRECTION.SOUTH, walkingSouth);
		walking.put(DIRECTION.EAST, walkingEast);
		walking.put(DIRECTION.WEST, walkingWest);
		
		standing = new HashMap <DIRECTION, TextureRegion>();
		standing.put(DIRECTION.NORTH, standingNorth);
		standing.put(DIRECTION.SOUTH, standingSouth);
		standing.put(DIRECTION.EAST, standingEast);
		standing.put(DIRECTION.WEST, standingWest);
	}

	public Animation getWalking(DIRECTION direction) 
	{
		return walking.get(direction);
		
	}
	
	public TextureRegion getStanding(DIRECTION direction)
	{
		return standing.get(direction);
		
	}
}
