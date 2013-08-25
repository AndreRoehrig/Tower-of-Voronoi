/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 25.08.13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */


import static org.lwjgl.opengl.GL11.*;

public class Result {
public void resultdraw(){

    glBegin(GL_POINTS);
    glVertex2f(1,1);
    glEnd();
}
}