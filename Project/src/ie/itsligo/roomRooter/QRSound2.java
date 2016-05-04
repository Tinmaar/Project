package ie.itsligo.roomRooter;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QRSound2 {
		
	public static void main(char args) {
		
		playit(args);
		delayfor(7);	// delay for 7 seconds

	}
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        URL location = QRSound2.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case 'A':
			fn = location.getFile() + "../src/ressources/A.wav"; //a block
			break;
		case 'B':
			fn = location.getFile() + "../src/ressources/Science.wav"; //b block
			break;
		case 'C':
			fn = location.getFile() + "../src/ressources/Business.wav"; // c block
			break;
		case 'E':
			fn = location.getFile() + "../src/ressources/engineering.wav"; // e block
			break;
		case 'F':
			fn = location.getFile() + "../src/ressources/F_Block.wav"; //f block
			break;
		case '0':
			fn = location.getFile() + "../src/ressources/0.wav"; // floor 0
			break;
		case '2':
			fn = location.getFile() + "../src/ressources/floor2.wav"; //floor 2
			break;
		case '4':
			fn = location.getFile() + "../src/ressources/4.wav"; //room 4
			break;
		case 'N':
			fn = location.getFile() + "../src/ressources/N.wav"; //lesson not today
			break;
		case 'Y':
			fn = location.getFile() + "../src/ressources/Y.wav"; //lesson today
			break;
		case '9':
			fn = location.getFile() + "../src/ressources/9.wav"; // lesson starts at 9
			break;
		case 's':
			fn = location.getFile() + "../src/ressources/s.wav"; //super late 1H +
			break;
		case 'l':
			fn = location.getFile() + "../src/ressources/l.wav"; //lesson is over
			break;
		case 'm':
			fn = location.getFile() + "../src/ressources/m.wav"; //late
			break;
		case 'r':
			fn = location.getFile() + "../src/ressources/R.wav"; // room on the right
			break;
		case 'w':
			fn = location.getFile() + "../src/ressources/w.wav"; //wrong qr code type 1
			break;
		case 'z':
			fn = location.getFile() + "../src/ressources/z.wav"; //wrong qr code type 2
			break;
		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
