/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */

import java.util.Random;

public class Ball {

    Random ran = new Random();
    protected double v0;

    protected double degree; //between 0 and 180
    protected final double G = 200; //gravity is set to 200 in this game
    public static final int BALL_SIZE = 26;

    protected double locX;
    protected double locY;
    protected double vX;
    protected double vY;

    //Constructor
    public Ball(double v0, double locX) {
        this.v0 = v0;

        //Generate random launch angles in two ranges
        int guess = ran.nextInt(2);
        if (guess == 0) {
            degree = 30 + ran.nextInt(30);
        }
        else if (guess == 1) {
            degree = 120 + ran.nextInt(30);
        }

        this.locX = locX;
        this.locY = (BALL_SIZE / 2) + 1;

        vX = v0 * Math.cos(Math.toRadians(degree));
        vY = v0 * Math.sin(Math.toRadians(degree));
    }

    //update vertical velocity every 0.01s due to gravity
    public void updateVel() {
        vY += (G * (0.01));
    }

    public void updateLoc() {
        locX += (vX * (0.01));
        locY += (vY * (0.01));
    }

    public void bounceLeftRight() {
        vX = -vX;
    }

    public void bounceTopBottom() {
        vY = -vY;
    }

    public void fallDown() {
        vY = Math.abs(vY);
    }

    //Extra Credit
    //Every time when this method is called, speed increase by 1.05
    public void speedUp() {
        vX = 1.05 * vX;
        vY = 1.05 * vY;
    }

    public int getLocX() {
        return (int)locX;
    }

    public int getLocY() {
        return (int)locY;
    }

}
