package se.codequest.model;
/*
 * Camera class manages the in-game camera, keeping the player center of the screen 
 */
public class Camera 
{
	private float camera_X = 0f;
	private float camera_Y = 0f;
	
	public void update(float newCamX, float newCamY) 
	{
		this.camera_X = newCamX;
		this.camera_Y = newCamY;
	}

	public float getCamera_X() 
	{
		return camera_X;
	}

	public float getCamera_Y() 
	{
		return camera_Y;
	}
}
