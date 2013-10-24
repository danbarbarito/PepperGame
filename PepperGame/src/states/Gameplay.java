package states;

import main.*;
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
    public Enemy enemy;
	public Logic logic;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		//Load images depending on Operating System
    	osName = System.getProperty("os.name");
    	//Character
    	character = new Player("data/character.png");
    	//Background
    	background = new Image("data/background.jpg", false, Image.FILTER_NEAREST);
    	camera = new Camera(character);
    	pe = new Particles();
    	enemy = new Enemy();
    	logic = new Logic();
	}
	
	
    public void input(GameContainer gc, Graphics g) throws SlickException
    {
    	Input input = gc.getInput();
    	mouseX = input.getAbsoluteMouseX();
    	mouseY = input.getAbsoluteMouseY();
    	character.move(input);
    	logic.logic(character, enemy);
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
		//Set camera scale
    	//camera.scale(g, width, height);
    	//Draw background
    	background.draw(0,0,width,height);
    	//Move and render particles
    	pe.setPosition(character.posX + character.image.getWidth()/2, character.posY + character.image.getHeight()/2);
    	pe.render();
    	//Draw character
    	character.draw();
    	//Draw Enemies
    	//enemy.spawn(g);
    	//enemy.fall();
    	enemy.activate(g);
    	g.resetTransform();
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
    	pe.update(delta);

		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
