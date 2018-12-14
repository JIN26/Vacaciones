package Utils;

import Ventanas.Ventana1;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

public class ManejoSonido{
    AudioClip sonido, sonido2; 
    private static ManejoSonido instance = null; 
   /**Constructor de Musica*/
    public ManejoSonido(){
      sonido = java.applet.Applet.newAudioClip(getClass().getResource("Sonido/Fondo_1.wav"));
      sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("Sonido/Fondo_2.wav"));
    }
    public static ManejoSonido getInstance(){
        if(instance==null)
          instance = new ManejoSonido();

        return instance;
    
    }
    
    public void songFondo() {
        sonido.play();
    }
    public void songStop(){
        sonido.stop();
    }

    public void songFondo2(){
        sonido2.play();
    }
    public void songStop2(){
        sonido2.stop();
    }
}

