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
public class Rook extends GamePiece {
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            if (p.getX() == position.getX() && p.getY() != position.getY()){
                for (int i = 0; i < pieces.length; i++){
                    //check if pieces are in between the old and new positions
                    if (((pieces[i].position.getY() > p.getY() && pieces[i].position.getY() < position.getY()) || (pieces[i].position.getY() < p.getY() && pieces[i].position.getY() > position.getY())) && pieces[i].inPlay && pieces[i].position.getX() == position.getX()){
                        return false;
                    }
                }
                for (int i = 0; i < pieces.length; i++){
                    if (pieces[i].position.getX() == p.getX() && pieces[i].position.getY() == p.getY() && pieces[i].inPlay){
                        if (pieces[i].isWhite != isWhite){
                            pieces[i].killed();
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
                return true;
            }
            else if (p.getX() != position.getX() && p.getY() == position.getY()){
                for (int i = 0; i < pieces.length; i++){
                    //check if pieces are in between the old and new positions
                    if (((pieces[i].position.getX() > p.getX() && pieces[i].position.getX() < position.getX()) || (pieces[i].position.getX() < p.getX() && pieces[i].position.getX() > position.getX())) && pieces[i].inPlay && pieces[i].position.getY() == position.getY()){
                        return false;
                    }
                }
                for (int i = 0; i < pieces.length; i++){
                    if (pieces[i].position.getX() == p.getX() && pieces[i].position.getY() == p.getY() && pieces[i].inPlay){
                        if (pieces[i].isWhite != isWhite){
                            pieces[i].killed();
                            return true;
                        }
                        else{
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
//        int i = 0;
//        Position[] holder = new Position[14];
//        for (int j = position.getX(); j < 7; j++){
//            holder[i].setPosition(position.getX() + j, position.getY());
//            i++;
//        }
//        for (int j = position.getX(); j > 0; j--){
//            holder[i].setPosition(position.getX() - j, position.getY());
//            i++;
//        }
//        for (int j = position.getY(); j < 7; j++){
//            holder[i].setPosition(position.getX(), position.getY() + j);
//            i++;
//        }
//        for (int j = position.getY(); j > 0; j--){
//            holder[i].setPosition(position.getX(), position.getY() - j);
//            i++;
//        }
//        return holder;

