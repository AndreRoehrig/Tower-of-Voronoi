/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 24.08.13
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class Main {


    public static void main(String[] args){
        try {
            Display.setDisplayMode(new DisplayMode(600, 700));
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        Initialize init = new Initialize();
        init.initialize();
        Display.sync(60);
        Screen renderfunc = new Screen();
        renderfunc.picture.init();
        Sound music = new Sound();
        music.init();
        music.music.playAsMusic(1.0f, 1.0f, true);
        while (true) {
            renderfunc.render();
        }
    }
}