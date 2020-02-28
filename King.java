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
public class King extends GamePiece {
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            if ((p.getX() == position.getX() + 1 && p.getY() == position.getY() + 1)
             || (p.getX() == position.getX() + 1 && p.getY() == position.getY())
             || (p.getX() == position.getX() + 1 && p.getY() == position.getY() - 1)
             || (p.getX() == position.getX() && p.getY() == position.getY() + 1)
             || (p.getX() == position.getX() && p.getY() == position.getY() - 1)
             || (p.getX() == position.getX() - 1 && p.getY() == position.getY() + 1)
             || (p.getX() == position.getX() - 1 && p.getY() == position.getY())
             || (p.getX() == position.getX() - 1 && p.getY() == position.getY() - 1)){
                for (int i = 0; i < pieces.length; i++){
                    if (p.getX() == pieces[i].position.getX() && p.getY() == pieces[i].position.getY() && pieces[i].inPlay){
                        if (isWhite != pieces[i].isWhite){
                            pieces[i].killed();
                            return true;
                        }
                        if (isWhite == pieces[i].isWhite){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
