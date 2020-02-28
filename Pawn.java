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
public class Pawn extends GamePiece {
    boolean isFirstMove = true;
    
    void move(Position p){
        if (isFirstMove && (p.getY() == position.getY() + 2 || p.getY() == position.getY() - 2)){
            enPassant = true;
        }
        position = p;
        isFirstMove = false;
        if (position.getY() == 0 || position.getY() == 7){
            changeType = true;
        }
    }
    //put out of bounds check where function is called
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            for (int i = 0; i < pieces.length ; i++){
                //check for en passant
                if (pieces[i].enPassant && pieces[i].inPlay && pieces[i].isWhite != isWhite && p.getX() == pieces[i].position.getX() && (p.getY() + 1 == pieces[i].position.getY() || p.getY() - 1 == pieces[i].position.getY())){
                    if (isWhite && (p.getX() == position.getX() + 1 || p.getX() == position.getX() - 1) && p.getY() == position.getY() + 1){
                        pieces[i].killed();
                        return true;
                    }
                    //check valid attack for black
                    else if (!isWhite && (p.getX() == position.getX() + 1 || p.getX() == position.getX() - 1) && p.getY() == position.getY() - 1){
                        pieces[i].killed();
                        return true;
                    }
                }
                //check if attack against in play enemy pieces
                if (p.getX() == pieces[i].position.getX() && p.getY() == pieces[i].position.getY() && pieces[i].isWhite != isWhite && pieces[i].inPlay){
                    //check valid attack for white
                    if (isWhite && (p.getX() == position.getX() + 1 || p.getX() == position.getX() - 1) && p.getY() == position.getY() + 1){
                        pieces[i].killed();
                        return true;
                    }
                    //check valid attack for black
                    else if (!isWhite && (p.getX() == position.getX() + 1 || p.getX() == position.getX() - 1) && p.getY() == position.getY() - 1){
                        pieces[i].killed();
                        return true;
                    }
                }
            }
            //check for valid x and y position for move
            if (p.getX() == position.getX() && (p.getY() == position.getY() + 1 || p.getY() == position.getY() - 1 || p.getY() == position.getY() + 2 || p.getY() == position.getY() - 2)){       
                for (int i = 0; i < pieces.length; i++){
                    //check that another in play piece isn't there already
                    if ((p.getY() != pieces[i].position.getY() && p.getX() != pieces[i].position.getX()) || (p.getX() == pieces[i].position.getX() && p.getY() == pieces[i].position.getY() && !pieces[i].inPlay)){
                        //check for white piece
                        if (isWhite){
                            if (p.getY() == position.getY() + 2 && pieces[i].position.getX() == position.getX() && pieces[i].position.getY() == position.getY() + 1){
                                return false;
                            }
                            else if(!isFirstMove && p.getY() == position.getY() + 2){
                                return false;
                            }
                            else if (p.getY() != position.getY() + 1 && p.getY() != position.getY() + 2){
                                return false;
                            }
                        }
                        //check if black piece
                        else if(!isWhite){
                            if (p.getY() == position.getY() - 2 && pieces[i].position.getX() == position.getX() && pieces[i].position.getY() == position.getY() - 1){
                                return false;
                            }
                            else if(!isFirstMove && p.getY() == position.getY() - 2){
                                return false;
                            }
                            else if (p.getY() != position.getY() - 1 && p.getY() != position.getY() - 2){
                                return false;
                            }
                        }
                    }
                    else if ((p.getY() == pieces[i].position.getY() && p.getX() == pieces[i].position.getX()) && pieces[i].inPlay){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
//        int i = 0;
//        Position[] holder = new Position[4];
//        if (isFirstMove && isWhite){
//            holder[i].setPosition(position.getX(), position.getY() + 2);
//            i++;
//        }
//        if (isFirstMove && !isWhite){
//            holder[i].setPosition(position.getX(), position.getY() - 2);
//            i++;
//        }
//        if (isWhite){
//            holder[i].setPosition(position.getX(), position.getY() + 1);
//            i++;
//        }
//        if (!isWhite){
//            holder[i].setPosition(position.getX(), position.getY() - 1);
//            i++;
//        }
//        if (canAttack && isWhite){
//            holder[i].setPosition(position.getX() + 1, position.getY() + 1);
//            i++;
//            holder[i].setPosition(position.getX() - 1, position.getY() + 1);
//            i++;
//        }
//        if (canAttack && isWhite){
//            holder[i].setPosition(position.getX() + 1, position.getY() - 1);
//            i++;
//            holder[i].setPosition(position.getX() - 1, position.getY() - 1);
//            i++;
//        }
//        for (int j = 0; j < holder.length; j++){
//            for (int k = 0; k < pieces.length; k++){
//                if 
//            }
//        }
//        return holder;
