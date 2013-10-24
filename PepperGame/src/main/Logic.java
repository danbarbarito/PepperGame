package main;
import org.newdawn.slick.geom.Shape;
import main.*;
import java.text.DecimalFormat;
import org.newdawn.slick.*;
public class Logic {

	
	//CHANGE HEALTH TO GPA
	//F's FALL FROM SKY
	//EACH F CAUSES THE LOSS OF .1 GPA
	//Some A's will appear in the middle area and cause your GPA to go up!
	public double gpa;
	public DecimalFormat df;
	public String gpaString;
	public Text text;
	public Logic()
	{
		df = new DecimalFormat("0.00");
		gpa = 4.00;
		text = new Text();
	}
	
	public void logic(Player player, Enemy enemy)
	{
		getGPA(player, enemy);
	}

	public void getGPA(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			gpa -= .03;
		}
		
		
	}
	public void displayGPA(Graphics g, Player player, Enemy enemy)
	{
		getGPA(player, enemy);
		if(gpa <= 0)
		{
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
				return true;
			}
		}

		return false;	
	}
	
}
