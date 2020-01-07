package se.codequest.level;

import com.badlogic.gdx.graphics.Texture;

import se.codequest.model.GameObj;
import se.codequest.model.TileMap;

public class TutorialLvl extends Topography{

	private Texture rockTexture = new Texture("res/ter/rock2.png"); 
	private Texture questRock = new Texture("res/ter/quest_rock.png");
	private Texture treeTexture = new Texture("res/ter/tree1.png");
	private boolean questStatus;
	
	public TutorialLvl(TileMap map, boolean status) {
		super(map);
		this.questStatus = status;
		loadLevel();
	}
	
	public void loadLevel() {
		
		GameObj tree;
		GameObj rock;
		
		for(int i = 0; i < super.getMap().getHeight(); i++) {
			
			if(i == 4)
			{
				if(questStatus == false) 
				{
					rock = new GameObj(super.getMap(), 7, i, questRock, false);
					super.getObjectsList().add(rock);
				}
			}
			else 
			{
				rock = new GameObj(super.getMap(), 7, i, rockTexture, false);
				super.getObjectsList().add(rock);
			}
		}
		
		tree = new GameObj(super.getMap(), 3, 2, treeTexture, false);
		tree = new GameObj(super.getMap(), 1, 9, treeTexture, false);
		tree = new GameObj(super.getMap(), 5, 8, treeTexture, false);
		tree = new GameObj(super.getMap(), 3, 15, treeTexture, false);
		tree = new GameObj(super.getMap(), 1, 17, treeTexture, false);
		tree = new GameObj(super.getMap(), 6, 12, treeTexture, false);
		tree = new GameObj(super.getMap(), 6, 19, treeTexture, false);
		tree = new GameObj(super.getMap(), 10, 10, treeTexture, false);
		tree = new GameObj(super.getMap(), 9, 12, treeTexture, false);
		tree = new GameObj(super.getMap(), 10, 13, treeTexture, false);
		tree = new GameObj(super.getMap(), 16, 16, treeTexture, false);
		tree = new GameObj(super.getMap(), 5, 13, treeTexture, false);
	}
	public void setQuests() {
		//super.getMap().getTile(6, 4).setQuestion()
	}
}
