package se.codequest.level;

import java.util.ArrayList;

import se.codequest.model.GameObj;
import se.codequest.model.TileMap;

public class Topography {

	private TileMap map;
	private ArrayList<GameObj> objectsList = new ArrayList<GameObj>();
	
	public Topography(TileMap map) {
		this.map = map;
	}

	public TileMap getMap() {
		return map;
	}

	public void setMap(TileMap map) {
		this.map = map;
	}

	public ArrayList<GameObj> getObjectsList() {
		return objectsList;
	}
	
}
