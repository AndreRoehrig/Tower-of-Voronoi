/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 25.08.13
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    int color = 0;
    int x1 = -1000;
    int y1 = -1000;
    int x2 = -1000;
    int y2 = -1000;

    int pixels = 0;

    boolean leftkey = false;

    int pointsleft = 2;
    public Player(int color){
        this.color = color;
    }
}
