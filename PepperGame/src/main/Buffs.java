package main;
import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

import org.newdawn.slick.*;

import states.Gameplay;
public class Buffs {
	public Random r;
	public int posX, posY, width, height;
	public Image aBuff;
	public Rectangle boundingBox;
	public Buffs()
	{
		try{
			r = new Random();
			aBuff = new Image("data/aBuff.png");
			width = aBuff.getWidth();
			height = aBuff.getHeight();
			boundingBox = new Rectangle(-100, -100, width, height);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(aBuff, posX, posY);
	}

	public void spawn()
	{
		posX = r.nextInt(640-width);
		posY = r.nextInt(480-height);
		boundingBox.setLocation(posX, posY);
	}

	public void removeABuff()
	{
		posX = -100;
		posY = -100;
		boundingBox.setLocation(posX, posY);
		Gameplay.buffSound.play();
	}
}
