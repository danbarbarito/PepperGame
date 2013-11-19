package states;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import main.*;
public class Loss extends BasicGameState{
	public static Text text;
	public Input input;
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		text = new Text();
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		text.draw(g, Color.white, "You lose", 50, 100);
		text.draw(g, Color.white, "You lasted " + Gameplay.s.getElapsedTimeSecs() + " seconds.", 50, 120);
		text.draw(g, Color.white, "1.  Play Again", 50, 160);
		text.draw(g, Color.white, "2.  Quit", 50, 180);
	
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		input = container.getInput();
		if(input.isKeyDown(input.KEY_1) || input.isKeyDown(input.KEY_NUMPAD1) || input.isKeyDown(input.KEY_END))
		{
			Logic.gpa = 4;
			Gameplay.s.reset();
			Gameplay.tutorZoneOn = false;
			Gameplay.ABuffOn = false;
			Gameplay.s.start();
			game.enterState(1);
		}
		if(input.isKeyDown(input.KEY_2) || input.isKeyDown(input.KEY_NUMPAD2) || input.isKeyDown(input.KEY_DOWN))
		{
			container.exit();
		}
		
	
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
