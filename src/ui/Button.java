/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author armiixteryx
 */
public class Button extends JLabel {
    
    int id;
    protected boolean entered;
    private int value;
    protected int xPos;
    protected int yPos;
    private boolean marked;

    public Button(String imgPath, int value, int xPos, int yPos) {
        super(new ImageIcon(imgPath));
        //super(imgPath);
        
        this.value = value;
        
        this.xPos = xPos;
        this.yPos = yPos;
        
        marked = false;
        
        setSize(50, 50);
        
        id = (int) (Math.random() * 1000);
        
        //setBorder(BorderFactory.createLineBorder(Color.yellow, 2, true));
        
        /*
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                entered = true;
                //System.out.println("mouseEntered: " + id);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                entered = false;
                //System.out.println("mouseExited: " + id);
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                //System.out.println("IN: " + id);
                System.out.println(me.getSource());
            }
            
        });
*/
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
    
    public boolean getMarked() {
        return marked;
    }
    
}