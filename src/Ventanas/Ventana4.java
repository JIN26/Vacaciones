/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Datos.Idioma;
import Datos.Usuarios;
import Utils.ImageLoader;
import Utils.Title;
import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Usuario
 */
public class Ventana4 extends Ventana{
    private static Ventana4 instance = null;  
    
    public Ventana4(){
        super();
        this.setLayout(null);    
        estilo();
        initUI();  
    }
    
    public static Ventana4 getInstance(){
        if(instance==null)
          instance = new Ventana4();

        return instance;
    
    }      
    
    private void initUI() {
       crearLabel();
       crearList();
       crearReturn();
       
    }
    
    private void crearLabel() {
        JLabel etiqueta = new JLabel (getPalabras(7),SwingConstants.CENTER);
        etiqueta.setBounds(50,180,400, 60); 
        etiqueta.setForeground(Color.DARK_GRAY);
        etiqueta.setFont(new Font("Gretoon Highlight",3,35));
        add(etiqueta);
    }
    
    private void crearList() {
        
        Usuarios usu = new Usuarios("src/Datos/Archivos/Usuario.txt");
        int [] ins = new int[usu.ultimo()];
        
        for (int i = 0; i < ins.length; i++) {
            usu.setCantidad(i);
            try {
                usu.leer();
            } catch (IOException ex) {
                Logger.getLogger(Ventana4.class.getName()).log(Level.SEVERE, null, ex);
            }
            ins[i] = usu.getPuntos(); 
        }
        
        for(int i=0,aux=0; i<ins.length; i++) {
            for(int j=i; j<ins.length; j++) {
                    if(ins[i]<ins[j]) {//para cambiar de menor a mayor solo cambia el signo a >
                            aux=ins[i];
                            ins[i]=ins[j];
                            ins[j]=aux;
                    }
            }
        }
        
        String []top =new String [usu.ultimo()];
        
        for (int i = 0; i < ins.length; i++) {
            for (int j = 0; j < ins.length; j++) {
                usu.setCantidad(j);
                try {
                    usu.leer();
                } catch (IOException ex) {
                    Logger.getLogger(Ventana4.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(ins[i]==usu.getPuntos()){
                    top[i]=(i+1)+" "+usu.getNombre()+"   "+ins[i];
                }
            }
        }
        JList lis = new JList(top );
        lis.setVisibleRowCount( 10 );  //Tamaño de la lista. Items a visualizar       
        JScrollPane marco =new JScrollPane(lis);
        marco.setBounds(50, 240, 400, 100);
        lis.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        add(marco);
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
                Ventana4.getInstance().setVisible(false);
            }
        });
        add(retur);
    }
}
