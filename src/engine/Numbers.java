/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author armiixteryx
 */
public class Numbers {
   private int board[][];

    public Numbers(int x, int y) {
        board = new int[x][y];
    }

    public void setBoardPosition(int x, int y, int number) {
        board[x][y] = number;
    }
    
    public int getBoardPosition(int x, int y) {
        return board[x][y];
    }
    
    public int getRowLength() {
        return board.length;
    }
    
    public int getColsLength() {
        return board[0].length; 
   }
    
}
