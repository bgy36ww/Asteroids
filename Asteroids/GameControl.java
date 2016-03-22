import java.awt.Container;
import java.awt.Point;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GameControl {
	Sound boom = new Sound("boom1.wav");
	ImageIcon explode = new ImageIcon("explosion.png");
	JLabel explosion = new JLabel(explode);
	JLabel explosion2 = new JLabel(explode);
	
	public GameControl(){}
	
	public void CheckAlienship(Alienship alien, List<Bullet> bullets, SpaceObject space){
		int distance;
		if(bullets.size() > 0){
		for(Bullet bullet2: bullets){
			//System.out.println(alien.alien.getX());
			//System.out.println(alien.alien.getY());
			distance = (bullet2.getLabel().getX() - (alien.alien.getX()+50))*(bullet2.getLabel().getX() - (alien.alien.getX()+50)) 
					+ (bullet2.getLabel().getY() - (alien.alien.getY()+50))*(bullet2.getLabel().getY() - (alien.alien.getY()+50));
			if( distance <= 2500){
				try{
				space.cont.remove(bullet2.getLabel());
				bullets.remove(bullet2);
				alien.bltCount++;
				System.out.println(alien.bltCount);
				if( alien.bltCount == 3){
					space.cont.remove(alien.alien);
					alien.bltCount = 0;
					alien.alienExists = false;
					space.score += 100;
					space.scoreBoard.setText(String.format("Score: %d", space.score));
				}
				break;
				}
				catch(Exception ex){
					System.out.println("checkalienshoot");
				}
			}
		}
		}
	}
	
	public void collisionDetect(List<AsteroidObject> asteroids,SpaceObject space,int num){
		int distance;

		for(AsteroidObject ast: asteroids){
			if(num == 1){
				distance = ((ast.getPosX()+75) - (space.spaceship.getPosX()+20))*((ast.getPosX()+75) - (space.spaceship.getPosX()+20)) 
						+ ((ast.getPosY()+75) - (space.spaceship.getPosY()+20))*((ast.getPosY()+75) - (space.spaceship.getPosY()+20));
				if(distance < 10000){
					boom.play();
					space.cont.add(explosion);
					explosion.setBounds(space.spaceship.ship.getX(),space.spaceship.ship.getY(),80,68);
					space.spaceship.ship.setBounds(600,500,70,70);
					space.life1--;
					space.spaceship.newBorn = true;
				
					//System.out.println(space.life1);
					//space.lifeLeft1.setText(String.format("Player #1 Life: %d",space.life1));
				}
			}else if(num == 2){
				distance = ((ast.getPosX()+75) - (space.spaceship2.getPosX()+20))*((ast.getPosX()+75) - (space.spaceship2.getPosX()+20)) 
						+ ((ast.getPosY()+75) - (space.spaceship2.getPosY()+20))*((ast.getPosY()+75) - (space.spaceship2.getPosY()+20));
				if(distance < 10000){
					boom.play();
					space.spaceship2.ship.setBounds(200,500,70,70);
					space.cont.add(explosion2);
					explosion2.setBounds(space.spaceship2.ship.getX(),space.spaceship2.ship.getY(),80,68);
					space.life2--;
					space.spaceship2.newBorn = true;
					//System.out.println(space.life2);
					//space.lifeLeft2.setText(String.format("Player #2 Life: %d",space.life2));
				}	
			}
		}
		
	}
	
	public void CheckShootEvent(List<Bullet> bullets, SpaceObject space){
		int distance;
		if(bullets.size() > 0){
		for(Bullet bullet2: bullets){
			distance = (bullet2.getPosX() - (space.spaceship.getPosX()+25))*(bullet2.getPosX() - (space.spaceship.getPosX()+25)) 
					+ (bullet2.getPosY() - (space.spaceship.getPosY()+25))*(bullet2.getPosY() - (space.spaceship.getPosY()+25));
			if( distance <= 25*25){
				//cont.remove(ship.ship);
				try{
				space.cont.remove(bullet2.getLabel());
				bullets.remove(bullet2);
				space.cont.add(explosion);
				explosion.setBounds(space.spaceship.ship.getX(),space.spaceship.ship.getY(),80,68);
				space.spaceship.ship.setBounds(600,500,70,70);
				space.life1--;
				space.spaceship.newBorn = true;
				//System.out.println(space.life1);
				//space.lifeLeft1.setText(String.format("Player #1 Life: %d",space.life1));
				break;
				}
				catch(Exception ex){
					System.out.println("checkShoot1");
				}
			}
		}
		}
	}
	public void CheckShootEvent2(List<Bullet> bullets, SpaceObject space){
		int distance;
		if(bullets.size() > 0){
		for(Bullet bullet: bullets){
			distance = (bullet.getPosX() - (space.spaceship2.getPosX()+25))*(bullet.getPosX() - (space.spaceship2.getPosX()+25)) 
					+ (bullet.getPosY() - (space.spaceship2.getPosY()+25))*(bullet.getPosY() - (space.spaceship2.getPosY()+25));
			if( distance <= 25*25){
				//cont.remove(ship.ship);
				try{
				space.cont.remove(bullet.getLabel());
				bullets.remove(bullet);
				}
			catch(Exception ex){
				System.out.println("checkShoot2");
			}
				space.cont.add(explosion2);
				explosion2.setBounds(space.spaceship2.ship.getX(),space.spaceship2.ship.getY(),80,68);
				space.spaceship2.ship.setBounds(600,500,70,70);
				space.spaceship2.newBorn = true;
				space.life2--;
				
				//System.out.println(space.life2);
				//space.lifeLeft2.setText(String.format("Player #2 Life: %d",space.life2));
				break;
			}
		}
		}
	}
	
	public void destroyDetect(int GameLevel, List<AsteroidObject> asteroids,List<Bullet> bullets,SpaceObject space){
		boolean flag = false;
		int distance;
		AsteroidObject asteroid0;
		Container cont = space.cont;
		if(asteroids.size() > 0 && bullets.size() > 0){
		for(AsteroidObject ast: asteroids){
			for(Bullet bullet: bullets){
				if(ast.type.equals("large")){
				distance = (bullet.getPosX() - (ast.getPosX()+75))*(bullet.getPosX() - (ast.getPosX()+75)) 
						+ (bullet.getPosY() - (ast.getPosY()+75))*(bullet.getPosY() - (ast.getPosY()+75));
				if (distance < 75*75)
				{	try{
					cont.remove(ast.getLabel());
					cont.remove(bullet.getLabel());
				}
				catch(Exception ex){
					System.out.println("checkDestroy");
				}
					asteroid0 = new AsteroidObject("small",ast.pos_x,ast.pos_y,ast.speed_x,ast.speed_y);
					space.cont.add(asteroid0.getLabel());
					asteroids.add(asteroid0);
					asteroid0 = new AsteroidObject("small",ast.pos_x,ast.pos_y,-ast.speed_x,-ast.speed_y);
					space.cont.add(asteroid0.getLabel());
					asteroids.add(asteroid0);
					asteroids.remove(ast);	
					bullets.remove(bullet);
					flag = true;
					space.score += 5;
					space.scoreBoard.setText(String.format("Score: %d", space.score));
					break;
				   }
				}
				else{
					distance = (bullet.getPosX() - (ast.getPosX()+32))*(bullet.getPosX() - (ast.getPosX()+32)) 
							+ (bullet.getPosY() - (ast.getPosY()+32))*(bullet.getPosY() - (ast.getPosY()+32));	
					if(distance < 32 * 32)
					{
						cont.remove(ast.getLabel());
						cont.remove(bullet.getLabel());
						asteroids.remove(ast);	
						bullets.remove(bullet);
						flag = true;
						space.score += 5;
						space.scoreBoard.setText(String.format("Score: %d", space.score));
						break;
			   }
				}
			}
			if(flag) break;
		}
		}
		
	}
	
	public void GenerateAsteroids(int GameLevel,int Astnum,String size,SpaceObject spaceShip,List<AsteroidObject> asteroids){
		AsteroidObject asteroid0;
		Random randPos = new Random();
		int speedx,speedy;
		for(int i = 0; i < Astnum;i++){
			do{
			speedx = (randPos.nextInt(10)-5)*GameLevel;
			speedy = (randPos.nextInt(10)-5)*GameLevel;
			} while( speedx == 0 && speedy == 0);
			asteroid0 = new AsteroidObject(size,randPos.nextInt(1200),randPos.nextInt(600),speedx,speedy);
			spaceShip.cont.add(asteroid0.getLabel());
			asteroids.add(asteroid0);
		}
	}

}
