	import javax.swing.*;
import javax.swing.event.*;

	import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
	
	public class Asteroid{
	
		public static void main(String[] args) {
			//int GameLevel = 1;
			boolean pause = false;
			boolean existsf = true; //whether gravitational object exists
			boolean visiblef = true; //whether gravitational object visible
			boolean Limitedf = false; //limited or unlimited life mode flag
			boolean preLimitedf = Limitedf;
			boolean multf = false; //multi-player flag
			int Asnum = 3; //asteroid number
			int prevAsnum = Asnum;
			int timeCount = 0;
			int Stlvl = 1; // game level
			int currentLife1 = 9;
			int currentLife2 = 9;
			int alienDelay = 333;
			boolean revised = false;
	
			Rougueship rougueship = new Rougueship();
			Alienship alien = new Alienship();
			
			SpaceObject spaceShip = new SpaceObject();
			spaceShip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			List<AsteroidObject> asteroids = new ArrayList<AsteroidObject>();
			List<Bullet> bullets = new ArrayList<Bullet>();
			
			//System.out.println(asteroids.size());
			long startTime = System.currentTimeMillis();
			long currTime = startTime;
			long elapsedTime;
			
			//Sound sound = new Sound("back.wav");
	    	//sound.playforever();
	    	Bullet bullet;
	    	GameControl gameHandler = new GameControl();
	    	
	    	gameHandler.GenerateAsteroids(Stlvl, Asnum,"large", spaceShip, asteroids);
	    	
	  
			while(true){
				
				elapsedTime = System.currentTimeMillis() - currTime;
				currTime += elapsedTime;
				pause = spaceShip.CheckPause();
				if(!pause){	
				timeCount++;
				if(timeCount == 1000){
					timeCount = 0;
				}
				//System.out.println(timeCount);
				//saveflag
				if (spaceShip.butt.saveflag){
					try{
						spaceShip.butt.saveflag=false;
						FileWriter filewriter=new FileWriter(spaceShip.butt.filename);
						BufferedWriter bufferwriter= new BufferedWriter(filewriter);
						String temp="";
						if(spaceShip.butt.exitsf){
							temp="1";
						}else{
							temp="0";
						}
						bufferwriter.write((temp));
						bufferwriter.newLine();
						if(spaceShip.butt.visiblef){
							temp="1";
						}else{
							temp="0";
						}
						bufferwriter.write((temp));
						bufferwriter.newLine();
						if(spaceShip.butt.Limitedf){
							temp="1";
						}else{
							temp="0";
						}
						bufferwriter.write((temp));
						bufferwriter.newLine();
						if(spaceShip.butt.multf){
							temp="1";
							bufferwriter.write((temp));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.spaceship2.pos_x)));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.spaceship2.pos_y)));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.spaceship2.currPos)));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.spaceship2.delta_x)));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.spaceship2.delta_y)));
							bufferwriter.newLine();
							bufferwriter.write((Integer.toString(spaceShip.life2)));
							bufferwriter.newLine();
							
							
							
							
							
						}else{
							temp="0";
							bufferwriter.write((temp));
							bufferwriter.newLine();
						}

						bufferwriter.write((spaceShip.butt.name));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.butt.score)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.score)));
						bufferwriter.newLine();

						bufferwriter.write((Integer.toString(spaceShip.butt.Asnum)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.butt.Stlvl)));
						bufferwriter.newLine();
						
						bufferwriter.write((Integer.toString(spaceShip.spaceship.pos_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.spaceship.pos_y)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.spaceship.currPos)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.spaceship.delta_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.spaceship.delta_y)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(spaceShip.life1)));
						bufferwriter.newLine();
						
						bufferwriter.write((Integer.toString(rougueship.pos_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(rougueship.pos_y)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(rougueship.currPos)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(rougueship.delta_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(rougueship.delta_y)));
						bufferwriter.newLine();
						
						bufferwriter.write((Integer.toString(alien.pos_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(alien.pos_y)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(alien.speed_x)));
						bufferwriter.newLine();
						bufferwriter.write((Integer.toString(alien.speed_y)));
						bufferwriter.newLine();
						
						bufferwriter.write((Integer.toString(asteroids.size())));
						bufferwriter.newLine();
						for (AsteroidObject asteroid: asteroids)
						{
							bufferwriter.write(asteroid.type);
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(asteroid.pos_x));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(asteroid.pos_y));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(asteroid.speed_x));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(asteroid.speed_y));
							bufferwriter.newLine();
						}
						bufferwriter.write((Integer.toString(bullets.size())));
						bufferwriter.newLine();
						for (Bullet bullet2: bullets)
						{
							bufferwriter.write(Integer.toString(bullet2.pos_x));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(bullet2.pos_y));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(bullet2.speed_x));
							bufferwriter.newLine();
							bufferwriter.write(Integer.toString(bullet2.speed_y));
							bufferwriter.newLine();
						}
						
						bufferwriter.close();
						
						
						
						
					}catch(IOException ex){
						ex.printStackTrace();
					}
				}
				
				
				if (spaceShip.butt.loadflag){
					try{
						spaceShip.cont.removeAll();
						spaceShip.butt.loadflag=false;
						

						FileReader filereader=new FileReader(spaceShip.butt.filename);
						BufferedReader bufferreader= new BufferedReader(filereader);
						String temp="";
						temp=bufferreader.readLine();
						
						if(temp.equals("1")){
							spaceShip.butt.exitsf=true;
						}else{
							spaceShip.butt.exitsf=false;
						}

						temp=bufferreader.readLine();
						if(temp.equals("1")){
							spaceShip.butt.visiblef=true;
						}else{
							spaceShip.butt.visiblef=false;
						}
						
						temp=bufferreader.readLine();
						if(temp.equals("1")){
							spaceShip.butt.Limitedf=true;
						}else{
							spaceShip.butt.Limitedf=false;
						}
						
						temp=bufferreader.readLine();
						if(temp.equals("1")){
							spaceShip.butt.multf=true;
							spaceShip.cont.add(spaceShip.spaceship2.ship);
							spaceShip.spaceship2.pos_x=Integer.parseInt(bufferreader.readLine());
							spaceShip.spaceship2.pos_y=Integer.parseInt(bufferreader.readLine());
							spaceShip.spaceship2.currPos=Integer.parseInt(bufferreader.readLine());
							spaceShip.spaceship2.delta_x=Integer.parseInt(bufferreader.readLine());
							spaceShip.spaceship2.delta_y=Integer.parseInt(bufferreader.readLine());
							spaceShip.life2=Integer.parseInt(bufferreader.readLine());
							
							
						}else{
							spaceShip.butt.multf=false;
						}
						

	                    spaceShip.butt.name=bufferreader.readLine();

	                    spaceShip.butt.score=Integer.parseInt(bufferreader.readLine());

						
	                    spaceShip.score=Integer.parseInt(bufferreader.readLine());

						spaceShip.cont.add(spaceShip.scoreBoard);
						spaceShip.scoreBoard.setText(String.format("Score: %d", spaceShip.score));
						spaceShip.scoreBoard.setBounds(1000,20,120,30);
						spaceShip.scoreBoard.setVisible(true);
	                    spaceShip.butt.Asnum=Integer.parseInt(bufferreader.readLine());

	                    spaceShip.butt.Stlvl=Integer.parseInt(bufferreader.readLine());

						spaceShip.cont.add(spaceShip.spaceship.ship);
						
						
						spaceShip.spaceship.pos_x=Integer.parseInt(bufferreader.readLine());
						spaceShip.spaceship.pos_y=Integer.parseInt(bufferreader.readLine());
						spaceShip.spaceship.currPos=Integer.parseInt(bufferreader.readLine());
						spaceShip.spaceship.delta_x=Integer.parseInt(bufferreader.readLine());
						spaceShip.spaceship.delta_y=Integer.parseInt(bufferreader.readLine());
						spaceShip.life1=Integer.parseInt(bufferreader.readLine());
						
						spaceShip.cont.add(rougueship.ship);
						
						rougueship.pos_x=Integer.parseInt(bufferreader.readLine());
						rougueship.pos_y=Integer.parseInt(bufferreader.readLine());
						rougueship.currPos=Integer.parseInt(bufferreader.readLine());
						rougueship.delta_x=Integer.parseInt(bufferreader.readLine());
						rougueship.delta_y=Integer.parseInt(bufferreader.readLine());


	                    spaceShip.cont.add(alien.alien)	;				
	                    alien.pos_x=Integer.parseInt(bufferreader.readLine());
	                    alien.pos_y=Integer.parseInt(bufferreader.readLine());
	                    alien.speed_x=Integer.parseInt(bufferreader.readLine());
	                    alien.speed_y=Integer.parseInt(bufferreader.readLine());
	                    

						asteroids.clear();
						AsteroidObject asteroid0;
						int size=Integer.parseInt(bufferreader.readLine());
						for (int i=0;i<size;i++){
							asteroid0 = new AsteroidObject("Large",0,0,0,0);
							asteroid0.type=bufferreader.readLine();
		                    asteroid0.pos_x=Integer.parseInt(bufferreader.readLine());
		                    asteroid0.pos_y=Integer.parseInt(bufferreader.readLine());
		                    asteroid0.speed_x=Integer.parseInt(bufferreader.readLine());
		                    asteroid0.speed_y=Integer.parseInt(bufferreader.readLine());
							

							spaceShip.cont.add(asteroid0.getLabel());
							asteroids.add(asteroid0);
							
						}
						
						bullets.clear();
						Bullet bullet2;
					    size=Integer.parseInt(bufferreader.readLine());
						for (int i=0;i<size;i++){
							bullet2 = new Bullet(0,0,0,0);
		                    bullet2.pos_x=Integer.parseInt(bufferreader.readLine());
		                    bullet2.pos_y=Integer.parseInt(bufferreader.readLine());
		                    bullet2.speed_x=Integer.parseInt(bufferreader.readLine());
		                    bullet2.speed_y=Integer.parseInt(bufferreader.readLine());
							

							spaceShip.cont.add(bullet2.getLabel());
							bullets.add(bullet2);
							
						}
							
						

						

						
						bufferreader.close();
						
						
						
						
					}catch(IOException ex){
						ex.printStackTrace();
					}
				}

				
				
				
				if( alienDelay / Stlvl == timeCount && alien.alienExists == false){
					spaceShip.cont.add(alien.alien);
					alien.alienExists = true;
				}
				
				if(revised){
					revised = false;
					if(prevAsnum != Asnum && asteroids.size() < Asnum){
						gameHandler.GenerateAsteroids(Stlvl, Asnum,"large", spaceShip, asteroids);
					}
					
					if(existsf) {
						for(AsteroidObject ast: asteroids){
							ast.Attracted();
						}
					}
					else if (!existsf) {
						for(AsteroidObject ast: asteroids){
							ast.attracted = false;
							//System.out.println(ast);
						}
					}
					
					if(visiblef && !spaceShip.centerExists) spaceShip.turnOncenter();
					else if ((!visiblef) && spaceShip.centerExists) spaceShip.turnOffcenter();
					
					if(multf && spaceShip.mode == 1) {
						spaceShip.AddPlayer2();
						if(Limitedf) spaceShip.lifeLeft2.setVisible(true);
					}
					else if((!multf) && spaceShip.mode == 2) {
						spaceShip.RemovePlayer2();
						if(Limitedf) spaceShip.lifeLeft2.setVisible(false);
					}
					
					if((!preLimitedf) && Limitedf){
						spaceShip.life1 = 3;
						spaceShip.life2 = 3;
						spaceShip.lifeLeft1.setVisible(true);
						if(multf) spaceShip.lifeLeft2.setVisible(true);
					}else if(preLimitedf && ! Limitedf){
						spaceShip.lifeLeft1.setVisible(false);
						if(multf) spaceShip.lifeLeft2.setVisible(false);
					}
					
				}
				if(!Limitedf){
					spaceShip.life1 = 1000000;
					spaceShip.life2 = 1000000;
				}
				spaceShip.spaceship.UpdatePos();
				rougueship.Update(timeCount, spaceShip);
				alien.update();
				if(timeCount % (270/Stlvl) == 0){
					bullet = alien.Shoot(spaceShip.spaceship, Stlvl);
					spaceShip.cont.add(bullet.getLabel());
					bullets.add(bullet);				
				}
				if(rougueship.shoooot){
					rougueship.shoooot = false;
					bullet = rougueship.Shoot();
					spaceShip.cont.add(bullet.getLabel());
					bullets.add(bullet);
				}
				if(!spaceShip.spaceship.newBorn){
					gameHandler.collisionDetect(asteroids, spaceShip,1);
					gameHandler.CheckShootEvent(bullets, spaceShip);
				}else{
					spaceShip.spaceship.newBornDelay--;
					if(spaceShip.spaceship.newBornDelay == 0){
						spaceShip.spaceship.newBorn = false;
						spaceShip.spaceship.newBornDelay = 200;
						spaceShip.cont.remove(gameHandler.explosion);
					}
				}
				
				if(multf){
					spaceShip.spaceship2.UpdatePos();
					if(!spaceShip.spaceship2.newBorn){
						gameHandler.collisionDetect(asteroids, spaceShip,2);
						gameHandler.CheckShootEvent2(bullets, spaceShip);
						}else{
							spaceShip.spaceship2.newBornDelay--;
							if(spaceShip.spaceship2.newBornDelay == 0){
								spaceShip.spaceship2.newBorn = false;
								spaceShip.spaceship2.newBornDelay = 200;
								spaceShip.cont.remove(gameHandler.explosion2);
							}
						}
					
				}
				for(AsteroidObject asteroid: asteroids){
					asteroid.update(Stlvl);
				}
				
				if(spaceShip.shoot){
					bullet = spaceShip.spaceship.Shoot();
					spaceShip.cont.add(bullet.getLabel());
					bullets.add(bullet);
					spaceShip.shoot = false;
				}
				
				
				if(spaceShip.shoot2){
					bullet = spaceShip.spaceship2.Shoot();
					spaceShip.cont.add(bullet.getLabel());
					bullets.add(bullet);
					spaceShip.shoot2 = false;
				}
				gameHandler.destroyDetect(Stlvl,asteroids, bullets, spaceShip);
				try{
				for(Bullet blt: bullets){
					blt.update();
					int x = blt.getPosX();
					int y = blt.getPosY();
					if( x < 0 || x > 1200 || y < 0 || y > 800 ){
						spaceShip.cont.remove(blt.getLabel());
		                //spaceShip.cont.validate();
						bullets.remove(blt);	
						break;
					}
				}
				}
				catch(Exception ex){
					System.out.println("bulletOutofbound");
				}
				gameHandler.destroyDetect(Stlvl,asteroids, bullets, spaceShip);
				if(alien.alienExists){
					gameHandler.CheckAlienship(alien, bullets, spaceShip);
				}
				//gameHandler.collisionDetect(asteroids, spaceShip,1);
				//gameHandler.collisionDetect(asteroids, spaceShip,2);
				prevAsnum  = Asnum;
				preLimitedf = Limitedf;
				if(Limitedf){
					currentLife1 = spaceShip.life1;
					currentLife2 = spaceShip.life2;
					spaceShip.lifeLeft1.setText(String.format("Player #1 Life: %d",currentLife1));
					if(multf){
						spaceShip.lifeLeft2.setText(String.format("Player #2 Life: %d",currentLife2));
					}
				}
				if(asteroids.size() == 0){
					Stlvl++;
					gameHandler.GenerateAsteroids(Stlvl, Asnum + Stlvl, "large", spaceShip, asteroids);
				}
				if(spaceShip.life1 == 0 && spaceShip.score > spaceShip.butt.score){
					
					spaceShip.scoreBoard.setText(String.format("Score: %d",spaceShip.score));
					spaceShip.butt.name=(String)JOptionPane.showInputDialog(spaceShip,"Congratulation!\n you recieve highest score","Name",JOptionPane.QUESTION_MESSAGE,null, null, "");
				    spaceShip.butt.score=spaceShip.score;
				    spaceShip.butt.textLabel5.setText(String.format("Highest Score: %d by %s",spaceShip.butt.score,spaceShip.butt.name));
				    spaceShip.score=0;
				    spaceShip.life1=3;
				    Stlvl = 1;
				    for(AsteroidObject ast: asteroids){
				    	spaceShip.cont.remove(ast.getLabel());
				    }
					asteroids.clear();
				}else if (spaceShip.life1 == 0){
					
					spaceShip.scoreBoard.setText(String.format("Score: %d",spaceShip.score));
					JOptionPane.showMessageDialog(spaceShip,"Oppoos, you die!\nGame Over");
					spaceShip.score=0;
					spaceShip.life1=3;
					Stlvl = 1;
					for(AsteroidObject ast: asteroids){
				    	spaceShip.cont.remove(ast.getLabel());
				    }
					asteroids.clear();
				}
				}else{
					existsf = spaceShip.butt.exitsf; //whether gravitational object exists
					visiblef = spaceShip.butt.visiblef; //whether gravitational object visible
					Limitedf = spaceShip.butt.Limitedf; //limited or unlimited life mode flag
					multf = spaceShip.butt.multf; //multi-player flag
					Asnum = spaceShip.butt.Asnum; //asteroid number
					Stlvl = spaceShip.butt.Stlvl; // game level	
					revised = true;
				}
				try{
					Thread.sleep(15);
				}catch (InterruptedException ex){}
				
			}
			//spaceShip.ship.setBounds(spaceShip.ship.getX()+spaceShip.delta_x,spaceShip.ship.getY()+spaceShip.delta_y,139,139);
			
		}
		
	
	}
