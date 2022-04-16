/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameCanvas extends JPanel {

    Random ran = new Random();

    protected static final int TIMER_DELAY = 10; //0.01ms
    protected static final int BALL_SIZE = 26;

    protected int v0;
    protected static int paddleLength;
    protected static final int PADDLE_THICK = 20;

    protected Timer timer = new Timer(TIMER_DELAY, new TimerHandler());

    //Create a new ball
    Ball ball1;


    SpeedUpObj obj1 = new SpeedUpObj();
    Obstacles obs1 = new Obstacles();
    Obstacles obs2 = new Obstacles();

    //Mouse location in x-axis decides location of paddle
    public int mouseLocX = GameTest.CANVAS_WIDTH / 2;

    protected double countDown;

    protected String currentLevel;

    //CONSTRUCTOR decides which level of game is created
    public GameCanvas(String level) {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(GameTest.CANVAS_WIDTH, GameTest.CANVAS_HEIGHT));
        switch (level) {
            case "level1":
                currentLevel = level;
                v0 = 300;
                countDown = 30;
                ball1 = new Ball(v0, 400 + ran.nextInt(200));
                paddleLength = 200;
                break;
            case "level2":
                currentLevel = level;
                v0 = 500;
                countDown = 45;
                ball1 = new Ball(v0, 400 + ran.nextInt(200));
                paddleLength = 150;
                break;
            case "level3":
                currentLevel = level;
                v0 = 700;
                countDown = 60;
                ball1 = new Ball(v0, 400 + ran.nextInt(200));
                paddleLength = 100;
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPaddle(g);
        drawInfo(g);
        drawEcObj(g);
        repaint();
    }

    public void drawBall(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(ball1.getLocX() - (BALL_SIZE / 2), ball1.getLocY() - (BALL_SIZE / 2), BALL_SIZE, BALL_SIZE);
        //repaint();
    }

    public void drawPaddle(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(mouseLocX - paddleLength / 2, 680, paddleLength, PADDLE_THICK);
        //repaint();
    }

    //Display information on the top
    public void drawInfo(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font f = new Font("Times", Font.BOLD, 30);
        g2.setFont(f);
        g2.setColor(Color.WHITE);
        g2.drawString(String.format("%S  Your Score: %d", currentLevel, GameTest.score), 30, 50);
        g2.drawString(String.format("%.2f", countDown), 500, 50);
        g2.drawString(String.format("Your Lives %d", GameTest.lives), 800, 50);
        //repaint();
    }

    //draw EXTRA CREDIT objects
    public void drawEcObj(Graphics g) {
        //draw two obstacles (stationary)
        g.setColor(Color.GRAY);
        g.fillRect(obs1.getX1(), obs1.getY(), obs1.ObstacleLength, obs1.OBSTACLE_THICK);
        g.fillRect(obs2.getX1(), obs2.getY(), obs2.ObstacleLength, obs2.OBSTACLE_THICK);

        //draw a 'SpeedUpObj' (non-stationary)
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.YELLOW);
        g2.fillRect(obj1.getLocX(), obj1.getLocY(), 60, 60);

        Font f = new Font("Arial", Font.BOLD, 15);
        g2.setFont(f);
        g2.setColor(Color.WHITE);
        g2.drawString("Speed Up", obj1.getLocX(), obj1.getLocY());
        //repaint();
    }

    //TimeHandler class animates the movement of ball
    protected class TimerHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (GameTest.lives <= 0) {
                stop();
            }

            if (countDown <= 0) {
                stop();
            }

            repaint();
            ball1.updateLoc();
            ball1.updateVel();
            obj1.updateLoc(); //EC
            countDown -= 0.01;

            //Launch another ball if
            //previous ball falls through the bottom of the screen
            if ((ball1.getLocY()) >= GameTest.CANVAS_HEIGHT) {
                restart();
            }

            //Ball hits sides of the window
            if ((ball1.getLocX() + (BALL_SIZE / 2)) >= getWidth() || (ball1.getLocX() - (BALL_SIZE / 2)) <= 0) {
                ball1.bounceLeftRight();
            }

            //Ball hits top of the window
            if ((ball1.getLocY() - (BALL_SIZE / 2)) <= 0) {
                //use fallDown method instead of bounceTopDown to prevent bug
                ball1.fallDown();
            }

            //Ball hits Paddle
            if ((ball1.getLocY() + (BALL_SIZE / 2) >= 680) &&
                    (ball1.getLocY() + (BALL_SIZE / 2) <= 680+PADDLE_THICK) &&
                    (ball1.getLocX() + (BALL_SIZE / 2) >= mouseLocX - paddleLength / 2) &&
                    (ball1.getLocX() - (BALL_SIZE / 2) <= mouseLocX + paddleLength / 2)) {
                if (ball1.getLocY() > 680) {
                    //method to prevent gaming bug (vY=Math.abs(vY))
                    ball1.fallDown();
                }
                else {
                    ball1.bounceTopBottom();
                    GameTest.score += 1;
                }
            }


            //*Extra Credit*
            //If Ball hits the two obstacles, it also bounces
            if (
                    (((ball1.getLocY() + (BALL_SIZE / 2) >= obs1.getY()) &&
                    (ball1.getLocY() + (BALL_SIZE / 2) <= obs1.getY()+obs1.OBSTACLE_THICK))||
                            ((ball1.getLocY() - (BALL_SIZE / 2) <= obs1.getY()+obs1.OBSTACLE_THICK) &&
                                    (ball1.getLocY() - (BALL_SIZE / 2) >= obs1.getY())))
                    &&
                    (ball1.getLocX() + (BALL_SIZE / 2) >= obs1.getX1()) &&
                    (ball1.getLocX() - (BALL_SIZE / 2) <= obs1.getX2())) {
                ball1.bounceTopBottom();
            }

            if (
                    (((ball1.getLocY() + (BALL_SIZE / 2) >= obs2.getY()) &&
                    (ball1.getLocY() + (BALL_SIZE / 2) <= obs2.getY()+obs2.OBSTACLE_THICK))||
                            ((ball1.getLocY() - (BALL_SIZE / 2) <= obs2.getY()+obs2.OBSTACLE_THICK) &&
                            (ball1.getLocY() - (BALL_SIZE / 2) >= obs2.getY())))
                            &&
                            (ball1.getLocX() + (BALL_SIZE / 2) >= obs2.getX1()) &&
                            (ball1.getLocX() - (BALL_SIZE / 2) <= obs2.getX2())) {
                ball1.bounceTopBottom();
            }

            //*Extra Credit*
            //If the ball enters the 'SpeedUpObj', speed will increase (by 1.05) EVERY 0.01s
            //and player will score extra point (EVERY 0.01s ball is in the obj, 1 point is gained)
            if ( (ball1.getLocX() >= obj1.getLocX()) && (ball1.getLocX() <= obj1.getLocX()+SpeedUpObj.OBJ_SIZE)
             && (ball1.getLocY() >= obj1.getLocY()) && (ball1.getLocY() <= obj1.getLocY()+SpeedUpObj.OBJ_SIZE)) {
                GameTest.score += 1;
                ball1.speedUp();
            }
            //'SpeedUpObj' can also be bounced by walls
            if ((obj1.getLocX() + SpeedUpObj.OBJ_SIZE) >= getWidth() ||
                    (obj1.getLocX() <= 0)) {
                obj1.bounceLeftRight();
            }
            
        }
    }

    protected class MouseHandler implements MouseMotionListener {

        public void mouseMoved(MouseEvent e) {

        }

        //mouseDragged method controls the position of paddle
        public void mouseDragged(MouseEvent e) {
            mouseLocX = e.getX();
        }
    }

    //Method that starts the timer
    public void start() {
        timer.start();
        MouseHandler mouseHandler = new MouseHandler();
        addMouseMotionListener(mouseHandler);
    }

    //Method that launches another ball if
    //previous ball falls through the bottom of the screen
    public void restart() {
        GameTest.lives -= 1;
        ball1 = new Ball(v0, 400 + ran.nextInt(200));
        timer.restart();
    }

    //Method that stops one level
    //occurs when lives are all lost or current level is won
    public void stop() {
        timer.stop();
    }
}

