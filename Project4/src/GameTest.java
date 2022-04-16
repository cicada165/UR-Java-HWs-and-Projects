/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
import javax.swing.*;
import java.awt.*;

public class GameTest extends JFrame {

    public static final int CANVAS_WIDTH = 1024;
    public static final int CANVAS_HEIGHT = 768;

    public static int lives = 3;
    public static int score = 0;

    public GameTest() {
        setTitle("GAME!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        GameTest gameTest = new GameTest();
        gameTest.setVisible(true);

        

        //If 'Enter' is typed, welcomeCanvas will be not visible
        //then a gameCanvas of level1 is added
        GameCanvas canvas1 = new GameCanvas("level1");
        gameTest.add(canvas1, BorderLayout.NORTH);
        canvas1.start();
        gameTest.pack();
        
        while (canvas1.timer.isRunning()){

        }
        canvas1.setVisible(false);
        //Once canvas1's timer stops, canvas1 becomes not visible

        if (lives <= 0){
            //If canvas1's timer stops due to loss of all lives
            //a message of loss will be displayed
            JPanel goodbyeCanvas = new GoodbyeCanvas(false);
            gameTest.add(goodbyeCanvas);
            gameTest.pack();
        }
        else {
            //If canvas1's timer stops due to countdown
            //a gameCanvas of next level will be added
            GameCanvas canvas2 = new GameCanvas("level2");
            gameTest.add(canvas2, BorderLayout.NORTH);
            canvas2.start();
            score += 5;
            gameTest.pack();

            while (canvas2.timer.isRunning()) {
            }
            canvas2.setVisible(false);


            if (lives <= 0) {
                JPanel goodbyeCanvas = new GoodbyeCanvas(false);
                gameTest.add(goodbyeCanvas);
                gameTest.pack();
            }
            else {
                GameCanvas canvas3 = new GameCanvas("level3");
                gameTest.add(canvas3, BorderLayout.NORTH);
                canvas3.start();
                score += 10;
                gameTest.pack();

                while (canvas3.timer.isRunning()) {
                }
                canvas3.setVisible(false);


                if (lives <= 0) {
                    JPanel goodbyeCanvas = new GoodbyeCanvas(false);
                    gameTest.add(goodbyeCanvas);
                    gameTest.pack();
                }
                else {
                    //pass all levels
                    JPanel goodbyeCanvas = new GoodbyeCanvas(true);
                    gameTest.add(goodbyeCanvas);
                    gameTest.pack();
                }
            }
        }
    }
}
