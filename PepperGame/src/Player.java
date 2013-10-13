import org.newdawn.slick.*;
public class Player {
	
	static public int posX, posY;
	static public Image image;
	public Player(String fn) throws SlickException{
		image = new Image(fn);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void move(Input input)
	{
    	//Movement
    	if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP))
    	{
    		posY -= 10;
    	}
    	if(input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN))
    	{
    		posY += 10;
    	}
    	if(input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT))
    	{
    		posX += 10;
    	}
    	if(input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT))
    	{
    		posX -= 10;
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

}
