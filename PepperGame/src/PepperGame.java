import org.newdawn.slick.*;
public class PepperGame extends BasicGame {
 
    static int width = 640;
    static int height = 480;
   
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "Neckbeards is gay";
    static int fpslimit = 68;
    private Image basicImage;
   
    public PepperGame(String title) {
        super(title);
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {
    	basicImage = new Image("data\\image.jpg");
    	
       
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
       
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
    	basicImage.draw(100, 100);
    }
   
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new PepperGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.start();
    }
   
}

