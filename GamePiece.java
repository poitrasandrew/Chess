/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Drew
 */
public abstract class GamePiece {
    Position position = new Position(-1,-1);
    public String name;
    boolean enPassant = false;
    boolean changeType = false;
    //int moveX;//possibly not needed
    //int moveY;//possibly not needed
    //boolean canAttack;//not needed
    boolean isWhite;
    boolean inPlay = true;
    
    public boolean isInPlay(){
        return inPlay;
    }
    void move(Position p){
        position = p;
    }
    //kill piece
    void killed(){
        inPlay = false;
    }
    //return false for illegal moves and true for legal moves/attacks
    abstract boolean possibleMoves(GamePiece[] pieces, Position p);
}
