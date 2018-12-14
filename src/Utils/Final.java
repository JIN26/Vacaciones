/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author XJINX
 */
public class Final extends JFrame{
    private static Final instance = null;
    
    private Final() throws IOException{
        super( "Juego 2248" );
        initUI();        
    }
    
     private void initUI() throws IOException {
        
        this.setUndecorated(true);
        this.pack();
        this.setSize(WIN_WIDTH,WIN_HEIGHT);
        setResizable(false);     
        setLocationRelativeTo(null);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
              System.out.println("X= "+e.getX()+" Y= "+e.getY());
            }
        });
    }
    
    public static Final getInstance() throws IOException{
        if(instance==null){
            instance = new Final();
            instance.initComponents();
            instance.defineEvents();
        }
        return instance;
    }
    
    private void initComponents() throws IOException {
        this.getContentPane().add(FondoPanel.getInstance());
    }
    
     private void defineEvents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //addWindowListener(new WindowsEvents());
        //addKeyListener(new KeyEvents());
    }
}
