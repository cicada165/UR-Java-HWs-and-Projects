/*Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 9:40a.m.-10:55a.m.
 * TA: Sereen Assi
 *In collaboration with Daiwei Zhang; NetID dzhang28
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeCanvas extends JPanel implements KeyListener {

    public static final int CANVAS_WIDTH = 1024;
    public static final int CANVAS_HEIGHT = 768;

    public WelcomeCanvas() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(GameTest.CANVAS_WIDTH, GameTest.CANVAS_HEIGHT));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font f = new Font("Arial", Font.BOLD, 40);
        g2.setFont(f);
        g2.setColor(Color.RED);
        g2.drawString("*WELCOME TO LOB PONG GAME*", 100, getHeight()/2 - 80);

        f = new Font("Arial", Font.ITALIC, 30);
        g2.setFont(f);
        g2.drawString("(Drag mouse to move paddle", 100, getHeight()/2);
        g2.drawString("Press Enter THEN Drag Mouse to start!)", 100, getHeight()/2 + 50);
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            setVisible(false);
        }
    }
}

