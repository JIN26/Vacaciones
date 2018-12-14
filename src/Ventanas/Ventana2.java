/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Datos.Usuarios;
import Utils.ImageLoader;
import Utils.ManejoSonido;
import Utils.Title;
import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ui.Game;

/**
 *
 * @author Usuario
 */
public class Ventana2 extends JPanel{
    private static Ventana2 instance = null; 
    private static String nombre;
    private static int puntos,time;
    
    
    public Ventana2(){
        super();
        this.setLayout(null);  
        initUI();  
    }
    
    public static Ventana2 getInstance(){
        if(instance==null)
          instance = new Ventana2();

        return instance;
    
    }
        
     private void initUI() {
        this.add(Game.getInstance());
        crearReturn(); 
    }
     
 
     
    private void crearReturn() {
         JLabel retur =new JLabel();

        retur.setBounds(0,550,100, 100);
        ImageIcon foto = ImageLoader.getInstance().getVentana(6);
        ImageIcon image= new ImageIcon(foto.getImage().getScaledInstance(retur.getWidth(),retur.getHeight(), Image.SCALE_SMOOTH));
        retur.setIcon(image);
        retur.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){ 
                ManejoSonido.getInstance().songStop();
                ManejoSonido.getInstance().songStop2();
                Ventana1.getInstance().setVisible(true);
                Ventana2.getInstance().setVisible(false);
                Game.getInstance().setVisible(false);
            }
        });
        add(retur);
    }
    
    private void guardarDatos(){
        try {
            Usuarios carga = new Usuarios("src/Datos/Archivos/Usuario.txt");
            carga.escribir(nombre+" "+puntos+" "+time);
        } catch (IOException ex) {
            Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void paint(Graphics g){
        
        Title.getInstance().setLocation(0, 0);
        this.add(Title.getInstance()).setVisible(true);
        this.setBounds(0,0, WIN_WIDTH, WIN_HEIGHT);
        setOpaque(false);
        super.paint(g);
    }    

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Ventana2.nombre = nombre;
    }  

    public static int getPuntos() {
        return puntos;
    }

    public static void setPuntos(int puntos) {
        Ventana2.puntos = puntos;
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        Ventana2.time = time;
    }
     
}
