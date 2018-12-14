/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author armiixteryx
 */
public class Title extends JPanel implements WinDimensions {
    final int PNL_WIDTH = WIN_WIDTH;
    final int PNL_HEIGHT = 20;
    private static Title instance=null;
    
    private JLabel Title;
    
    public Title() {
        initUI();
    }
    
    public static Title getInstance(){
        if(instance==null)
          instance = new Title();

        return instance;
    
    }
    
    private void initUI() {
        this.setLayout(null);
        
        this.setSize(PNL_WIDTH, PNL_HEIGHT);
        this.setBackground(Color.LIGHT_GRAY);
        
        JLabel Title = new JLabel("2248");
        
        Title.setForeground(Color.WHITE);
        Title.setSize(500, 20);
        Title.setLocation(5, 0);
        add(Title);
        
        JButton close;
        close = new JButton("X");
        close.setSize(42, 20);
        close.setLocation(PNL_WIDTH-42, 0);
        close.addActionListener((ActionEvent ae) -> System.exit(0));
        
        this.add(close);
        setVisible(true);
    }
    
    public JLabel getTitle(){
        JLabel Title = new JLabel("2248",SwingConstants.CENTER);
        Title.setForeground(Color.BLACK);
        Title.setBounds(100,70,300, 80);
        Title.setFont(new Font("Gretoon Highlight",3,70));
        return Title;
    }
    
}
