import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Alienship extends AsteroidObject{
	private ImageIcon alienimg;
	public JLabel alien;
	Sound shoot;
	int blt_x,blt_y;
	int bltCount = 0;
	boolean alienExists = false;
	
	public Alienship(){
		alienimg = new ImageIcon("ufo.png");
		alien = new JLabel(alienimg);
		pos_x = 0;
		pos_y = 0;
		speed_x = 5;
		speed_y = 5;
	}
	public void update(){
		if(pos_x > 2400 ) speed_x = -speed_x;
		if( pos_x < 0)  speed_x = -speed_x;
		if( pos_y > 1400)  speed_y = -speed_y;
		if( pos_y < 0)  speed_y = -speed_y;
		pos_x = pos_x + speed_x;
		pos_y = pos_y + speed_y;
		alien.setBounds(pos_x,pos_y,100,100);
	}
	
	public Bullet Shoot(SpaceShip ship,int Gamelevel){
		shoot = new Sound("shoot.wav");
		shoot.play();
		blt_x = (ship.pos_x - (pos_x+80)) / 100 * Gamelevel;
		blt_y = (ship.pos_y - (pos_y+20)) / 100 * Gamelevel;
		Bullet bullet = new Bullet(pos_x+130,pos_y+30,blt_x,blt_y*4);
		return bullet;
	}

}
