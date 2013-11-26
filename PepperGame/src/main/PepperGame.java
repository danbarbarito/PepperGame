package main;
import states.*;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
public class PepperGame extends StateBasedGame {
 
    static int width = 640;
    static int height = 480;
    static boolean fullscreen = false;
    static boolean showFPS = false;
    static String title = "GPA: V";
    static int fpslimit = 60;
    public static XMLParser xml;    
    public PepperGame(String title) {
        super(title);	
    }

    
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Gameplay());
		addState(new Menu());
		addState(new Loss());
		enterState(0);
		
	}
   
    public static void main(String[] args) throws SlickException {
        xml = new XMLParser();
    	AppGameContainer app = new AppGameContainer(new PepperGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
       // app.setVSync(true); // why do we need vsync?
        app.setAlwaysRender(true);
        app.start();
    }


   
}

