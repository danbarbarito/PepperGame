package main;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
public class Player{
	
	public int posX, posY;
	public Image image;
	public int startingPosX, startingPosY;
	public int speed;
	public Camera camera;
	public boolean isRotating;
	public Rectangle boundingBox;
	public Player(String fn) throws SlickException{
		image = new Image(fn);
		startingPosX = 400;
		startingPosY = 200;
		posX = startingPosX;
		posY = startingPosY;
		speed = 3;
		boundingBox = new Rectangle(posX, posY, 32, 32);
	}
	
	public void move(Input input)
	{
    	//Movement
    	if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
    	{
    		posY -= speed;
    	}
    	if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
    	{
    		posY += speed;
    	}
    	if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
    	{
    		posX += speed;
    	}
    	if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
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
	}
	
	public void draw()
	{
		boundingBox = new Rectangle(posX, posY, 32, 32);
		image.draw(posX, posY);
	}
	public void jump()
	{
		//The character does a rotating jump
		//System.out.println("Jump! (The code still has to be written for this)");
	}

}
