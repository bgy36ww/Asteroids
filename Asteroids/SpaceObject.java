import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SpaceObject extends JFrame // implements KeyListener
{
	public Container cont;
	public SpaceShip spaceship = new SpaceShip();
	public SpaceShip spaceship2 = new SpaceShip();
	public GravitationalObject center = new GravitationalObject();
	boolean shoot = false;
	boolean shoot2 = false;
	boolean pause = false;
	boolean centerExists = false;
	int score = 0;
	JLabel scoreBoard = new JLabel(String.format("Score: %d",score),SwingConstants.CENTER);
	int life1 = 3;
	int life2 = 3;
	int currLevel = 1;
	JLabel lifeLeft1 = new JLabel(String.format("Player #1 Life: %d",life1),SwingConstants.CENTER);
	JLabel lifeLeft2 = new JLabel(String.format("Player #2 Life: %d",life2),SwingConstants.CENTER);
	JLabel currentLevel = new JLabel(String.format("Current Level: %d",currLevel),SwingConstants.CENTER);
	Button butt;
	int mode = 1;
    
	public SpaceObject(){

		super("Asteroid");
		butt = new Button();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,700);
		cont = getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.black);
		
		cont.add(scoreBoard);
		cont.add(lifeLeft1);
		cont.add(lifeLeft2);
		scoreBoard.setForeground(Color.WHITE);
		lifeLeft1.setForeground(Color.WHITE);
		lifeLeft2.setForeground(Color.WHITE);
		currentLevel.setForeground(Color.WHITE);
		
		scoreBoard.setBounds(1000,20,120,30);
		lifeLeft1.setBounds(10,10,120,30);
		lifeLeft2.setBounds(10,40,120,30);
		currentLevel.setBounds(150,10,120,30);
		
		lifeLeft1.setVisible(false);
		lifeLeft2.setVisible(false);
		currentLevel.setVisible(true);
		
		cont.add(spaceship.ship);
		spaceship.ship.setBounds(600,500,70,70);
		spaceship.pos_x = 255;
		spaceship.pos_y = 550;
		spaceship.update(false);
	
		addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				//spaceship.pos_x = spaceship.ship.getX();
				//spaceship.pos_y = spaceship.ship.getY();
				if( key == KeyEvent.VK_UP){
					
					if(spaceship.speedFactor < 3){
					spaceship.speedFactor += 0.2;
					}
					spaceship.update(false);
				}else if( key == KeyEvent.VK_LEFT){
					spaceship.delta_x = 1;
					spaceship.delta_y = 1;
					spaceship.currPos = (spaceship.currPos + 1) % 12;
					cont.remove(spaceship.ship);
					if(spaceship.currPos == 0) spaceship.ship = spaceship.ship0;
					else if(spaceship.currPos == 1) spaceship.ship = spaceship.ship1;
					else if(spaceship.currPos == 2) spaceship.ship = spaceship.ship2;
					else if(spaceship.currPos == 3) spaceship.ship = spaceship.ship3;
					else if(spaceship.currPos == 4) spaceship.ship = spaceship.ship4;
					else if(spaceship.currPos == 5) spaceship.ship = spaceship.ship5;
					else if(spaceship.currPos == 6) spaceship.ship = spaceship.ship6;
					else if(spaceship.currPos == 7) spaceship.ship = spaceship.ship7;
					else if(spaceship.currPos == 8) spaceship.ship = spaceship.ship8;
					else if(spaceship.currPos == 9) spaceship.ship = spaceship.ship9;
					else if(spaceship.currPos == 10) spaceship.ship = spaceship.ship10;
					else if(spaceship.currPos == 11) spaceship.ship = spaceship.ship11;
					cont.add(spaceship.ship);
					spaceship.ship.setBounds(spaceship.pos_x+spaceship.speed_x,spaceship.pos_y+spaceship.speed_y,70,70);
					spaceship.pos_x = spaceship.ship.getX();
					spaceship.pos_y = spaceship.ship.getY();
					spaceship.update(false);
			    }else if( key == KeyEvent.VK_RIGHT){
			    	spaceship.delta_x = 1;
			    	spaceship.delta_y = 1;
			    	spaceship.currPos = spaceship.currPos - 1;
					if( spaceship.currPos == -1) spaceship.currPos = 11;
					cont.remove(spaceship.ship);
					if(spaceship.currPos == 0) spaceship.ship = spaceship.ship0;
					else if(spaceship.currPos == 1) spaceship.ship = spaceship.ship1;
					else if(spaceship.currPos == 2) spaceship.ship = spaceship.ship2;
					else if(spaceship.currPos == 3) spaceship.ship = spaceship.ship3;
					else if(spaceship.currPos == 4) spaceship.ship = spaceship.ship4;
					else if(spaceship.currPos == 5) spaceship.ship = spaceship.ship5;
					else if(spaceship.currPos == 6) spaceship.ship = spaceship.ship6;
					else if(spaceship.currPos == 7) spaceship.ship = spaceship.ship7;
					else if(spaceship.currPos == 8) spaceship.ship = spaceship.ship8;
					else if(spaceship.currPos == 9) spaceship.ship = spaceship.ship9;
					else if(spaceship.currPos == 10) spaceship.ship = spaceship.ship10;
					else if(spaceship.currPos == 11) spaceship.ship = spaceship.ship11;
					cont.add(spaceship.ship);	
					spaceship.ship.setBounds(spaceship.pos_x+spaceship.speed_x,spaceship.pos_y+spaceship.speed_y,70,70);
					//UpdatePos(spaceship);
					spaceship.pos_x = spaceship.ship.getX();
					spaceship.pos_y = spaceship.ship.getY();
					spaceship.update(false);
			    }else if( key == KeyEvent.VK_DOWN){
						if(spaceship.speedFactor > 0){
							spaceship.speedFactor -= 0.1;
						}
						spaceship.update(false);
			    }
		
					if( key == KeyEvent.VK_W){
						spaceship2.update(false);
						if(spaceship2.speedFactor < 3){
							spaceship2.speedFactor += 0.2;
						}
					}else if( key == KeyEvent.VK_A){
						spaceship2.delta_x = 1;
						spaceship2.delta_y = 1;
						spaceship2.currPos = (spaceship2.currPos + 1) % 12;
						if(mode == 2){
						cont.remove(spaceship2.ship);
						if(spaceship2.currPos == 0) spaceship2.ship = spaceship2.ship0;
						else if(spaceship2.currPos == 1) spaceship2.ship = spaceship2.ship1;
						else if(spaceship2.currPos == 2) spaceship2.ship = spaceship2.ship2;
						else if(spaceship2.currPos == 3) spaceship2.ship = spaceship2.ship3;
						else if(spaceship2.currPos == 4) spaceship2.ship = spaceship2.ship4;
						else if(spaceship2.currPos == 5) spaceship2.ship = spaceship2.ship5;
						else if(spaceship2.currPos == 6) spaceship2.ship = spaceship2.ship6;
						else if(spaceship2.currPos == 7) spaceship2.ship = spaceship2.ship7;
						else if(spaceship2.currPos == 8) spaceship2.ship = spaceship2.ship8;
						else if(spaceship2.currPos == 9) spaceship2.ship = spaceship2.ship9;
						else if(spaceship2.currPos == 10) spaceship2.ship = spaceship2.ship10;
						else if(spaceship2.currPos == 11) spaceship2.ship = spaceship2.ship11;
						cont.add(spaceship2.ship);
						spaceship2.ship.setBounds(spaceship2.pos_x+spaceship2.delta_x,spaceship2.pos_y+spaceship2.delta_y,70,70);
						spaceship2.update(false);
						}
				    }else if( key == KeyEvent.VK_D){
				    	spaceship2.delta_x = 1;
				    	spaceship2.delta_y = 1;
				    	spaceship2.currPos = spaceship2.currPos - 1;
						if( spaceship2.currPos == -1) spaceship2.currPos = 11;
						if(mode == 2){
							cont.remove(spaceship2.ship);
							if(spaceship2.currPos == 0) spaceship2.ship = spaceship2.ship0;
							else if(spaceship2.currPos == 1) spaceship2.ship = spaceship2.ship1;
							else if(spaceship2.currPos == 2) spaceship2.ship = spaceship2.ship2;
							else if(spaceship2.currPos == 3) spaceship2.ship = spaceship2.ship3;
							else if(spaceship2.currPos == 4) spaceship2.ship = spaceship2.ship4;
							else if(spaceship2.currPos == 5) spaceship2.ship = spaceship2.ship5;
							else if(spaceship2.currPos == 6) spaceship2.ship = spaceship2.ship6;
							else if(spaceship2.currPos == 7) spaceship2.ship = spaceship2.ship7;
							else if(spaceship2.currPos == 8) spaceship2.ship = spaceship2.ship8;
							else if(spaceship2.currPos == 9) spaceship2.ship = spaceship2.ship9;
							else if(spaceship2.currPos == 10) spaceship2.ship = spaceship2.ship10;
							else if(spaceship2.currPos == 11) spaceship2.ship = spaceship2.ship11;
							cont.add(spaceship2.ship);	
							spaceship2.ship.setBounds(spaceship2.pos_x+spaceship2.speed_x,spaceship2.pos_y+spaceship2.speed_y,70,70);
							spaceship2.update(false);
						}
				    }else if( key == KeyEvent.VK_S){
							spaceship2.update(true);
							if(spaceship2.speedFactor > 0 ){
								spaceship2.speedFactor -= 0.1;
							}
				    }
		
			    	
				
			}
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				int key = e.getKeyCode();
				
				if( key == KeyEvent.VK_SPACE){
					spaceship2.update(false);
					spaceship.shoot.play();
				    shoot = true;
				}
				if( key == KeyEvent.VK_SHIFT){
					spaceship2.update(false);
					spaceship2.shoot.play();
				    shoot2 = true;
				}
				
				if( key == KeyEvent.VK_ESCAPE){
					pause = true;
					butt.turnOn();
				}
				
			}
		});
		setContentPane(cont);
	}

	public boolean CheckPause(){
		if(butt.app.isVisible()){
			pause = true;
		}else{
			pause = false;
		}
		return pause;
	}
	
	public void AddPlayer2(){
		spaceship2.ship = spaceship2.ship2;
		spaceship2.currPos = 2;
		cont.add(spaceship2.ship);
		spaceship2.ship.setBounds(200,500,70,70);
		spaceship2.pos_x = 255;
		spaceship2.pos_y = 550;
		spaceship2.update(false);
		mode = 2;
	}
	
	public void RemovePlayer2(){
		cont.remove(spaceship2.ship);
		cont.repaint();
		mode = 1;
	}
	
	public void turnOncenter(){
		centerExists = true;
		cont.add(center.center);
		center.center.setBounds(575,325,50,50);
	}
	
	public void turnOffcenter(){
		centerExists = false;
		cont.remove(center.center);
	}
	
}

