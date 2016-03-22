import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class AsteroidObject extends FlyingObject{
	private ImageIcon asteroidimg;
	private JLabel asteroid;
	boolean attracted = false;
	String type;
	public AsteroidObject(){};
	public AsteroidObject(String size,int po_x, int po_y, int sp_x, int sp_y){
		if(size.equals("large")) {
			asteroidimg = new ImageIcon("largeAsteroid.png");
			asteroid = new JLabel(asteroidimg);
			asteroid.setBounds(po_x,po_y,150,150);
			pos_x = po_x;
			pos_y = po_y;
			type = "large";
		}else{
			asteroidimg = new ImageIcon("smallAsteroid.png");
			asteroid = new JLabel(asteroidimg);
			asteroid.setBounds(po_x,po_y,64,64);
			pos_x = po_x;
			pos_y = po_y;
			type = "small";
		}
		SetSpeed(sp_x,sp_y);
	}
	
	public JLabel getLabel(){
		return asteroid;
	}
	
	public void SetSpeed(int x, int y){
		speed_x = x ;
		speed_y = y ;
	}
	
	public void update(int gameLevel){
		if(attracted){
			speed_x = speed_x + (600 - (pos_x + 75)) / 300 * gameLevel;
			speed_y = speed_y + (325 - (pos_y + 75)) / 300 * gameLevel;
		}
		pos_x = pos_x + speed_x;
		pos_y = pos_y + speed_y;
		if(pos_x > 1200 ) pos_x = -150;
		if( pos_x < -150)  pos_x = 1200;
		if( pos_y > 700)  pos_y = -150;
		if( pos_y < -150)  pos_y = 700;
		asteroid.setBounds(pos_x,pos_y,150,150);
	}

	public void Attracted(){
		attracted = true;
	}

}
