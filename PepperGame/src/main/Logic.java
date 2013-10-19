package main;
import org.newdawn.slick.geom.Shape;

import main.*;

public class Logic {

	public int points;
	
	public Logic()
	{
		points = 0;
	}
	
	public void logic(Player player, Enemy enemy)
	{
		scorePoint(player, enemy);
	}

	public void scorePoint(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			points += 1;
			System.out.println("Points: " + points);
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
