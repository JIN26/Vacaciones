/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.WinDimensions.*;
import Ventanas.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ui.Game;

/**
 *
 * @author angel.mantilla
 */
public class FondoPanel extends JPanel{ 
    
    private static FondoPanel instance = null; 
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public FondoPanel(){
        //Inicio
        Ventana0.getInstance();
        this.add(Ventana0.getInstance(0)).setVisible(true);
        this.add(Ventana1.getInstance()).setVisible(false);
        this.add(Ventana3.getInstance()).setVisible(false);
        this.add(Ventana4.getInstance()).setVisible(false);
        this.add(Ventana5.getInstance()).setVisible(false);
        this.add(Ventana6.getInstance()).setVisible(false);
        this.add(Ventana2.getInstance()).setVisible(false);
        this.add(Game.getInstance()).setVisible(false);
        setOpaque(false);
    }
    
    public static FondoPanel getInstance() throws IOException{
        if(instance==null){
            instance = new FondoPanel();
        }
        return instance;
    }
    
    @Override
    public void paint(Graphics g){
        this.setBounds(0,0, WIN_WIDTH, WIN_HEIGHT);        
        ImageIcon foto = ImageLoader.getInstance().getVentana(0);
        Image image= new ImageIcon(foto.getImage().getScaledInstance(getWidth(),getHeight(), Image.SCALE_SMOOTH)).getImage();
        g.drawImage(image, 0, 20, getWidth(), getHeight()-20, this);
       
        
        super.paint(g);
    }    
    
}