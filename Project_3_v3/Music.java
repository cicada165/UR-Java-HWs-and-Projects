/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
//BGM! Why not
//Credit:
//http://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
public class Music {
	    // size of the byte buffer used to read/write the audio stream
	    private static final int BUFFER_SIZE = 4096;
	    int bytesRead = -1;
	     
	    public void play() {
	        File bgm = new File("Fendiman.wav");
	        try {
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bgm);
	            AudioFormat format = audioStream.getFormat();
	            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format); 
	            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);
	            audioLine.open(format);	 
	            audioLine.start();                          
	            byte[] bytesBuffer = new byte[BUFFER_SIZE]; 
	            while ((bytesRead = audioStream.read(bytesBuffer)) != -1) {
	                audioLine.write(bytesBuffer, 0, bytesRead);
	            }            
	            audioLine.drain();
	            audioLine.close();
	            audioStream.close();             
	        } catch (UnsupportedAudioFileException ex) {
	            System.out.println("Audio file is not supported.");
	            ex.printStackTrace();
	        } catch (LineUnavailableException ex) {
	            System.out.println("Audio Line not found");
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            System.out.println("Error playing the audio file.");
	            ex.printStackTrace();
	        }      
	    }
	    
	    void stop(){
	    	setBytesRead(-1);
	    }

		public int getBytesRead() {
			return bytesRead;
		}

		public void setBytesRead(int bytesRead) {
			this.bytesRead = bytesRead;
		}

	

}
