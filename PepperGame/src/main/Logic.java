package main;
import org.newdawn.slick.geom.Shape;
import main.*;
import java.text.DecimalFormat;
import org.newdawn.slick.*;

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
	public Buffs aBuff;
	public long time;
	private Gameplay gp;
	public long timeBuffIsUsed;
	public Logic()
	{
		df = new DecimalFormat("0.00");
		gpa = 4.00;
		text = new Text();
		gp = new Gameplay();
	}
	
	public void logic(Player player, Enemy enemy, Buffs aBuff, long t)
	{
		time = t;
		getGPA(player, enemy);
		getGPA2(player, aBuff);
	}

	public void getGPA(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			gpa -= .14;
		}
		
	}
	
	public void getGPA2(Player player, Buffs aBuff)
	{
		if(collidesWithBuff(player, aBuff))
		{
			gpa += 1;
		}
		
		}
	
	public void displayGPA(Graphics g, Player player, Enemy enemy)
	{
		getGPA(player, enemy);
		if(gpa >= 4)
		{
			gpa = 4;
			text.draw(g, "GPA: " + df.format(gpa), 10, 50);
		}
		if(gpa <= 0)
		{
			gpa = 0;
			text.draw(g, "FAILURE!", 10, 50);
			
		}
		else
		{
			text.draw(g, "GPA: " + df.format(gpa), 10, 50);
		}
	}
	
	public boolean collidesWithEnemy(Player player, Enemy enemy)
	{
		//Check if collides

		for(int x=0;x<enemy.numberOfEnemies;x++)
		{
			if(player.boundingBox.intersects(enemy.boundingBox[x]))
			{
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


	public boolean collidesWithBuff(Player player, Buffs aBuff)
	{
		if(player.boundingBox.intersects(aBuff.boundingBox))
		{
			aBuff.removeABuff();
			return true;
		}
		return false;
	}
			
}

