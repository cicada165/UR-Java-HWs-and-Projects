/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: 
 * TA: 
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.Font;
import javax.swing.JButton;

public class Cube {
	private int num;
	private JButton btn;
	public boolean isAdded;
	//Cube() are the boxes
	public Cube() {
		btn = new JButton();
		btn.setFont(new Font("Times New Roman", Font.BOLD, 24));//set font
		btn.setEnabled(false);
        num = 0;
        //isAdded is used to determine the the boxes are moved the first time.
        isAdded = false;
	}
	//Do not show 0s
	public void setText(int num) {
		this.num=num;
		btn.setText(num != 0 ? num + "" : "");
	}
	
	public JButton getView() {
		return btn;
	}
	
	public int getNum() {
		return num;
	}
	public boolean getisAdded() {
		return isAdded;
	}
	
	public void setisAdded(boolean b) {
		isAdded = b;
	}
	
}
