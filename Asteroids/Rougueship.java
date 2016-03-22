import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Rougueship extends SpaceShip{
    private int roll=0;
    boolean shoooot = false;
	
    public Rougueship(){
		pos_x=400;
		pos_y=500;	
		shipImg0 = new ImageIcon("rsp0.png");
		shipImg1 = new ImageIcon("rsp1.png");
		shipImg2 = new ImageIcon("rsp2.png");
		shipImg3 = new ImageIcon("rsp3.png");
		shipImg4 = new ImageIcon("rsp4.png");
		shipImg5 = new ImageIcon("rsp5.png");
		shipImg6 = new ImageIcon("rsp6.png");
		shipImg7 = new ImageIcon("rsp7.png");
		shipImg8 = new ImageIcon("rsp8.png");
		shipImg9 = new ImageIcon("rsp9.png");
		shipImg10 = new ImageIcon("rsp10.png");
		shipImg11 = new ImageIcon("rsp11.png");
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
		shoot = new Sound("shoot.wav");
		ship.setBounds(pos_x,pos_y,70,70);
		
	}
    
	public void Update(int t, SpaceObject space){
		Random generator = new Random();
		if (t % 10 == 0){
		roll = generator.nextInt(3) - 1;
		currPos= (currPos+roll) % 12;
		if (currPos<0){currPos+=12;}
		}
		if(t % 200 == 0){
			shoot.play();
			shoooot = true;
		}
		pos_x = ship.getX();
		pos_y = ship.getY();
		space.cont.remove(ship);
		switch (currPos){
		case 0:ship=ship0;
		       delta_x = 2;
		       delta_y = -1;
		       blt_posX = pos_x + 50;
		       blt_posY = pos_y + 23;
		       break;
		case 1:ship=ship1;
	       delta_x = 1;
	       delta_y = -2;
	       blt_posX = pos_x + 49;
	       blt_posY = pos_y + 7;
	       break;
		case 2:ship=ship2;
	       delta_x = 0;
	       delta_y = -3;
	       blt_posX = pos_x + 30;
	       blt_posY = pos_y;
	       break;
		case 3:ship=ship3;
	       delta_x = -1;
	       delta_y = -2;
	       blt_posX = pos_x + 15;
	       blt_posY = pos_y + 5; 
	       break;
		case 4:ship=ship4;
	       delta_x = -2;
	       delta_y = -1;
	       blt_posX = pos_x + 5;
	       blt_posY = pos_y + 27;
	       break;
		case 5:ship=ship5;
	       delta_x = -3;
	       delta_y = 0;
	       blt_posX = pos_x + 2;
	       blt_posY = pos_y + 31;
	       break;
		case 6:ship=ship6;
	       delta_x = -2;
	       delta_y = 1;
	       blt_posX = pos_x + 15;
	       blt_posY = pos_y + 40;
	       break;
		case 7:ship=ship7;
	       delta_x = -1;
	       delta_y = 2;
	       blt_posX = pos_x + 19;
	       blt_posY = pos_y + 60;
	       break;
		case 8:ship=ship8;
	       delta_x = 0;
	       delta_y = 3;
	       blt_posX = pos_x + 30;
	       blt_posY = pos_y + 65;
	       break;
		case 9:ship=ship9;
	       delta_x = 1;
	       delta_y = 2;
	       blt_posX = pos_x + 50;
	       blt_posY = pos_y + 65;
	       break;
		case 10:ship=ship10;
	       delta_x = 2;
	       delta_y = 1;
	       blt_posX = pos_x + 60;
	       blt_posY = pos_y + 50;
	       break;
		case 11:ship=ship11;
	       delta_x = 3;
	       delta_y = 0;
	       blt_posX = pos_x + 66;
	       blt_posY = pos_y + 35;
	       break;
		}
		space.cont.add(ship);			
		if(pos_x > 1200 ) pos_x = -70;
		if( pos_x < -70)  pos_x = 1200;
		if( pos_y > 700)  pos_y = -70;
		if( pos_y < -70)  pos_y = 700;
		speed_x = delta_x;
		speed_y = delta_y;
		ship.setBounds(pos_x+delta_x,pos_y+delta_y,70,70);
	}
	
	
}
