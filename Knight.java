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
public class Knight extends GamePiece {
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            if ((position.getX() + 1 == p.getX() && (position.getY() + 2 == p.getY() || position.getY() - 2 == p.getY()))
             || (position.getX() - 1 == p.getX() && (position.getY() + 2 == p.getY() || position.getY() - 2 == p.getY()))
             || (position.getX() + 2 == p.getX() && (position.getY() + 1 == p.getY() || position.getY() - 1 == p.getY()))
             || (position.getX() - 2 == p.getX() && (position.getY() + 1 == p.getY() || position.getY() - 1== p.getY()))){
                for (int i = 0; i < pieces.length; i++){
                    if (pieces[i].position.getX() == p.getX() && pieces[i].position.getY() == p.getY()){
                        if (pieces[i].isWhite != isWhite && pieces[i].inPlay){
                            pieces[i].killed();
                            return true;
                        }
                        else if (pieces[i].isWhite == isWhite && pieces[i].inPlay){
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
//        Position[] holder = new Position[8];
//        if (position.getX() == 0){
//            if (position.getY() < 6){
//                holder[i].setPosition(position.getX() + 1, position.getY() + 2);
//                i++;
//                holder[i].setPosition(position.getX() + 2, position.getY() + 1);
//                i++;
//            }
//            if (position.getY() > 1){
//                holder[i].setPosition(position.getX() + 1, position.getY() - 2);
//                i++;
//                holder[i].setPosition(position.getX() + 2, position.getY() - 1);
//                i++;
//            }
//            if (position.getY() == 1){
//                holder[i].setPosition(position.getX() + 2, position.getY() - 1);
//                i++;
//            }
//            if (position.getY() == 6){
//                holder[i].setPosition(position.getX() + 2, position.getY() + 1);
//                i++;
//            }
//        }
//        if (position.getX() == 7){
//            if (position.getY() < 6){
//                holder[i].setPosition(position.getX() - 1, position.getY() + 2);
//                i++;
//                holder[i].setPosition(position.getX() - 2, position.getY() + 1);
//                i++;
//            }
//            if (position.getY() > 1){
//                holder[i].setPosition(position.getX() - 1, position.getY() - 2);
//                i++;
//                holder[i].setPosition(position.getX() - 2, position.getY() - 1);
//                i++;
//            }
//            if (position.getY() == 1){
//                holder[i].setPosition(position.getX() - 2, position.getY() - 1);
//                i++;
//            }
//            if (position.getY() == 6){
//                holder[i].setPosition(position.getX() - 2, position.getY() + 1);
//                i++;
//            }
//        }
//        return holder;
