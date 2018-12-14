/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Utils.Title;
import static Utils.WinDimensions.WIN_HEIGHT;
import static Utils.WinDimensions.WIN_WIDTH;
import Ventanas.Ventana0;
import engine.GameEngine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author armiixteryx
 */
public class Game extends JPanel {
    private static Game instance = null; 
    Button[][] button;
    Button[] markedButtons;
    Button actualButton;
    int markedButtonsIdx;
    
    int id;
    
    GameEngine ge;
    boolean creatingLine;
    ButtonsMouseAdapter btnMouseAdapter;
    
    boolean evtPressed;
    
    public static Game getInstance(){
        if(instance==null)
          instance = new Game();

        return instance;
    
    }
    
    public Game() {
        
        ge = new GameEngine();
        creatingLine = false;
        
        int rows = ge.getNumbers().getRowLength();
        int cols = ge.getNumbers().getColsLength();
        
        button = new Button [rows][cols];
        markedButtons = new Button[rows*cols];
        markedButtonsIdx = 0;
        btnMouseAdapter = new ButtonsMouseAdapter();
        
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[0].length; j++) {
                int value = ge.getNumbers().getBoardPosition(i, j);
                final String IMGPATH = "src/assets/buttons/button-";
                //final String IMGEXT = ".png";
                final String IMGEXT = ".jpg";
                
                button[i][j] = new Button(IMGPATH + value + IMGEXT, value, i, j);
                button[i][j].addMouseListener(btnMouseAdapter);
            }
        }
        
        id = (int) (Math.random() * 500);
        
        evtPressed = false;
        
        initUI();
    }
    
    private void initUI() {
        
        setLayout(null);
        
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button[0].length; j++) {
                final int xGap = 10;
                final int yGap = 18;
                button[i][j].setLocation((i * 66) + xGap, (j * 66) + yGap);
                add(button[i][j]);
            }
        }
        
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5, true));
        
        setVisible(true);
    }
    
    class ButtonsMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent me) {
            evtPressed = true;
            
            Button object = (Button) me.getSource();
            
            locateSphere(object);
            
            object.setMarked(true);
            System.out.println(object.getMarked());
            markedButtons[markedButtonsIdx] = object;
            manageMarkedButtons(false);
            System.out.println("valueBtn: " + object.getValue());
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if(creatingLine) {
                
                int actualBtnXPos = ge.getActualXPos(); //NOT IN SCREEN XY BUT
                int actualBtnYPos = ge.getActualYPos(); //ACTUAL MATRIX POSITION
                
                int newBtnXPos;
                int newBtnYPos;
                
                Button object;
                
                if(me.getSource() instanceof Button) {
                    object = (Button) me.getSource();
                    newBtnXPos = object.getxPos();
                    newBtnYPos = object.getyPos();
                    boolean firstEntry = (markedButtonsIdx == 1);
                    
                    int i = -1, j = -1;
                    
                    while(i >= -1 && i <= 1) {
                        if(actualBtnXPos + i == newBtnXPos) {
                            while(j >= -1 && j <= 1) {
                                if(actualBtnYPos + j == newBtnYPos) {
                                    if(i == 0 && j == 0) {
                                        //System.out.println("CENTER");
                                        //DO NOTHING
                                    } else {
                                        
                                        actualButton = button[actualBtnXPos][actualBtnYPos];
                                        int actualValue = actualButton.getValue(); //FIRST
                                        int toCheckValue = object.getValue(); //OBJETIVE
                                        
                                        System.out.println("i: " + object.getxPos() + ", j: " + object.getyPos());
                                        System.out.println("actualValue: " + actualValue + ", toCheckValue: " + toCheckValue);
                                        
                                        if(actualValue == toCheckValue) {
                                            System.out.println(actualButton.getMarked());
                                            if(!object.getMarked()) {
                                                
                                                ge.saveEndLine(newBtnXPos, newBtnYPos, firstEntry);
                                                object.setMarked(true);
                                                markedButtons[markedButtonsIdx] = object;
                                                manageMarkedButtons(false);
                                            }
                                        } else if(!firstEntry) {
                                            if(actualValue * 2 == toCheckValue && ge.getSumLine() >= toCheckValue) {
                                                if(!object.getMarked()) {
                                                    ge.saveEndLine(newBtnXPos, newBtnYPos, firstEntry);
                                                    object.setMarked(true);
                                                    markedButtons[markedButtonsIdx] = object;
                                                    manageMarkedButtons(false);
                                                }
                                            }
                                        }
                                    }
                                }
                                j++;
                            }
                        }
                        i++;
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            Button t = (Button) me.getSource();
            if(t != actualButton) {
                //ADD TO TOTALPOINTS
                creatingLine = false;

                int btnValue = GameEngine.checkCloserBase(ge.getSumLine());

                int btnXPos = t.getxPos();
                int btnYPos = t.getyPos();
                
                int scrXPos = t.getX();
                int scrYPos = t.getY();

                button[btnXPos][btnYPos].removeMouseListener(btnMouseAdapter);
                remove(button[btnXPos][btnYPos]);
                button[btnXPos][btnYPos] = null;

                ge.updateNumber(btnXPos, btnYPos, btnValue);
                updateButton(btnValue, btnXPos, btnYPos, scrXPos, scrYPos);

                for (int i = 0; i < markedButtonsIdx; i++) {
                    markedButtons[i].setMarked(false);
                }

                manageMarkedButtons(true);

                ge.resetOnRelease();

                repaint();
            }
        }
    }
    
    void locateSphere(Button object) {
        boolean stopSearch = false;
        int i = 0;
        int j = 0;
            
        for (i = 0; i < button.length; i++) {
            for (j = 0; j < button[0].length; j++) {
                if(object == button[i][j]) {
                    creatingLine = true;
                    stopSearch = true;
                    break;
                }
            }
            if(stopSearch) break;
        }
        System.out.println("i: " + i + " j: " + j);
        ge.saveStartLine(i, j);
    }
    
    void manageMarkedButtons(boolean reset) {
        if(reset || markedButtonsIdx == markedButtons.length) {
            markedButtonsIdx = 0;
            markedButtons = new Button[ge.getNumbers().getRowLength() * ge.getNumbers().getColsLength()];
        } else {
            markedButtonsIdx++;
        }
    }
    
    void updateButton(int value, int xPos, int yPos, int scrXPos, int scrYPos) {
        final String IMGPATH = "src/assets/buttons/button-";
        //final String IMGEXT = ".png";
        final String IMGEXT = ".jpg";
        
        button[xPos][yPos] = new Button(IMGPATH + value + IMGEXT, value, xPos, yPos);
        button[xPos][yPos].setLocation(scrXPos, scrYPos);
        add(button[xPos][yPos]);
        button[xPos][yPos].addMouseListener(btnMouseAdapter);
        
    }
    public void paint(Graphics g){
        this.setBounds(500 / 9, 700 / 18, 400, 550);
//        Title.getInstance().setLocation(0, 0);
//        this.add(Title.getInstance()).setVisible(true);
        setOpaque(false);
        super.paint(g);
    }    
}
