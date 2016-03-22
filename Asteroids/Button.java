	import javax.swing.*;
	
	import java.awt.*;
	import java.awt.event.*;
	public class Button{
		JFrame app = new JFrame("menu"); 
		public boolean exitsf = false;
		public boolean visiblef = false;
		public boolean Limitedf = false;
		public boolean multf = false;
		public int Asnum = 3;
		public int Stlvl = 1;
		public int score = 0;
		public String name = "Cicy";
		private JButton button1 ;
		private JButton button2 ;
		private JButton button3 ;
		private JButton button4 ;
		private JButton button5 ;
		private JButton button6 ;
		private JButton button7 ;
		private JButton buttonp ;
		private JButton buttonn ;
		private JButton buttonp2 ;
		private JButton buttonn2 ;
		private JLabel textLabel ;
		private JLabel textLabel2 ;
		private JLabel textLabel3 ;
		private JLabel textLabel4 ;
		public JLabel textLabel5 ;
		private JButton button55 ;
		public boolean saveflag=false;//saveflag
		public boolean loadflag=false;//saveflag
		public String filename=null;///saveflag
			
	public Button(){
		Container c =app.getContentPane();
		c.setLayout(null);
	    button1 = new JButton("Not Exists");
	    button2 = new JButton("Reset High score holder");
	    button3 = new JButton("Not Visible");
	    button3.setVisible(false);
	    button4 = new JButton("Yes");
	    button5 = new JButton("Load");
	    button6 = new JButton("Resume");
	    button7 = new JButton("Single Player");  
	    buttonp = new JButton("+");
	    buttonn = new JButton("-");
	    buttonp2 = new JButton("+");
	    buttonn2 = new JButton("-");
	    textLabel = new JLabel("Gravitional Object:",SwingConstants.CENTER);
	    textLabel2 = new JLabel("Unlimited lives:",SwingConstants.CENTER);
	    textLabel3 = new JLabel(String.format("Number of Asteroids:%d",Asnum),SwingConstants.CENTER);
	    textLabel4 = new JLabel(String.format("Starting Level:%d",Stlvl),SwingConstants.CENTER);
	    textLabel5 = new JLabel(String.format("Highest Score: %d by %s",score,name),SwingConstants.CENTER);
	    
	    button55 = new JButton("Save");
	
	    c.add(button55);
	
	    button55.setBounds(320, 100, 70, 30);
	
	    
	
	    c.add(button1);
	    c.add(button2);
	    c.add(button3);
	    c.add(button4);
	    c.add(button5);
	    c.add(button6);
	    c.add(button7);
	    c.add(buttonp);
	    c.add(buttonn);
	    c.add(buttonp2);
	    c.add(buttonn2);
	    c.add(textLabel);
	    c.add(textLabel2);
	    c.add(textLabel3);
	    c.add(textLabel4);
	    c.add(textLabel5);
	    textLabel.setBounds(60, 20, 120, 30);
	    textLabel2.setBounds(60, 140, 120, 30);
	    textLabel3.setBounds(240, 20, 160, 30);
	    textLabel4.setBounds(240, 140, 160, 30);
	    textLabel5.setBounds(140, 300, 260, 30);
	    button1.setBounds(60, 60, 120, 30);
	    button2.setBounds(60, 260, 200, 30);
	    button3.setBounds(60, 100, 120, 30);
	    button4.setBounds(60, 180, 120, 30);
	    button5.setBounds(250, 100, 70, 30);
	    button6.setBounds(260, 260, 120, 30);
	    button7.setBounds(140, 220, 160, 30);
	    buttonp.setBounds(260, 60, 50, 30);
	    buttonn.setBounds(330, 60, 50, 30);
	    buttonp2.setBounds(260, 180, 50, 30);
	    buttonn2.setBounds(330, 180, 50, 30);
	    
	
	  //Load game event
	  button5.addActionListener(new ActionListener(){
	  	public void actionPerformed(ActionEvent e){
	  		filename = (String)JOptionPane.showInputDialog(app,"Input Loading name:","Load",JOptionPane.QUESTION_MESSAGE,null, null, "");
	  		loadflag=true;//saveflag
	  	}
	  });
	  //Save game event
	  button55.addActionListener(new ActionListener(){
	  	public void actionPerformed(ActionEvent e){
	  		 filename= (String)JOptionPane.showInputDialog(app,"Input Saving name:","Save",JOptionPane.QUESTION_MESSAGE,null, null, "");
	  		saveflag=true;//saveflag
	  	}
	  });
	  
	    //multiple player event
	    button7.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		multf=!multf;
	    		if (multf){
	               button7.setText("Multiple Player");    			
	    		}else{
	    			button7.setText("Single Player");
	    		}
	    		
	    	}
	    });
	    
	    
	    //resume
	    button6.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		app.setVisible(false);
	    		//System.out.println(app.isVisible());
	    	}
	    });
	   
	    //Reset high score event
	    button2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		name = " ";
	    		score = 0;
	    		textLabel5.setText(String.format("Highest Score: %d by %s",score,name));
	    	}
	    });
	       
	    //Gravitional object exits event
	    button1.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		exitsf=!exitsf;
	    		if (exitsf){
	               button1.setText("Exists");    	
	               button3.setVisible(true);
	    		}else{
	    			button1.setText("Not Exists");
	    			button3.setVisible(false);
	    			visiblef = false;
	    		}
	    		
	    	}
	    });
	    
	    //Asteroid number event
	    
	    
	    buttonp.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (Asnum<9){
	    		Asnum++;}
	    		textLabel3.setText(String.format("Number of Asteroids:%d",Asnum));
	    	}
	    });
	    buttonn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (Asnum>0){
	    		Asnum--;}
	    		textLabel3.setText(String.format("Number of Asteroids:%d",Asnum));
	    	}
	    	});
	    
	    //game level event
	    
	    buttonp2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (Stlvl<9){
	    			Stlvl++;}
	    		textLabel4.setText(String.format("Starting Level:%d",Stlvl));
	    	}
	    });
	    buttonn2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (Stlvl>1){
	    			Stlvl--;}
	    		textLabel4.setText(String.format("Starting Level:%d",Stlvl));
	    	}
	    	});
	    
	    
	    //Gravitional object Visible event
	    
	    button3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		visiblef=!visiblef;
	    		if (visiblef){
	               button3.setText("visible");    			
	    		}else{
	    			button3.setText("Not visible");
	    		}
	    		
	    	}
	    });
	    
	    //unlimited life event
	    button4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		Limitedf=!Limitedf;
	    		if (Limitedf){
	               button4.setText("No");    			
	    		}else{
	    			button4.setText("Yes");
	    		}
	    		
	    	}
	    });
	
	
	   // Font font = new Font("Jokerman",Font.PLAIN,35);
	
	   // textLabel.setPreferredSize(new Dimension(300,100));
	
	  //  textLabel.setFont(font);
	   
	}
	public void turnOn(){
		app.setSize(450,380);
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		app.setLocation(380,200);
	}
	
	public void updateScore(int score, String name){
		textLabel.setText(String.format("Highest Score: %d by %s",score,name));
	}
	
	}
