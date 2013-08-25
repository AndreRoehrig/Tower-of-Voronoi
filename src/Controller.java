import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 25.08.13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    Player player1 = new Player(0);
    Player player2 = new Player(1);

    public int frame = 0;
    public int lineheight = (int) (Math.random() * 600);
    public int cursor = 0;

    public void resetcursor(){
        if(cursor > 600){
            this.cursor = 0;
        }
    }

    public void resetlineheight(){
        if(cursor > 600){
            this.lineheight = (int) (Math.random() * 600);
        }
    }
    public void controls(){
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            if (player1.pointsleft == 2){
                player1.x1 = this.cursor;
                player1.y1 = this.lineheight;
                player1.pointsleft = 1;
            }
            else if(player1.pointsleft == 1 && player1.leftkey){
                player1.x2 = this.cursor;
                player1.y2 = this.lineheight;
                player1.pointsleft = 0;
            }
            else{

            }
        }
        else if(Keyboard.isKeyDown(Keyboard.KEY_L)){
            if (player2.pointsleft == 2){
                player2.x1 = this.cursor;
                player2.y1 = this.lineheight;
                player2.pointsleft = 1;
            }
            else if(player2.pointsleft == 1 && player2.leftkey){
                player2.x2 = this.cursor;
                player2.y2 = this.lineheight;
                player2.pointsleft = 0;
            }
            else{

            }

        }
    }
}
