package se.codequest.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameObj {

	private TileMap map;
	private int x;
	private int y;
	private Texture img;
	private TextureRegion region;
	private boolean walkable;
	
	public GameObj(TileMap map, int x, int y, Texture img, boolean walkable) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.img = img;
		this.walkable = walkable;
		map.getTile(x, y).setGameObj(this);
	}
	
	public GameObj(TileMap map, int x, int y) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.walkable = true;
		map.getTile(x, y).setGameObj(this);
	}

	public boolean isWalkable() {
		return walkable;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public TextureRegion getRegion() {
		region = new TextureRegion();
		region.setTexture(img);
		return region;
	}
	
	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}
	
	public void destruct() {
		this.walkable = true;
		setImg(null);
	}
}
