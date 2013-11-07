package main;
import org.newdawn.slick.geom.Shape;
import main.*;
import java.text.DecimalFormat;
import org.newdawn.slick.*;

import buffs.ABuff;

import states.Gameplay;
public class Logic{

	
	//CHANGE HEALTH TO GPA
	//F's FALL FROM SKY
	//EACH F CAUSES THE LOSS OF .1 GPA
	//Some A's will appear in the middle area and cause your GPA to go up!
	//Tutor zones passively give GPA
	//Extra credit
	
	public double gpa;
	public DecimalFormat df;
	public String gpaString;
	public Text text;
	public ABuff aBuff;
	public long time;
	private Gameplay gp;
	public long timeBuffIsUsed;
	public double buffA_amount;
	public double f_amount;
	public Logic()
	{
		df = new DecimalFormat("0.00");
		gpa = 4.00;
		text = new Text();
		gp = new Gameplay();
		buffA_amount = .64;
		f_amount = .14;
	}
	
	public void logic(Player player, Enemy enemy, ABuff aBuff, long t)
	{
		time = t;
		getGPA(player, enemy);
		getGPA2(player, aBuff);
	}

	public void getGPA(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			gpa -= f_amount;
		}
		
	}
	
	public void getGPA2(Player player, ABuff aBuff)
	{
		if(collidesWithBuff(player, aBuff))
		{
			gpa += buffA_amount;
		}
		
		}
	
	public void displayGPA(Graphics g, Player player, Enemy enemy)
	{
		getGPA(player, enemy);
		if(gpa >= 4)
		{
			gpa = 4;
			text.draw(g, Color.white, "GPA:" + df.format(gpa), 10, 30);
		}
		if(gpa <= 0)
		{
			gpa = 0;
			text.draw(g, Color.red, "FAILURE!", 10, 50);
			
		}
		else
		{
			text.draw(g, Color.white, "GPA:" + df.format(gpa), 10, 30);
		}
	}
	public void displayTime(Graphics g)
	{
		
		text.draw(g, Color.white, "Time:" + time + " seconds", 10, 50);
	}
	
	public boolean collidesWithEnemy(Player player, Enemy enemy)
	{
		//Check if collides

		for(int x=0;x<enemy.numberOfEnemies;x++)
		{
			if(player.boundingBox.intersects(enemy.boundingBox[x]))
			{
				Gameplay.hurtSound.play();
				try {
					enemy.removeEnemy(x);
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return true;
			}
		}

		return false;	
	}


	public boolean collidesWithBuff(Player player, ABuff aBuff)
	{
		if(player.boundingBox.intersects(aBuff.boundingBox))
		{
			return true;
		}
		return false;
	}
			
}

