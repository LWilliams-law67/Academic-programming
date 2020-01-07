package se.codequest.model.character;

import se.codequest.model.TileMap;
import se.codequest.util.AnimationSet;
import java.util.Random;

import com.badlogic.gdx.math.GridPoint2;

public class CharacterNPC extends Character
{
	

	public CharacterNPC(TileMap map, int x, int y, AnimationSet animations)
	{
		super(map, x, y, animations);
	}
}
