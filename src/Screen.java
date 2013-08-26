/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 24.08.13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

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
    boolean gamerunning = true;

    int check = 0;



    private int FRAMERATE = 60;
    Controller controller = new Controller();

    Picture picture = new Picture();




    public void drawline(int lineheight){
        glColor3f(255, 0, 0);

        glBegin(GL_QUADS);
        glVertex2f(0, lineheight + 2);
        glVertex2f(0, lineheight - 2);
        glVertex2f(600, lineheight - 2);
        glVertex2f(600, lineheight + 2);
        glEnd();

    }

    public void drawcursor(int cursorpos, int lineheight){
        glColor3f(255, 0, 0);

        glBegin(GL_QUADS);
        glVertex2f(cursorpos-2, lineheight + 10);
        glVertex2f(cursorpos-2, lineheight - 10);
        glVertex2f(cursorpos+2, lineheight - 10);
        glVertex2f(cursorpos+2, lineheight + 10);
        glEnd();

    }

    public void p_draw(int p_x, int p_y, int color){
        glColor3f(0, 255, 0);
        if (color == 1){
            glColor3f(0,0,255);
        }
        glBegin(GL_QUADS);
        glVertex2f(p_x-2,p_y-2);
        glVertex2f(p_x-2,p_y+2);
        glVertex2f(p_x+2,p_y+2);
        glVertex2f(p_x+2,p_y-2);
        glEnd();

    }

    public void drawresultpoint(int x, int y){
        if (controller.nearestdistance(x,y)==1){
            glColor3f(0, 255, 0);
            controller.player1.pixels += 1;}


        if (controller.nearestdistance(x,y)==2){
            glColor3f(0, 0, 255);
            controller.player2.pixels += 1;}

        if (controller.nearestdistance(x,y)==0){
            glColor3f(0, 255, 255);}

        glBegin(GL_POINTS);
        glVertex2f(x,y);
        glEnd();
    }


    public void render(){
        Display.sync(FRAMERATE);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        if(Keyboard.isKeyDown(Keyboard.KEY_N)){
            check = 1;
        }

        if (check == 0){
            picture.render_title();
        }


        if (controller.frame < 610 && check == 1){

            drawline(controller.lineheight);

            drawcursor(controller.cursor,controller.lineheight);
            p_draw(controller.player1.x1, controller.player1.y1, 0);
            p_draw(controller.player1.x2,controller.player1.y2,0);
            p_draw(controller.player2.x1,controller.player2.y1,1);
            p_draw(controller.player2.x2,controller.player2.y2,1);

            if (controller.player1.pointsleft == 1 && ! Keyboard.isKeyDown(Keyboard.KEY_A)){
                controller.player1.leftkey = true;
            }

            if (controller.player2.pointsleft == 1 && ! Keyboard.isKeyDown(Keyboard.KEY_L)){
                controller.player2.leftkey = true;
            }


            picture.render();

            if (controller.player1.pointsleft == 2){
                glColor3f(0, 255, 0);
                glBegin(GL_QUADS);
                glVertex2f(110,650);
                glVertex2f(160,650);
                glVertex2f(160,600);
                glVertex2f(110,600);
                glEnd();
            }

            if (controller.player1.pointsleft >= 1){
                glColor3f(0, 255, 0);
                glBegin(GL_QUADS);
                glVertex2f(180,650);
                glVertex2f(230,650);
                glVertex2f(230,600);
                glVertex2f(180,600);
                glEnd();
            }

            if (controller.player2.pointsleft == 2){
                glColor3f(0, 0, 255);
                glBegin(GL_QUADS);
                glVertex2f(450,650);
                glVertex2f(500,650);
                glVertex2f(500,600);
                glVertex2f(450,600);
                glEnd();
            }

            if (controller.player2.pointsleft >= 1){
                glColor3f(0, 0, 255);
                glBegin(GL_QUADS);
                glVertex2f(520,650);
                glVertex2f(570,650);
                glVertex2f(570,600);
                glVertex2f(520,600);
                glEnd();
            }

            glColor3f(0, 0, 0);
            glBegin(GL_QUADS);
            glVertex2f(0,670);
            glVertex2f(600 - controller.frame,670);
            glVertex2f(600 -controller.frame,660);
            glVertex2f(0,660);
            glEnd();

            controller.controls();
            controller.frame += 1;
            controller.cursor += 10;
            controller.resetlineheight();
            controller.resetcursor();


        }
        if (controller.frame < 610){
            Display.update();
        }

        int res_x;
        int res_y;



        if (controller.frame == 610){
            for(res_x = 0; res_x <= 600;  res_x++)
            {
                for(res_y = 0; res_y <= 600; res_y++)
                {
                    drawresultpoint(res_x,res_y);
                }
            }
        if (controller.player1.pixels > controller.player2.pixels){
            picture.render_p1();
        }

        else if (controller.player1.pixels < controller.player2.pixels){
            picture.render_p2();
        }

        else{
            picture.render_draw();
        }



        Display.update();

        if(Keyboard.isKeyDown(Keyboard.KEY_N)){
            controller.frame = 0;
            controller.player1 = new Player(0);
            controller.player2 = new Player(1);
                }

        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
            System.exit(0);
        }
        }
    }

}
