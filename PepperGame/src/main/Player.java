package main;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
public class Player{
	
	public int posX, posY;
	static public Image image;
	public int startingPosX, startingPosY;
	public int speed;
	public Camera camera;
	public boolean isRotating;
	public Player(String fn) throws SlickException{
		image = new Image(fn);
		startingPosX = 400;
		startingPosY = 200;
		posX = startingPosX;
		posY = startingPosY;
		speed = 3;
	}
	
	public void move(Input input)
	{
    	//Movement
    	if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP))
    	{
    		posY -= speed;
    	}
    	if(input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN))
    	{
    		posY += speed;
    	}
    	if(input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT))
    	{
    		posX += speed;
    	}
    	if(input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT))
    	{
    		posX -= speed;
    	}
    	//Boundaries
    	if(posX <= 0)
    	{
    		posX = 0;
    	}
    	if(posX >= 640 - image.getWidth())
    	{
    		posX = 640 - image.getWidth();
    	}
    	if(posY <= 0)
    	{
    		posY = 0;
    	}
    	if(posY >= 480 - image.getHeight())
    	{
    		posY = 480 - image.getHeight();
    	}
    	if(input.isKeyDown(input.KEY_E) || input.isKeyDown(input.KEY_Q))
    	{
    		isRotating = true;
    	}
    	else
    	{
    		isRotating = false;
    	}
	}
	
	public void draw()
	{
		image.draw(posX, posY);
	}
	public void jump()
	{
		//The character does a rotating jump
		//System.out.println("Jump! (The code still has to be written for this)");
	}

}
