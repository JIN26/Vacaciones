/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Datos.Idioma;
import Utils.ImageLoader;
import Utils.Title;
import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Usuario
 */
public class Ventana6 extends Ventana{
    private static Ventana6 instance = null; 
    
    
    public Ventana6(){
        super();
        this.setLayout(null);    
        estilo();
        initUI();  
    }
    
    public static Ventana6 getInstance(){
        if(instance==null)
          instance = new Ventana6();

        return instance;
    
    }
        
     private void initUI() {
        crearLabel();
        crearReturn(); 
    }
     
    private void crearLabel() {
        JLabel etiqueta = new JLabel (getPalabras(9),SwingConstants.CENTER);
        etiqueta.setBounds(50,280,400, 60); 
        etiqueta.setForeground(Color.DARK_GRAY);
        etiqueta.setFont(new Font("Gretoon Highlight",3,35));
        add(etiqueta);
        
        JLabel etiqueta1 = new JLabel (getPalabras(23),SwingConstants.CENTER);
        etiqueta1.setBounds(0,380,250, 60); 
        etiqueta1.setForeground(Color.DARK_GRAY);
        etiqueta1.setFont(new Font("Gretoon Highlight",3,35));
        add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel (getPalabras(24),SwingConstants.CENTER);
        etiqueta2.setBounds(250,380,250, 60); 
        etiqueta2.setForeground(Color.DARK_GRAY);
        etiqueta2.setFont(new Font("Gretoon Highlight",3,35));
        add(etiqueta2);
        
        etiqueta1.addMouseListener(new MouseAdapter() { 
            public void mouseEntered(MouseEvent e){
                etiqueta1.setForeground(Color.RED);                      
            }
            public void mouseExited(MouseEvent e){
                etiqueta1.setForeground(Color.BLACK);

            }
            public void mousePressed(MouseEvent e) {
                setLenguaje(true);
            }
        });
        etiqueta2.addMouseListener(new MouseAdapter() { 
            public void mouseEntered(MouseEvent e){
                etiqueta2.setForeground(Color.RED);                      
            }
            public void mouseExited(MouseEvent e){
                etiqueta2.setForeground(Color.BLACK);

            }
            public void mousePressed(MouseEvent e) {
                setLenguaje(false);
            }
        });
    }
     
    private void crearReturn() {
         JLabel retur =new JLabel();

        retur.setBounds(0,550,100, 100);
        ImageIcon foto = ImageLoader.getInstance().getVentana(6);
        ImageIcon image= new ImageIcon(foto.getImage().getScaledInstance(retur.getWidth(),retur.getHeight(), Image.SCALE_SMOOTH));
        retur.setIcon(image);
        retur.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){               
                Ventana1.getInstance().setVisible(true);
                Ventana6.getInstance().setVisible(false);
            }
        });
        add(retur);
    }
     
}
