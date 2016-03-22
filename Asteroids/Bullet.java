import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bullet extends FlyingObject{
	private ImageIcon bulletimg;
	private JLabel bullet;
	public Bullet(int po_x, int po_y, int sp_x, int sp_y){
			bulletimg = new ImageIcon("bullet.png");
			bullet = new JLabel(bulletimg);
			bullet.setBounds(po_x-4,po_y-4,8,8);
			pos_x = po_x;
			pos_y = po_y;
		SetSpeed(sp_x ,sp_y );
	}
	public JLabel getLabel(){
		return bullet;
	}
	public void SetSpeed(int x, int y){
		speed_x = x;
		speed_y = y;
	}
	public void update(){
		pos_x = pos_x + speed_x;
		pos_y = pos_y + speed_y;
		if(pos_x > 1200 + 200) pos_x = -150;
		if( pos_x < 0 - 200)  pos_x = 1200;
		if( pos_y > 800 + 200)  pos_y = -150;
		if( pos_y < 0 - 200)  pos_y = 800;
		bullet.setBounds(pos_x,pos_y,20,5);
	}


}
