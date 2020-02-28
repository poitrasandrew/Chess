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
public class Bishop extends GamePiece{
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            for (int i = 0; i < 7; i++){
                if (position.getX() +  i == p.getX() && position.getY() + i == p.getY()){
                    for (int j = 0; j < pieces.length; j++){
                        for (int x = 1; x < p.getX() - position.getX(); x++){
                            if (position.getX() + x == pieces[j].position.getX() && position.getY() + x == pieces[j].position.getY() && pieces[j].inPlay){
                                return false;
                            }
                        }
                        if (p.getX() == pieces[j].position.getX() && p.getY() == pieces[j].position.getY() && pieces[j].inPlay){
                            if (isWhite != pieces[j].isWhite){
                                pieces[j].killed();
                                return true;
                            }
                            else if (isWhite == pieces[j].isWhite){
                                return false;
                            }
                        }
                    }
                    return true;
                }
                else if(position.getX() +  i == p.getX() && position.getY() - i == p.getY()){
                    for (int j = 0; j < pieces.length; j++){
                        for (int x = 1; x < p.getX() - position.getX(); x++){
                            if (position.getX() + x == pieces[j].position.getX() && position.getY() - x == pieces[j].position.getY() && pieces[j].inPlay){
                                return false;
                            }
                        }
                        if (p.getX() == pieces[j].position.getX() && p.getY() == pieces[j].position.getY() && pieces[j].inPlay){
                            if (isWhite != pieces[j].isWhite){
                                pieces[j].killed();
                                return true;
                            }
                            else if (isWhite == pieces[j].isWhite){
                                return false;
                            }
                        }
                    }
                    return true;
                }
                else if(position.getX() -  i == p.getX() && position.getY() + i == p.getY()){
                    for (int j = 0; j < pieces.length; j++){
                        for (int x = 1; x < position.getX() - p.getX(); x++){
                            if (position.getX() - x == pieces[j].position.getX() && position.getY() + x == pieces[j].position.getY() && pieces[j].inPlay){
                                return false;
                            }
                        }
                        if (p.getX() == pieces[j].position.getX() && p.getY() == pieces[j].position.getY() && pieces[j].inPlay){
                            if (isWhite != pieces[j].isWhite){
                                pieces[j].killed();
                                return true;
                            }
                            else if (isWhite == pieces[j].isWhite){
                                return false;
                            }
                        }
                    }
                    return true;
                }
                else if(position.getX() -  i == p.getX() && position.getY() - i == p.getY()){
                    for (int j = 0; j < pieces.length; j++){
                        for (int x = 1; x < position.getX() - p.getX(); x++){
                            if (position.getX() - x == pieces[j].position.getX() && position.getY() - x == pieces[j].position.getY() && pieces[j].inPlay){
                                return false;
                            }
                        }
                        if (p.getX() == pieces[j].position.getX() && p.getY() == pieces[j].position.getY() && pieces[j].inPlay){
                            if (isWhite != pieces[j].isWhite){
                                pieces[j].killed();
                                return true;
                            }
                            else if (isWhite == pieces[j].isWhite){
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
