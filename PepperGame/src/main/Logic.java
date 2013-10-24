package main;
import org.newdawn.slick.geom.Shape;
import main.*;
import java.text.DecimalFormat;;

public class Logic {

	
	//CHANGE HEALTH TO GPA
	//F's FALL FROM SKY
	//EACH F CAUSES THE LOSS OF .1 GPA
	//Some A's will appear in the middle area and cause your GPA to go up!
	public double gpa;
	public DecimalFormat df;
	public String gpaString;
	public Logic()
	{
		df = new DecimalFormat("0.0");
		gpa = 4.0;
	}
	
	public void logic(Player player, Enemy enemy)
	{
		getGPA(player, enemy);
	}

	public String getGPA(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			gpa -= .1;
			if(gpa < 0)
			{
				gpa = 0;
			}
			//System.out.println("GPA: " + df.format(gpa));
			return df.format(gpa);
		}
		return df.format(gpa);
		
	}
	
	public boolean collidesWithEnemy(Player player, Enemy enemy)
	{
		//Check if collides

		for(int x=0;x<enemy.numberOfEnemies;x++)
		{
			if(player.boundingBox.intersects(enemy.boundingBox[x]))
			{
				return true;
			}
		}

		return false;	
	}
	
}
