package main;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Enemy {
	//public int spawnrate;
	public Random r;
	public int[] posX, posY;
	public Image[] enemy;
	public int numberOfEnemies;
	public Shape[] boundingBox;
	public Enemy()
	{
		r = new Random();
		numberOfEnemies = 5;
		posX = new int[numberOfEnemies+1];
		posY = new int[numberOfEnemies+1];
		boundingBox = new Shape[numberOfEnemies+1];
		enemy = new Image[numberOfEnemies+1];
		try {
			for(int x=1;x<=numberOfEnemies;x++)
			{
				posX[x] = r.nextInt(640-8);
				posY[x] = r.nextInt(480-8);
				boundingBox[x] = new Rectangle(posX[x], posY[x], 16, 16);
				enemy[x] = new Image("data/enemy.png");
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void spawn(Graphics g)
	{
		for(int x=1;x<=numberOfEnemies;x++)
		{
			g.drawImage(enemy[x], posX[x], posY[x]);
		}
	}
	
	public boolean collides(Shape shape)
	{
		//Check if collides
		return false;
	}
}
