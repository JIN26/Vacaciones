/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Datos.Idioma;
import Utils.Final;
import Utils.FondoPanel;
import Utils.ImageLoader;
import Utils.ManejoSonido;
import Utils.Title;
import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import ui.Game;

/**
 *
 * @author XJINX
 */
public class Ventana1 extends Ventana{
    
    private static Ventana1 instance = null; 
    
    private static JTextField textfield1;
    private static JLabel [] etiqueta1;
    
    public Ventana1(){
        super();     
        this.setLayout(null);     
        estilo();
        initUI();  
    }
    
    public static Ventana1 getInstance(){
        if(instance==null)
          instance = new Ventana1();

        return instance;
    
    }
    private void initUI() { 
        creartext();
        crearLabel();    
    }
    
    private void crearLabel() { 
       etiqueta1 = new JLabel[6];

        for (int i = 0,j=0,j2=0; i < 6; i++,j+=200) { 
            etiqueta1[i] = new JLabel ();
            if(i<2){
                etiqueta1[i].setBounds(50,180+j,400, 60);      
                etiqueta1[i].setFont(new Font("Gretoon Highlight",3,25));
                etiqueta1[i].setHorizontalTextPosition(SwingConstants.CENTER);
            }else{
                if(i<5){
                    etiqueta1[i].setBounds(10+j2,480,210, 60);
                    etiqueta1[i].setForeground(Color.BLACK);
                    etiqueta1[i].setFont(new Font("Gretoon Highlight",3,25));
                    etiqueta1[i].setHorizontalTextPosition(SwingConstants.CENTER);
                    j2+=130;
                }else{                            
                    etiqueta1[i].setBounds(150,480+j2-300,210, 60);
                }
            }    
            add(etiqueta1[i]);

            etiqueta1[i].addMouseListener(new MouseAdapter() { 
                    @Override
                    public void mouseEntered(MouseEvent e){
                        for (int i = 2; i < 5; i++) {
                            if (e.getSource() == etiqueta1[i]){
                                etiqueta1[i].setForeground(Color.RED);
                            }

                        }
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        for (int i = 2; i < 5; i++) {
                            if (e.getSource() == etiqueta1[i]){
                                etiqueta1[i].setForeground(Color.BLACK);
                            }

                        }
                    }

                @Override
                public void mousePressed(MouseEvent e) {
                    for (int i = 2; i < 5; i++) {
                        if (e.getSource() == etiqueta1[i]){
                            setDificultad(1);
                            setLenguaje(true);
//                                Ventana0.getInstance().revalidate();
//                                Ventana0.getInstance().repaint();
                            estilo();
                        }

                    }
                   if (e.getSource() == etiqueta1[5]){
                        String n = textfield1.getText();
                        if( n.length()<8){    
                            if(n.length()>1){
                                JOptionPane.showMessageDialog( null, "Nombre: " + n );   
                                Ventana2.setNombre(n);
                            }                  
                        }else{
                            textfield1.setText(" ");
                        }
                        Ventana1.getInstance().setVisible(false);
                        int x = (int) (Math.random()*2);
                        if(x==1){
                            ManejoSonido.getInstance().songFondo();
                        }else{
                            ManejoSonido.getInstance().songFondo2();
                        }

                        Ventana2.getInstance().setVisible(true);  
                        Game.getInstance().setVisible(true);
                   }
                }
            });
        } 
    }
    
    private void creartext() {     
        textfield1 = new JTextField();
        textfield1.setBounds(100,250,300, 40);      
        
        textfield1.addActionListener((ActionEvent event) -> {
            String n = textfield1.getText();
            if( n.length()<8){
                if(n.length()>1){
                    JOptionPane.showMessageDialog( null, "Nombre: " + n );
                    Ventana2.setNombre(n);
                }
            }else{
                textfield1.setText(" ");
            }
            Ventana1.getInstance().setVisible(false);
            int x1 = (int) (Math.random()*2);
            if (x1 == 1) {
                ManejoSonido.getInstance().songFondo();
            } else {
                ManejoSonido.getInstance().songFondo2();
            }
            Ventana2.getInstance().setVisible(true);
            Game.getInstance().setVisible(true);
        }); 
       
    }
    
    public void paint(Graphics g){
        
        ImageIcon foto,image;
        System.out.println(getPosicion());
                      
        for (int i = 0; i <etiqueta1.length-1; i++) {                    
            etiqueta1[i].setText(getPalabras(i+1));
        }
        
        foto = ImageLoader.getInstance().getVentana(1);
        image= new ImageIcon(foto.getImage().getScaledInstance(etiqueta1[5].getWidth(),etiqueta1[5].getHeight(), Image.SCALE_SMOOTH));
        etiqueta1[5].setIcon(image);
        
        super.paint(g);
    }        
}
