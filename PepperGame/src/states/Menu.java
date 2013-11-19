package states;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import main.*;

public class Menu extends BasicGameState{
	public static Text text;
	public static Input input;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		text = new Text();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		text.draw(g, Color.white, "Best Game NA", 50, 10);
		text.draw(g, Color.gray, "1. Play Game", 50, 100);
		text.draw(g, Color.gray, "2. Quit", 50, 120);	
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		input = container.getInput();
		if(input.isKeyDown(input.KEY_1) || input.isKeyDown(input.KEY_NUMPAD1) || input.isKeyDown(input.KEY_END))
		{
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
		return 0;
	}

}
