import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GravitationalObject {
	private int center_x = 600;
	private int center_y = 350;
	private ImageIcon centerImg;
	public JLabel center;
	public GravitationalObject(){
		centerImg = new ImageIcon("universecenter.png");
		center = new JLabel(centerImg);
	}
	public int getX(){
		return center_x;
	}
	public int getY(){
		return center_y;
	}
}
