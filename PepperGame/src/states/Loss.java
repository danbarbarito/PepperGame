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
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		text = new Text();
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		text.draw(g, Color.white, "You lose", 50, 100);
		text.draw(g, Color.white, "You lasted [insert stopwatch here]", 50, 120);
	
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
 {
		
	
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
