/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 24.08.13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 24.08.13
 * Time: 20:37
 * To change this template use File | Settings | File Templates.
 */
public class Screen {
    private int FRAMERATE = 60;
    private float lineheight = (float) (Math.random() * 800);
    public void render(){
        Display.sync(FRAMERATE);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // set the color of the quad (R,G,B,A)
        glColor3f(0.5f, 0.5f, 1.0f);

        // draw quad
        glBegin(GL_LINES);
        glVertex2f(0, lineheight);
        glVertex2f(800, lineheight);

        glEnd();

        Display.update();

        //Display.update();
    }

}
