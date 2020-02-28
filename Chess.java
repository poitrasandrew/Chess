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
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        GamePiece[] pieces = Factory.setUp();
        System.out.println("Type in 'exit' at any time to exit the game.");
        manager.playGame(pieces);
    }
    
}
