/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author david.camperos
 */
public class GameEngine {
     private Numbers numbers;
    
    private int startLine;
    private int endLine;
    private int sumLine;
    private int actualXPos;
    private int actualYPos;
    private int endXPos;
    private int endYPos;
    
    //private boolean isFirstEntry;
    
    public final int GAMEROWS = 6;
    public final int GAMECOLS = 8;
    public final int START_POWER_OF_TWO = 6;

    public GameEngine() {
        numbers = new Numbers(GAMEROWS, GAMECOLS);
        sumLine = 0;
        actualXPos = actualYPos = 0;
        endXPos = endYPos = 0;
        
        //isFirstEntry = false;
        
        fillNumbers(START_POWER_OF_TWO);
        
    }
    
    private void fillNumbers(int powerOfTwo) {
        for (int i = 0; i < numbers.getRowLength(); i++) {
            for (int j = 0; j < numbers.getColsLength(); j++) {
                numbers.setBoardPosition(i, j, generateRandom(powerOfTwo));
            }
        }
    }

    public Numbers getNumbers() {
        return numbers;
    }
    
    public int getActualXPos() {
        return actualXPos;
    }

    public int getActualYPos() {
        return actualYPos;
    }
    
    public int getSumLine() {
        return sumLine;
    }
    
    public static int generateRandom(int lim) {
        return (int) (Math.pow(2, (int) ( Math.random() * lim ) + 1));
    }
    
    public static int checkCloserBase(int toCheck) {
        double base = 2;
        return (int) (Math.log10(toCheck) / Math.log10(base));
    }
    
    public void saveStartLine(int x, int y) {
        actualXPos = x;
        actualYPos = y;
        startLine = numbers.getBoardPosition(x, y);
    }
    
    public void saveEndLine(int x, int y, boolean firstEntry) {
        if(startLine != 0) {
            endXPos = x;
            endYPos = y;
            endLine = numbers.getBoardPosition(x, y);
            
            doMaths(firstEntry);
        }
    }
    
    public void doMaths(boolean firstEntry) {
        if(firstEntry) {
            sumLine += startLine + endLine;
        } else {
            sumLine += endLine;
        }
        System.out.println("sumLine: " + sumLine + ", startLine: " + startLine + ", endline: " + endLine);
        
        
        startLine = endLine;
        actualXPos = endXPos;
        actualYPos = endYPos;
        endLine = endXPos = endYPos = 0;
        
        System.out.println("sumLine: " + sumLine);
        
    }
    
    public boolean isThereStartLine() {
        return startLine != 0;
    }
    
    public void resetOnRelease() {
        startLine = 0;
        endLine = 0;
        sumLine = 0;
        actualXPos = actualYPos = 0;
        endXPos = endYPos = 0;
    }
    
    private void resetSum() {
        sumLine = 0;
    }
    
    public void updateNumber(int x, int y, int value) {
        numbers.setBoardPosition(x, y, value);
    }

}
