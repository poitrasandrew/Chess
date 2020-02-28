/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import java.util.*;
/**
 *
 * @author Drew
 */
public class Manager {
    private static Manager instance;
    private static Factory factory;
    int whiteRookChange = 3;
    int whiteKnightChange = 3;
    int whiteBishopChange = 3;
    int whiteQueenChange = 2;
    int blackRookChange = 3;
    int blackKnightChange = 3;
    int blackBishopChange = 3;
    int blackQueenChange = 2;
    
    private Manager(Factory factory){
        this.factory = factory;
    }
    
    private boolean player1Turn = true;
    private GameBoard board = new GameBoard();
    
    public static Manager getInstance(){
        if (instance == null){
            instance = new Manager(factory);
        }
        return instance;
    }
    
    public void changePlayerTurn(){
        if (player1Turn){
            player1Turn = false;
        }
        else if (!player1Turn){
            player1Turn = true;
        }
    }
            
    public boolean isItPlayer1Turn(){
        return player1Turn;
    }
    
    public boolean player1WinCheck(GamePiece[] pieces){
        if (!pieces[31].isInPlay()) {
            System.out.println("Player 1 wins!");
            return true;
        } else return false;
    }
    
    public boolean player2WinCheck(GamePiece[] pieces){
        if (!pieces[30].isInPlay()){
            System.out.println("Player 2 wins!");
            return true;
        }
        else return false;
    }
    
    public void playGame(GamePiece[] pieces){
        Position hold = new Position(-1, -1);
        while (!player1WinCheck(pieces) && !player2WinCheck(pieces)){
            if (isItPlayer1Turn()){
                System.out.println("It is White's turn.");
            }
            else if (!isItPlayer1Turn()){
                System.out.println("It is Black's turn.");
            }
            board = factory.createBoard(hold, pieces, board);
            board.printBoard();
            Scanner input = new Scanner(System.in);
            int piece = 0;
            String pieceCheck;
            boolean correctPiece = false;
            while(!correctPiece){
                System.out.println("Please enter the three letter id of the piece you would like to use.");
                pieceCheck = input.next();
                if (pieceCheck.equalsIgnoreCase("exit")){
                    return;
                }
                for (int i = 0; i < pieces.length; i++){
                    if (pieceCheck.equalsIgnoreCase(pieces[i].name) && pieces[i].inPlay && pieces[i].isWhite == isItPlayer1Turn()){
                        correctPiece = true;
                        piece = i;
                        break;
                    }
                    else if (i == pieces.length - 1){
                        System.out.println("Not a valid piece.");
                    }
                }
            }
            //ask user for coordinates of move
            boolean correctPos = false;
            String xCheck = "", yCheck = "", type;
            loop:
            while(!correctPos){
                boolean validData = false;
                while(!validData){
                    System.out.println("Please enter the X and Y coordinates you would like to move this piece separated by a space (ex:3 4 for (3,4)).");
                    System.out.println("Or type 'cancel' to choose a different piece.");
                    xCheck = input.next();
                    if (xCheck.equalsIgnoreCase("exit")){
                        return;
                    } 
                    else if (xCheck.equalsIgnoreCase("cancel")){
                        break loop;
                    }
                    yCheck = input.next();
                    if (yCheck.equalsIgnoreCase("exit")){
                        return;
                    } 
                    else if (yCheck.equalsIgnoreCase("cancel")){
                        break loop;
                    }
                    else if (xCheck.matches("\\d+") && yCheck.matches("\\d+")){
                        validData = true;
                    }
                    else {
                        System.out.println("Please use valid entries.");
                    }
                }
                if  (Integer.parseInt(xCheck) >= 0 && Integer.parseInt(xCheck) <=7 && Integer.parseInt(yCheck) >= 0 && Integer.parseInt(yCheck) <= 7){
                    Position p = new Position(Integer.parseInt(xCheck), Integer.parseInt(yCheck));
                    boolean canMove = pieces[piece].possibleMoves(pieces, p);
                    if (canMove){
                        Position oldP = new Position(pieces[piece].position.getX(), pieces[piece].position.getY());
                        pieces[piece].move(p);
                        if (pieces[piece].changeType){
                            boolean canChange = true;
                            while(canChange){
                                System.out.println("What would you like to change the pawn too (ex: 'queen' 'rook' 'knight' 'bishop')?");
                                type = input.next();
                                canChange = change(pieces, piece, type);
                            }
                        }
                        board = factory.createBoard(oldP, pieces, board);
                        //set enemy pawns to not be en passant killed
                        for (int i = 0; i < pieces.length; i ++){
                            if (pieces[i].isWhite != isItPlayer1Turn()){
                                pieces[i].enPassant = false;
                            }
                        }
                        changePlayerTurn();
                        correctPos = true;
                    }
                }
                else{
                    System.out.println("Please choose values from 0 to 7.");
                }
            }
        }
        board.printBoard();
        
        //allow for cancel to choose different piece
        //update the board when a move is made and print it
        //update the player turn
        //hold the old position of the piece that moved for board
        //set up the main to run this and loop it
    }
    
    public boolean change(GamePiece[] pieces, int piece, String type){
        GamePiece p;
            if(type.equalsIgnoreCase("rook")){
                p = new Rook();
                p.position = pieces[piece].position;
                p.isWhite = pieces[piece].isWhite;
                if (p.isWhite){
                    p.name = "WR" + whiteRookChange;
                    whiteRookChange++;
                }
                else if (!p.isWhite){
                    p.name = "BR" + blackRookChange;
                    blackRookChange++;
                }
                pieces[piece] = p;
                return false;
            }
            else if(type.equalsIgnoreCase("knight")){
                p = new Knight();
                p.position = pieces[piece].position;
                p.isWhite = pieces[piece].isWhite;
                if (p.isWhite){
                    p.name = "WN" + whiteKnightChange;
                    whiteKnightChange++;
                }
                else if (!p.isWhite){
                    p.name = "BN" + blackKnightChange;
                    blackKnightChange++;
                }
                pieces[piece] = p;
                return false;
            }
            else if(type.equalsIgnoreCase("bishop")){
                p = new Bishop();
                p.position = pieces[piece].position;
                p.isWhite = pieces[piece].isWhite;
                if (p.isWhite){
                    p.name = "WB" + whiteBishopChange;
                    whiteBishopChange++;
                }
                else if (!p.isWhite){
                    p.name = "BB" + blackBishopChange;
                    blackBishopChange++;
                }
                pieces[piece] = p;
                return false;
            }
            else if(type.equalsIgnoreCase("queen")){
                p = new Queen();
                p.position = pieces[piece].position;
                p.isWhite = pieces[piece].isWhite;
                if (p.isWhite){
                    p.name = "WQ" + whiteQueenChange;
                    whiteQueenChange ++;
                }
                else if (!p.isWhite){
                    p.name = "BQ" + blackQueenChange;
                    blackQueenChange ++;
                }
                pieces[piece] = p;
                return false;
            }
            else{
                System.out.println("Choose a valid piece type.");
            }
            return true;
        
    }
}
