import java.io.*;
import java.net.URL;

import javax.sound.sampled.*;

public class Sound {
	
	private Clip clip;
    
	public Sound(String filename){
		try{
		File soundFile = new File(filename);
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	    clip = AudioSystem.getClip();
		clip.open(audioIn);
		}
     catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     } catch (LineUnavailableException e) {
        e.printStackTrace();
     }
	}
	public void play(){
		clip.setFramePosition(0);
		clip.start();	
	}
	public void playforever(){
		//clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);	
	}
	public void end(){
		clip.stop();
	}

	
}