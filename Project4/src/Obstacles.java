/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
import java.util.Random;

public class Obstacles {
    Random ran = new Random();

    protected final int OBSTACLE_THICK = 25;

    protected int ObstacleLength = 100 + ran.nextInt(150);

    protected int locY = 175 + ran.nextInt(375);

    protected int locX = 0 + ran.nextInt(900);

    public int getX1() {
        return locX;
    }

    public int getX2() {
        return (locX + ObstacleLength);
    }

    public int getY() {
        return locY;
    }
}
