package states;

import main.Camera;
import main.Particles;
import main.PepperGame;
import main.Player;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Gameplay extends BasicGameState{
	
	static int width = 640;
    static int height = 480;
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "#1 Game NA";
    static int fpslimit = 60;
    private Player character;
    private int mouseX, mouseY;
    private String osName;
    private Camera camera;
    private Image background;
    public Particles pe;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		//Load images depending on Operating System
    	osName = System.getProperty("os.name");
    	if(osName.contains("Windows"))
    	{
    		//Character
    		character = new Player("data\\character.png");
    		//Background
    		background = new Image("data\\background.jpg", false, Image.FILTER_NEAREST);
    	}
    	else
    	{
    		//Character
    		character = new Player("data/character.png");
    		//Background
    		background = new Image("data/background.jpg", false, Image.FILTER_NEAREST);
    	}
    	camera = new Camera(character);
    	pe = new Particles();
	}
	
    public void input(GameContainer gc) throws SlickException
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
    	camera.scale(g, width, height);
    	background.draw(0,0,width,height);
    	character.draw();
    	pe.render();
    	g.resetTransform();
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		input(container);
    	pe.update(delta);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
