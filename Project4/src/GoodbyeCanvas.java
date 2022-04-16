/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
import javax.swing.*;
import java.awt.*;

public class GoodbyeCanvas extends JPanel {

    public static final int CANVAS_WIDTH = 1024;
    public static final int CANVAS_HEIGHT = 768;

    protected boolean result;

    public GoodbyeCanvas(boolean result) {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(GameTest.CANVAS_WIDTH, GameTest.CANVAS_HEIGHT));
        this.result = result;
    }

    public void paintComponent(Graphics g) {
        if (result == false) {
            drawLoss(g);
        }
        else if (result == true) {
            drawWin(g);
        }
        repaint();
    }

    public void drawLoss(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font f = new Font("Times", Font.BOLD, 30);
        g2.setFont(f);
        g2.setColor(Color.RED);
        g2.drawString(String.format("YOU LOST ALL YOU LIVES, Your score is %d", GameTest.score), 90, getHeight()/2);
        repaint();
    }

    public void drawWin(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font f = new Font("Times", Font.BOLD, 30);
        g2.setFont(f);
        g2.setColor(Color.RED);
        g2.drawString(String.format("YOU PASSED ALL LEVELS!!, Your score is %d", GameTest.score), 100, getHeight()/2);
        repaint();
    }
}
