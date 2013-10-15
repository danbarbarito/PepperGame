package main;
import states.Gameplay;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
public class PepperGame extends StateBasedGame {
 
    static int width = 640;
    static int height = 480;
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "#1 Game NA";
    static int fpslimit = 60;
    
    public PepperGame(String title) {
        super(title);
    }
 
    
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Gameplay());
		enterState(0);
	}
   
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new PepperGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.setVSync(true);
        app.setAlwaysRender(true);
        app.start();
    }


   
}

