/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 25.08.13
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */

    import java.io.IOException;
    import org.lwjgl.LWJGLException;
    import org.lwjgl.opengl.Display;
    import org.lwjgl.opengl.DisplayMode;
    import org.lwjgl.opengl.GL11;
    import org.newdawn.slick.Color;
    import org.newdawn.slick.opengl.Texture;
    import org.newdawn.slick.opengl.TextureLoader;
    import org.newdawn.slick.util.ResourceLoader;

    import static org.lwjgl.opengl.GL11.glVertex2f;

public class Picture {

        /** The texture that will hold the image details */
        private Texture texture;
        private Texture player1;
        private Texture player2;
        private Texture draw;
        private Texture title;

        public void init() {

            try {
                // load texture from PNG file
                texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/example.png"));
                player1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/player1.png"));
                player2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/player2.png"));
                draw = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/draw.png"));
                title =  TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/titlescreen.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * draw a quad with the image on it
         */
        public void render() {
            Color.white.bind();
            texture.bind(); // or GL11.glBind(texture.getTextureID());

            GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0,0);
            glVertex2f(0,700);
            GL11.glTexCoord2f((float)0.586,0);
            glVertex2f(600,700);
            GL11.glTexCoord2f((float)0.586,(float)0.78125);
            glVertex2f(600,600);
            GL11.glTexCoord2f(0,(float)0.78125);
            glVertex2f(0,600);
            GL11.glEnd();
        }

    public void render_p1() {
        Color.white.bind();
        player1.bind(); // or GL11.glBind(texture.getTextureID());

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        glVertex2f(0,700);
        GL11.glTexCoord2f((float)0.586,0);
        glVertex2f(600,700);
        GL11.glTexCoord2f((float)0.586,(float)0.78125);
        glVertex2f(600,600);
        GL11.glTexCoord2f(0,(float)0.78125);
        glVertex2f(0,600);
        GL11.glEnd();
    }

    public void render_p2() {
        Color.white.bind();
        player2.bind(); // or GL11.glBind(texture.getTextureID());

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        glVertex2f(0,700);
        GL11.glTexCoord2f((float)0.586,0);
        glVertex2f(600,700);
        GL11.glTexCoord2f((float)0.586,(float)0.78125);
        glVertex2f(600,600);
        GL11.glTexCoord2f(0,(float)0.78125);
        glVertex2f(0,600);
        GL11.glEnd();
    }

    public void render_draw() {
        Color.white.bind();
        draw.bind(); // or GL11.glBind(texture.getTextureID());

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        glVertex2f(0,700);
        GL11.glTexCoord2f((float)0.586,0);
        glVertex2f(600,700);
        GL11.glTexCoord2f((float)0.586,(float)0.78125);
        glVertex2f(600,600);
        GL11.glTexCoord2f(0,(float)0.78125);
        glVertex2f(0,600);
        GL11.glEnd();
    }

    public void render_title() {
        Color.white.bind();
        title.bind(); // or GL11.glBind(texture.getTextureID());

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        glVertex2f(0,700);
        GL11.glTexCoord2f((float)0.586,0);
        glVertex2f(600,700);
        GL11.glTexCoord2f((float)0.586,(float)0.78125);
        glVertex2f(600,0);
        GL11.glTexCoord2f(0,(float)0.78125);
        glVertex2f(0,0);
        GL11.glEnd();
    }


    }
