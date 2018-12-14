package Utils;

import java.net.URL;
import javax.swing.ImageIcon;

public class ImageLoader {
    private static ImageLoader instance=null;

    private static final int MAX_VENTANA=7;
    public static final int MAX_PERSONAJE=21;
    public static final int MAX_BURBUJAS=12;
    public static final int MAX_COSAS=3;

    @SuppressWarnings("FieldMayBeFinal")
    private ImageIcon ventana[];
    @SuppressWarnings("FieldMayBeFinal")
    private ImageIcon cosas[];
    private ImageIcon personaje[];
    private ImageIcon letras[];
    private ImageIcon burbujas[];
    
    public ImageLoader(){   

        ventana = new ImageIcon[MAX_VENTANA];
        URL url = this.getClass().getResource("Imagenes/ventana/1Fondo_0.png");
         ventana[0] = new ImageIcon(url);
        for(int i=1;i<MAX_VENTANA;i++){
            url = this.getClass().getResource("Imagenes/ventana/1Button_"+(i-1)+".png");
            ventana[i] = new ImageIcon(url);
        }
        
        cosas = new ImageIcon[MAX_COSAS];
        for(int i=0;i<MAX_COSAS;i++){
            url = this.getClass().getResource("Imagenes/Cosas/Ins_"+i+".png");
            cosas[i] = new ImageIcon(url);
        }
    }

    public static ImageLoader getInstance(){
        if(instance==null)
          instance = new ImageLoader();

        return instance;
    
    }
    
    public ImageLoader(String nombre,int tono){   

        ventana = new ImageIcon[MAX_VENTANA];
        URL url = this.getClass().getResource("Imagenes/ventana/"+tono+"Fondo_0.png");
         ventana[0] = new ImageIcon(url);
        for(int i=1;i<MAX_VENTANA;i++){
            url = this.getClass().getResource("Imagenes/ventana/"+tono+nombre+"_"+(i-1)+".png");
            ventana[i] = new ImageIcon(url);
        }
        
        cosas = new ImageIcon[MAX_COSAS];
        for(int i=0;i<MAX_COSAS;i++){
            url = this.getClass().getResource("Imagenes/Cosas/Ins_"+i+".png");
            cosas[i] = new ImageIcon(url);
        }
        
        personaje = new ImageIcon[MAX_PERSONAJE];
        for(int i=0;i<MAX_PERSONAJE;i++){
            url = this.getClass().getResource("Imagenes/Personaje/Image_"+(i+1)+".png");
            personaje[i] = new ImageIcon(url);
        }
        burbujas = new ImageIcon[MAX_BURBUJAS];
        for(int i=0;i<MAX_BURBUJAS;i++){
            url = this.getClass().getResource("Imagenes/Burbujas/"+(i+1)+".jpg");
            burbujas[i] = new ImageIcon(url);
        }
    }

    public static ImageLoader getInstance(String nombre,int tono){
        if(instance==null)
          instance = new ImageLoader(nombre,tono);

        return instance;
    
    }

    public ImageIcon getVentana(int imageId){
        if(imageId<0 || imageId>=MAX_VENTANA)
            return null;
        
        return ventana[imageId];
    }
    public ImageIcon getCosas(int imageId){
        if(imageId<0 || imageId>=MAX_COSAS)
            return null;
        
        return cosas[imageId];
    }
    public ImageIcon getPersonaje(int imageId){
        if(imageId<0 || imageId>=MAX_PERSONAJE)
            return null;
        
        return personaje[imageId];
    }
    public ImageIcon getBurbujas(int imageId){
        if(imageId<0 || imageId>=MAX_BURBUJAS)
            return null;
        
        return burbujas[imageId];
    }
    
    
}
