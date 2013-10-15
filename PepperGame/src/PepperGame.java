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
    private Camera camera;
    private Image background;
    
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
       
    }
    
    public void input(GameContainer gc) throws SlickException
    {
    	Input input = gc.getInput();
    	mouseX = input.getAbsoluteMouseX();
    	mouseY = input.getAbsoluteMouseY();
    	character.move(input);

    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
    	input(gc);
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
    	camera.scale(g, width, height);
    	background.draw(0,0,width,height);
    	character.draw();
    	g.resetTransform();
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

