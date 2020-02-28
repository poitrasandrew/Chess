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
public class GameBoard {
    String[] spots0 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots1 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots2 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots3 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots4 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots5 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots6 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    String[] spots7 = {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   ",};
    
    public void changeBoard(Position p){
        if (p.getY() == 0){
            spots0[p.getX()] = "   ";
        }
        else if (p.getY() == 1){
            spots1[p.getX()] = "   ";
        }
        else if (p.getY() == 2){
            spots2[p.getX()] = "   ";
        }
        else if (p.getY() == 3){
            spots3[p.getX()] = "   ";
        }
        else if (p.getY() == 4){
            spots4[p.getX()] = "   ";
        }
        else if (p.getY() == 5){
            spots5[p.getX()] = "   ";
        }
        else if (p.getY() == 6){
            spots6[p.getX()] = "   ";
        }
        else if (p.getY() == 7){
            spots7[p.getX()] = "   ";
        }
    }
    
    public void changeBoard(Position p, GamePiece x){
        if (p.getY() == 0){
            spots0[p.getX()] = "   ";
        }
        else if (p.getY() == 1){
            spots1[p.getX()] = "   ";
        }
        else if (p.getY() == 2){
            spots2[p.getX()] = "   ";
        }
        else if (p.getY() == 3){
            spots3[p.getX()] = "   ";
        }
        else if (p.getY() == 4){
            spots4[p.getX()] = "   ";
        }
        else if (p.getY() == 5){
            spots5[p.getX()] = "   ";
        }
        else if (p.getY() == 6){
            spots6[p.getX()] = "   ";
        }
        else if (p.getY() == 7){
            spots7[p.getX()] = "   ";
        }
        
        if (x.position.getY() == 0){
            spots0[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 1){
            spots1[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 2){
            spots2[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 3){
            spots3[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 4){
            spots4[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 5){
            spots5[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 6){
            spots6[x.position.getX()] = x.name;
        }
        else if (x.position.getY() == 7){
            spots7[x.position.getX()] = x.name;
        }
    }
    
    public void printBoard(){
        System.out.println("        _______ _______ _______ _______ _______ _______ _______ _______ ");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     7 |  " + spots7[0] + "  |  " + spots7[1] + "  |  " + spots7[2] + "  |  " + spots7[3] + "  |  " + spots7[4] + "  |  " + spots7[5] + "  |  " + spots7[6] + "  |  " + spots7[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     6 |  " + spots6[0] + "  |  " + spots6[1] + "  |  " + spots6[2] + "  |  " + spots6[3] + "  |  " + spots6[4] + "  |  " + spots6[5] + "  |  " + spots6[6] + "  |  " + spots6[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     5 |  " + spots5[0] + "  |  " + spots5[1] + "  |  " + spots5[2] + "  |  " + spots5[3] + "  |  " + spots5[4] + "  |  " + spots5[5] + "  |  " + spots5[6] + "  |  " + spots5[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     4 |  " + spots4[0] + "  |  " + spots4[1] + "  |  " + spots4[2] + "  |  " + spots4[3] + "  |  " + spots4[4] + "  |  " + spots4[5] + "  |  " + spots4[6] + "  |  " + spots4[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     3 |  " + spots3[0] + "  |  " + spots3[1] + "  |  " + spots3[2] + "  |  " + spots3[3] + "  |  " + spots3[4] + "  |  " + spots3[5] + "  |  " + spots3[6] + "  |  " + spots3[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     2 |  " + spots2[0] + "  |  " + spots2[1] + "  |  " + spots2[2] + "  |  " + spots2[3] + "  |  " + spots2[4] + "  |  " + spots2[5] + "  |  " + spots2[6] + "  |  " + spots2[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     1 |  " + spots1[0] + "  |  " + spots1[1] + "  |  " + spots1[2] + "  |  " + spots1[3] + "  |  " + spots1[4] + "  |  " + spots1[5] + "  |  " + spots1[6] + "  |  " + spots1[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("       |       |       |       |       |       |       |       |       |");
        System.out.println("     0 |  " + spots0[0] + "  |  " + spots0[1] + "  |  " + spots0[2] + "  |  " + spots0[3] + "  |  " + spots0[4] + "  |  " + spots0[5] + "  |  " + spots0[6] + "  |  " + spots0[7] + "  |");
        System.out.println("       |_______|_______|_______|_______|_______|_______|_______|_______|");
        System.out.println("           0       1       2       3       4       5       6       7    ");
    }
}
