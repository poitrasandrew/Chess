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
public class Factory {
//    int whiteRookChange = 3;
//    int whiteKnightChange = 3;
//    int whiteBishopChange = 3;
//    int whiteQueenChange = 2;
//    int blackRookChange = 3;
//    int blackKnightChange = 3;
//    int blackBishopChange = 3;
//    int blackQueenChange = 2;
//    
//    public boolean change(GamePiece[] pieces, int piece, String type){
//        GamePiece p;
//            if(type.equalsIgnoreCase("rook")){
//                p = new Rook();
//                p.position = pieces[piece].position;
//                p.isWhite = pieces[piece].isWhite;
//                if (p.isWhite){
//                    p.name = "WR" + whiteRookChange;
//                    whiteRookChange++;
//                }
//                else if (!p.isWhite){
//                    p.name = "BR" + blackRookChange;
//                    blackRookChange++;
//                }
//                pieces[piece] = p;
//                return false;
//            }
//            else if(type.equalsIgnoreCase("knight")){
//                p = new Knight();
//                p.position = pieces[piece].position;
//                p.isWhite = pieces[piece].isWhite;
//                if (p.isWhite){
//                    p.name = "WN" + whiteKnightChange;
//                    whiteKnightChange++;
//                }
//                else if (!p.isWhite){
//                    p.name = "BN" + blackKnightChange;
//                    blackKnightChange++;
//                }
//                pieces[piece] = p;
//                return false;
//            }
//            else if(type.equalsIgnoreCase("bishop")){
//                p = new Bishop();
//                p.position = pieces[piece].position;
//                p.isWhite = pieces[piece].isWhite;
//                if (p.isWhite){
//                    p.name = "WB" + whiteBishopChange;
//                    whiteBishopChange++;
//                }
//                else if (!p.isWhite){
//                    p.name = "BB" + blackBishopChange;
//                    blackBishopChange++;
//                }
//                pieces[piece] = p;
//                return false;
//            }
//            else if(type.equalsIgnoreCase("queen")){
//                p = new Queen();
//                p.position = pieces[piece].position;
//                p.isWhite = pieces[piece].isWhite;
//                if (p.isWhite){
//                    p.name = "WQ" + whiteQueenChange;
//                    whiteQueenChange ++;
//                }
//                else if (!p.isWhite){
//                    p.name = "BQ" + blackQueenChange;
//                    blackQueenChange ++;
//                }
//                pieces[piece] = p;
//                return false;
//            }
//            else{
//                System.out.println("Choose a valid piece type.");
//            }
//            return true;
//        
//    }
    
    public static GamePiece[] setUp(){
        GamePiece[] pieces = new GamePiece[32];
        //set up pawns
        for (int i = 0; i < 8; i++){
            //white pawns
            pieces[i] = new Pawn();
            pieces[i].position.setPosition(i, 1);
            pieces[i].isWhite = true;
            pieces[i].name = "WP" + (i+1);
            //black pawns
            pieces[i+8] = new Pawn();
            pieces[i+8].position.setPosition(i, 6);
            pieces[i+8].isWhite = false;
            pieces[i+8].name = "BP" + (i+1);
        }
        //set up Rooks
        for (int i = 0; i < 2; i++){
            //white rooks
            pieces[i+16] = new Rook();
            pieces[i+16].position.setPosition(7 * i, 0);
            pieces[i+16].isWhite = true;
            pieces[i+16].name = "WR" + (i+1);
            //black rooks
            pieces[i+18] = new Rook();
            pieces[i+18].position.setPosition(7 * i, 7);
            pieces[i+18].isWhite = false;
            pieces[i+18].name = "BR" + (i+1);
        }
        //set up knights
        for (int i = 0; i < 2; i++){
            //white knights
            pieces[i+20] = new Knight();
            pieces[i+20].position.setPosition((5*i)+1, 0);
            pieces[i+20].isWhite = true;
            pieces[i+20].name = "WN" + (i+1);
            //black knights
            pieces[i+22] = new Knight();
            pieces[i+22].position.setPosition((5*i)+1, 7);
            pieces[i+22].isWhite = false;
            pieces[i+22].name = "BN" + (i+1);
        }
        //set up bishops
        for (int i = 0; i < 2; i++){
            //white bishops
            pieces[i+24] = new Bishop();
            pieces[i+24].position.setPosition((3*i)+2, 0);
            pieces[i+24].isWhite = true;
            pieces[i+24].name = "WB" + (i+1);
            //black bishops
            pieces[i+26] = new Bishop();
            pieces[i+26].position.setPosition((3*i)+2, 7);
            pieces[i+26].isWhite = false;
            pieces[i+26].name = "BB" + (i+1);
        }
        //set up Queens
        //white queen
        pieces[28] = new Queen();
        pieces[28].position.setPosition(3, 0);
        pieces[28].isWhite = true;
        pieces[28].name = "WQ1";
        //black queen
        pieces[29] = new Queen();
        pieces[29].position.setPosition(3, 7);
        pieces[29].isWhite = false;
        pieces[29].name = "BQ1";
        //set up Kings
        //white King
        pieces[30] = new King();
        pieces[30].position.setPosition(4, 0);
        pieces[30].isWhite = true;
        pieces[30].name = "WK1";
        //black King
        pieces[31] = new King();
        pieces[31].position.setPosition(4, 7);
        pieces[31].isWhite = false;
        pieces[31].name = "BK1";
        return pieces;
    }
    public static GameBoard createBoard(Position p, GamePiece[] g, GameBoard gameBoard){
        for (int i = 0; i < 32; i++){
            if(!g[i].isInPlay()){
                gameBoard.changeBoard(g[i].position);
            }
        }
        for (int i = 0; i < 32; i++){
            if(g[i].isInPlay()){
                gameBoard.changeBoard(p, g[i]);
            }
        }
        return gameBoard;
    }
}
