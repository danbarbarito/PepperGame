package states;

import main.*;

import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Gameplay extends BasicGameState{

	static int width = 640;
	static int height = 480;
	static boolean fullscreen = false;
	static boolean showFPS = true;
	static String title = "#1 Game NA";
	static int fpslimit = 60;
	public Player character;
	private int mouseX, mouseY;
	private String osName;
	private Camera camera;
	private Image background;
	public Particles pe;
	public Enemy enemy;
	public Logic logic;
	public Text text;
	public Buffs aBuff;
	public Music mainMusic;
	public static Music hurtSound;
	public static Music buffSound;
	public StopWatch s;
	public DecimalFormat df;
	public boolean buffON; // is the buff on screen or not?
	public int buffDELTA; // time in ms since last buff collision
	public int MAXbuffDELTA; // time between last buff collision and respawn

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		//Load images depending on Operating System
		osName = System.getProperty("os.name");
		//Character
		character = new Player("data/sprite.png");
		//Background
		background = new Image("data/background.jpg", false, Image.FILTER_NEAREST);
		camera = new Camera(character);
		pe = new Particles();
		enemy = new Enemy();
		aBuff = new Buffs();
		logic = new Logic();
		text = new Text();
		mainMusic = new Music("data/theme.ogg");
		hurtSound = new Music("data/hit.ogg");
		buffSound = new Music("data/buff.ogg");
		//mainMusic.loop();
		
		s = new StopWatch();
		df = new DecimalFormat("0.00");
		s.start();
		buffON = false; // buff not on screen
		buffDELTA = 0;
		MAXbuffDELTA = 10000; // 10s = 10,000ms
	}


	public void input(GameContainer gc, Graphics g) throws SlickException
	{
		Input input = gc.getInput();
		mouseX = input.getAbsoluteMouseX();
		mouseY = input.getAbsoluteMouseY();
		character.move(input);
	}

	@Override
	public void mouseWheelMoved(int change)
	{
		if(change>=0)
		{
			camera.changeScale(true);
		}
		if(change<0)
		{
			camera.changeScale(false);
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {

		//Input
		input(container, g);

		//Draw background
		background.draw(0,0,width,height);
		//Move and render particles
		pe.setPositionPlayer(character.posX + character.image.getWidth()/2, character.posY + character.image.getHeight()/2);
		//Set particles on buffs
		if(!buffON){
			pe.setPositionBuff(-100,-100);
		}
		else
		{
			pe.setPositionBuff(aBuff.posX + aBuff.width/2, aBuff.posY + aBuff.height/2);
		}

		//Set Background Particle Position
		pe.setPositionBackground(width/2, -16);
		pe.render();
		//Draw character
		character.draw();
		//Draw Enemies
		enemy.activate(g);
		// draw buff only if it is on screen
		if(buffON){
			aBuff.render(g);
		}

		//Display GPA
		logic.displayGPA(g, character, enemy);
		g.resetTransform();

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		//Logic
		logic.logic(character, enemy, aBuff, s.getElapsedTimeSecs());
		if(!buffON){ // if buff is not on screen
			buffDELTA += delta; // add to time since last collision
			if(buffDELTA >= MAXbuffDELTA){ // check if a new buff is to be spawned
				buffDELTA = 0; // reset time since last buff collision
				aBuff.spawn(); // spawn the buff on screen
				buffON = true; // buff is on screen
			}
		}
		else{ // if buff is on screen
			if(logic.collidesWithBuff(character, aBuff)){ // if player collects buff
				aBuff.removeABuff(); // move the buff off screen
				buffON = false; // buff is now off screen
			}
		}
		
		//Set camera scale
		//camera.scale(g, width, height);

		pe.update(delta);
		if(logic.gpa <= 0)
		{
			container.exit();
			gameEnd();
		}

	}
	public void gameEnd()
	{
		s.stop();
		System.out.println("You lasted " + s.getElapsedTimeSecs() + " seconds.");
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
