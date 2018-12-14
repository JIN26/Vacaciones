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
 * @author XJINX
 */
public class Ventana3 extends Ventana{
    private static Ventana3 instance = null; 
    Timer timer;
    JLabel base;
    int actual = 0;
    
    public Ventana3(){
        super();
        this.setLayout(null);      
        estilo();
        initUI();  
    }
    
    public static Ventana3 getInstance(){
        if(instance==null)
          instance = new Ventana3();

        return instance;
    
    }  
       
    private void initUI() {
        crearLabel();
        crearList();
        crearReturn();      
        crearTime();
    }

    private void crearLabel() {
        JLabel etiqueta = new JLabel (getPalabras(6),SwingConstants.CENTER);
        etiqueta.setBounds(50,180,400, 60); 
        etiqueta.setForeground(Color.DARK_GRAY);
        etiqueta.setFont(new Font("Gretoon Highlight",3,35));
        add(etiqueta);
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
                Ventana3.getInstance().setVisible(false);
            }
        });
        add(retur);
    }

    private void crearList() {
        String [] ins = new String[6];
        for (int i = 0; i < ins.length; i++) {
            ins[i] = getPalabras(i+10);
        }
        JList lis = new JList(ins  );
        lis.setVisibleRowCount( 5 );  //Tamaño de la lista. Items a visualizar       
        JScrollPane marco =new JScrollPane(lis);
        marco.setBounds(50, 240, 400, 100);
        lis.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        add(marco);
    }

    private void crearTime() {
        
        base = new JLabel(ImageLoader.getInstance().getCosas(1)) ;
        base.setBounds(130, 370, 250, 250);
        add(base).setVisible(true);
        
        timer = new Timer(1000, (ActionEvent ae) -> {

            if(actual==3){
                actual=0;
            }

            ImageIcon nextImage = ImageLoader.getInstance().getCosas(actual);
            ImageIcon image= new ImageIcon(nextImage.getImage().getScaledInstance(base.getWidth(),base.getHeight(), Image.SCALE_SMOOTH));
            base.setIcon(image);

            actual++;
        });
        timer.start();
    }
}
