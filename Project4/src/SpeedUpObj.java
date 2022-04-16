/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
//EXTRA CREDIT Class, Non-stationary
public class SpeedUpObj {
    public static final int OBJ_SIZE = 30;

    protected double locX;
    protected double locY;
    protected double vX;

    public SpeedUpObj() {
        locX = 0;
        locY = 150;
        vX = 300;
    }

    public void updateLoc() {
        locX += (vX * (0.01));
    }
    public void bounceLeftRight() {
        vX = -vX;
    }

    public int getLocX() {
        return (int)locX;
    }

    public int getLocY() {
        return (int)locY;
    }
}
