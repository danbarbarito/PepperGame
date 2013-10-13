import org.newdawn.slick.*;
public class PepperGame extends BasicGame {
 
    static int width = 640;
    static int height = 480;
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "#1 Game NA";
    static int fpslimit = 60;
    private Player character;
    private int mouseX, mouseY;
    private String osName;
    
    public PepperGame(String title) {
        super(title);
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {
    	//Load images depending on Operating System
    	osName = System.getProperty("os.name");
    	if(osName.contains("Windows"))
    	{
    		//Character
    		character = new Player("data\\character.png");
    	}
    	else
    	{
    		//Character
    		character = new Player("data/character.png");
    	}
    	
       
    }
    
    public void input(GameContainer gc, int delta) throws SlickException
    {
    	Input input = gc.getInput();
    	mouseX = input.getAbsoluteMouseX();
    	mouseY = input.getAbsoluteMouseY();
    	Player.move(input);

    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
    	input(gc, delta);
       
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
    	character.draw();
    }
   
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new PepperGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.setVSync(true);
        app.start();
    }
   
}

