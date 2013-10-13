import org.newdawn.slick.*;
public class Player {
	
	static public int posX, posY;
	static public Image image;
	private int startingPosX, startingPosY;
	private int speed;
	public Player(String fn) throws SlickException{
		image = new Image(fn);
		startingPosX = 20;
		startingPosY = 480;
		posX = startingPosX;
		posY = startingPosY;
		speed = 5;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void move(Input input)
	{
    	//Movement
    	if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP))
    	{
    		jump();
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
	}
	public void draw()
	{
		image.draw(posX, posY);
	}
	public void jump()
	{
		//The character does a rotating jump
		System.out.println("Jump! (The code still has to be written for this)");
	}

}
