package main;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;
import org.newdawn.slick.*;
public class Buffs {
	public Random r;
	public int[] posX, posY;
	public Image[] aBuff;
	public Rectangle[] boundingBox;
	public Buffs()
	{
		r = new Random();

		posX = new int[1];
		posY = new int[1];
		boundingBox = new Rectangle[1];
		aBuff = new Image[100];
		try {
			for(int x=0;x<1;x++)
			{
				posX[x] = r.nextInt(640-8);
				posY[x] = r.nextInt(480-8);
				boundingBox[x] = new Rectangle(posX[x], posY[x], 32, 32);
				aBuff[x] = new Image("data/aBuff.png");
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void spawn(Graphics g)
	{
		for(int x=0;x<1;x++)
		{
			g.drawImage(aBuff[x], posX[x], posY[x]);
		}
	}
	
	
	
	public void activate(Graphics g)
	{
		spawn(g);
		
	}

	public void removeABuff(int x) throws SlickException
	{
		boundingBox[x].setLocation(-100, -100);
		aBuff[x].setAlpha(0);
	}


}
