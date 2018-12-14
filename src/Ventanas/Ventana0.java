/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Utils.FondoPanel;
import Utils.ImageLoader;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author XJINX
 */
public class Ventana0 extends Ventana{
    
    private static Ventana0  [] instance = null; 
    
    private static JLabel [] etiqueta0;
     
    private static JLabel retur;
    
    private static Graphics g;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Ventana0(){
        super();
        initUI();
     
            g=this.getGraphics();
        
        instance[0].paint(g);
    }
    
    public static  Ventana0[] getInstance(){
        if(instance==null){  
            instance = new Ventana0[6];
            
            for (int i = 0; i < instance.length; i++) {
              
              instance[i] = new Ventana0();
              instance[i].addTotal(i);
            }
        }
          
        return instance;
    
    }
    
    public static Ventana0 getInstance(int num){
        if(instance[num]==null){    
              instance[num] = new Ventana0();
              instance[num].addTotal(num);
        }
          
        return instance[num];
    }
 
    private void initUI() {
        crearLabel();  
        crearReturn();
    }
    
    private void crearLabel() { 
        etiqueta0 = new JLabel[6];

        for (int i = 0,j=0; i < etiqueta0.length; i++,j+=60) { 
            etiqueta0[i] = new JLabel ();
            etiqueta0[i].setBounds(150,180+j,200, 50);
            etiqueta0[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){

                    for (int i = 0; i < 6; i++) {

                        if (e.getSource() == etiqueta0[i]){

                            Ventana0.getInstance(0).setVisible(false);                                                    
                            switch(i){

                                case 0:      
                                        Ventana1.getInstance().setVisible(true);  
                                    break;
                                case 1:
                                        Ventana3.getInstance().setVisible(true);  
                                    break;
                                case 2:
                                        Ventana4.getInstance().setVisible(true);  
                                    break;
                                case 3:
                                        Ventana5.getInstance().setVisible(true);  
                                    break;
                                case 4:
                                        Ventana6.getInstance().setVisible(true);  
                                    break;
                                case 5:
                                        System.exit(0);
                                    break;
                            }
                            setPosicion(i+1);
                        }
                    }
                }    
            });
        }
    }
    
    private void crearReturn() {
        retur =new JLabel();

        retur.setBounds(0,600,50, 50);
        retur.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){               
                Ventana0.getInstance(0).setVisible(false);
                setPosicion(0);
                Ventana0.getInstance(0).setVisible(true);
            }
        });
    }
    
    private void addTotal(int num){      
        for (JLabel etiqueta01 : etiqueta0) {
            instance[num].add(etiqueta01);
        }
        instance[num].add(retur); 
    }
}
    
//    @Override
//    public void paint(Graphics g){
//        ImageIcon foto,image = null;
//        for (int i = 0; i < etiqueta0.length; i++) {
//            foto = ImageLoader.getInstance().getVentana(i+1);
//            image= new ImageIcon(foto.getImage().getScaledInstance(etiqueta0[i].getWidth(),etiqueta0[i].getHeight(), Image.SCALE_SMOOTH));
//            etiqueta0[i]. setIcon(image);  
//           // g.drawImage(image.getImage(), 10, 10,etiqueta0[i].getWidth(),etiqueta0[i].getHeight(),null);
//        }
//
//        foto = ImageLoader.getInstance().getVentana(6);
//        image= new ImageIcon(foto.getImage().getScaledInstance(retur.getWidth(),retur.getHeight(), Image.SCALE_SMOOTH));
//        retur.setIcon(image);     
//        
//        
//        super.paint(g);
//        
//    }    
//}
