package main;
import org.newdawn.slick.geom.Shape;

import main.*;

public class Logic {

	public int playerHealth;
	
	public Logic()
	{
		playerHealth = 100;
	}
	
	public void logic(Player player, Enemy enemy)
	{
		loseHealth(player, enemy);
	}

	public void loseHealth(Player player, Enemy enemy)
	{
		if(collidesWithEnemy(player, enemy))
		{
			playerHealth -= 1;
			if(playerHealth < 0)
			{
				playerHealth = 0;
			}
			System.out.println("Health: " + playerHealth);
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
