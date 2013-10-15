import org.newdawn.slick.*;
public class Camera {
	
	public int centerX, centerY;
	public Player player;
	public float scale;
	public float camCenterX;
	public float camCenterY;
	
	public Camera(Player p)
	{
		player = p;
		scale = 2f;
		
	}
	
	public void scale(Graphics g, int screenWidth, int screenHeight)
	{
		camCenterX = screenWidth/scale/2f - player.posX;
		camCenterY = screenHeight/scale/2f - player.posY;
		g.scale(scale, scale);
		g.translate(camCenterX, camCenterY);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
