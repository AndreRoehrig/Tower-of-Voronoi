/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 24.08.13
 * Time: 19:05
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


public class Initialize {


    /** The normal title of the window */
    private String				WINDOW_TITLE					= "Tower of Voronoi";

    /** The width of the game display area */
    private int						width						= 600;

    /** The height of the game display area */
    private int						height						= 700;



    public void initialize() {
        // initialize the window beforehand
        try {
            Display.setTitle(WINDOW_TITLE);
            Display.create();

            // disable the OpenGL depth test since we're rendering 2D graphics
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, width, 0, height, 1, -1);
            glMatrixMode(GL_MODELVIEW);

        }
        catch (LWJGLException le) {
            System.out.println("Game exiting - exception in initialization:");
            le.printStackTrace();
            return;
        }
    }

}
