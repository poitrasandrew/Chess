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
public class Queen extends GamePiece {
    boolean possibleMoves(GamePiece[] pieces, Position p){
        if (inPlay){
            for (int i = 0; i < 7; i++){
                if (position.getX() +  i == p.getX() && position.getY() + i == p.getY()){
                    for (int j = 0; j < pieces.length; j++){
                        for (int x = 1; x <= p.getX() - position.getX(); x++){
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
                        for (int x = 1; x <= p.getX() - position.getX(); x++){
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
                        for (int x = 1; x <= position.getX() - p.getX(); x++){
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
                        for (int x = 1; x <= position.getX() - p.getX(); x++){
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
