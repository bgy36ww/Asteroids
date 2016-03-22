import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class SpaceShip extends FlyingObject {
	ImageIcon shipImg0,shipImg1,shipImg2,shipImg3,shipImg4,shipImg5;
    ImageIcon shipImg6,shipImg7,shipImg8,shipImg9,shipImg10,shipImg11;
	public JLabel ship0,ship1,ship4,ship2,ship3,ship5,ship6,ship7,ship8,ship9,ship10,ship11;
	public JLabel ship;
	public int currPos;
	public int delta_x,delta_y;
	public int blt_posX,blt_posY;
	public Sound shoot;
	double speedFactor;
	boolean newBorn = false;
	int newBornDelay = 200;
	
	public SpaceShip(){
		speedFactor = 1;
		shipImg0 = new ImageIcon("sp0.png");
		shipImg1 = new ImageIcon("sp1.png");
		shipImg2 = new ImageIcon("sp2.png");
		shipImg3 = new ImageIcon("sp3.png");
		shipImg4 = new ImageIcon("sp4.png");
		shipImg5 = new ImageIcon("sp5.png");
		shipImg6 = new ImageIcon("sp6.png");
		shipImg7 = new ImageIcon("sp7.png");
		shipImg8 = new ImageIcon("sp8.png");
		shipImg9 = new ImageIcon("sp9.png");
		shipImg10 = new ImageIcon("sp10.png");
		shipImg11 = new ImageIcon("sp11.png");
		
		ship0 = new JLabel(shipImg0);
		ship1 = new JLabel(shipImg1);
		ship4 = new JLabel(shipImg4);
		ship2 = new JLabel(shipImg2);
		ship3 = new JLabel(shipImg3);
		ship5 = new JLabel(shipImg5);
		ship6 = new JLabel(shipImg6);
		ship7 = new JLabel(shipImg7);
		ship8 = new JLabel(shipImg8);
		ship9 = new JLabel(shipImg9);
		ship10 = new JLabel(shipImg10);
		ship11 = new JLabel(shipImg11);
		
		ship = ship2;
		currPos = 2;
		update(false);
		shoot = new Sound("shoot.wav");
	}
	
	public Bullet Shoot(){
		shoot = new Sound("shoot.wav");
		shoot.play();
		Bullet bullet = new Bullet(blt_posX,blt_posY,speed_x*5,speed_y*5);
		return bullet;
	}
	
	
	public void UpdatePos(){
		pos_x = ship.getX();
		pos_y = ship.getY();
		if( pos_x > 1200)  pos_x = -70;
		if( pos_x < -70)  pos_x = 1200;
		if( pos_y > 700)  pos_y = -70;
		if( pos_y < -70)  pos_y = 700;
		 ship.setBounds( pos_x+ speed_x, pos_y+ speed_y,70,70);
		 update(false);
	}
	
	public void update(boolean reverse){
		 pos_x =  ship.getX();
		 pos_y =  ship.getY();
		if( currPos==0){
			 delta_x = 2;
			 delta_y = -1;
			 blt_posX =  pos_x + 50;
			 blt_posY =  pos_y + 23;
		}else if( currPos == 1){
			 delta_x = 1;
			 delta_y = -2;
			 blt_posX =  pos_x + 49;
			 blt_posY =  pos_y + 7;
		}else if( currPos == 2){
			 delta_x = 0;
			 delta_y = -3;
			 blt_posX =  pos_x + 30;
			 blt_posY =  pos_y;
		}else if( currPos == 3){
			 delta_x = -1;
			 delta_y = -2;
			 blt_posX =  pos_x + 15;
			 blt_posY =  pos_y + 5;
		}else if( currPos == 4){
			 delta_x = -2;
			 delta_y = -1;
			 blt_posX =  pos_x + 2;
			 blt_posY =  pos_y + 10;
		}else if( currPos == 5){
			 delta_x = -3;
			 delta_y = 0;
			 blt_posX =  pos_x + 2;
			 blt_posY =  pos_y + 31;
		}else if( currPos == 6){
			 delta_x = -2;
			 delta_y = 1;
			 blt_posX =  pos_x + 2;
			 blt_posY =  pos_y + 40;
		}else if( currPos == 7){
			 delta_x = -1;
			 delta_y = 2;
			 blt_posX =  pos_x + 5;
			 blt_posY =  pos_y + 60;
		}else if( currPos == 8){
			 delta_x = 0;
			 delta_y = 3;
			 blt_posX =  pos_x + 30;
			 blt_posY =  pos_y + 65;
		}else if( currPos == 9){
			 delta_x = 1;
			 delta_y = 2;
			 blt_posX =  pos_x + 50;
			 blt_posY =  pos_y + 65;
		}else if( currPos == 10){
			 delta_x = 2;
			 delta_y = 1;
			 blt_posX =  pos_x + 60;
			 blt_posY =  pos_y + 50;
		}else if( currPos == 11){
			 delta_x = 3;
			 delta_y = 0;
			 blt_posX =  pos_x + 66;
			 blt_posY =  pos_y + 35;
		}
		 speed_x = (int)(speedFactor*delta_x);
		 speed_y = (int)(speedFactor*delta_y);
	}
	
	
}
