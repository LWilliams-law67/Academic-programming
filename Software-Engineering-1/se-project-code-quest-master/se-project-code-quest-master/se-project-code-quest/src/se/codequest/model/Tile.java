package se.codequest.model;

import se.codequest.model.character.Character;

import se.codequest.screen.DialogBox;


public class Tile
{
	private TERRAIN terrain;
	private Character character;
	private GameObj object;
	private DialogBox question;
	
	public Character getCharacter() 
	{
		return character;
	}

	public void setCharacter(Character character) 
	{
		this.character = character;
	}
	
	public void setGameObj(GameObj object)
	{
		this.object = object;
	}
	
	public GameObj getGameObj()
	{
		return object;
	}
	
	public void clearTile() {
		//this.object = new GameObj();
	}

	public Tile(TERRAIN terrain) 
	{
		this.terrain = terrain;
	}

	public TERRAIN getTerrain() 
	{
		return terrain;
	}

	public DialogBox getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = new DialogBox(null, null, question);
	}
}
