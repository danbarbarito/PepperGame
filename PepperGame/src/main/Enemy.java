package main;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;
import org.newdawn.slick.*;
public class Enemy {
	//public int spawnrate;
	public Random r;
	public int[] posX, posY;
	public Image[] enemy;
	public int numberOfEnemies;
	public Rectangle[] boundingBox;
	public Enemy()
	{
		r = new Random();
		numberOfEnemies = 5;
		posX = new int[numberOfEnemies];
		posY = new int[numberOfEnemies];
		boundingBox = new Rectangle[numberOfEnemies];
		enemy = new Image[100];
		try {
			for(int x=0;x<numberOfEnemies;x++)
			{
				posX[x] = r.nextInt(640-8);
				posY[x] = 8;
				//change here
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
		for(int x=0;x<numberOfEnemies;x++)
		{
			g.drawImage(enemy[x], posX[x], posY[x]);
		}
	}
	public void fall()
	{
		for(int x=0;x<numberOfEnemies;x++)
		{
			posY[x]+= 1;
		}
	}


}
