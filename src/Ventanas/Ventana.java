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
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class Ventana extends JPanel {
    private boolean lenguaje; 
    private static Idioma verificar;
    private String palabras[];
    private int posicion;
    private int dificultad;  
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Ventana(){
        Title.getInstance().setLocation(0, 0);  
        add(Title.getInstance().getTitle());
        setOpaque(false);
        this.setLayout(null);  
        
        dificultad=0;
        lenguaje=true;  
        posicion=1;
    }
    
    public void estilo() {        
        if(lenguaje==true){
            try {
                verificar = new Idioma("src/Datos/Archivos/English.txt");
                verificar.setCantidad(0);
                palabras=verificar.leer();
            } catch (IOException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                verificar = new Idioma("src/Datos/Archivos/Español.txt");
                verificar.setCantidad(0);
                palabras=verificar.leer();
            } catch (IOException ex) {
                Logger.getLogger(Ventana1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ImageLoader.getInstance(palabras[0],dificultad);   
    }

    public boolean isLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(boolean lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String[] getPalabras() {
        return palabras;
    }
    
    public String getPalabras(int posicion) {
        return palabras[posicion];
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    
  
    @Override
    public void paint(Graphics g){
        
        estilo();
        this.add(Title.getInstance()).setVisible(true);
        this.setBounds(0,0, WIN_WIDTH, WIN_HEIGHT);
        
        super.paint(g);
    }    
}
