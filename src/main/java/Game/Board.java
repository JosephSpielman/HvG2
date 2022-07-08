package Game;

import Creatures.Goblin;
import Creatures.Humanoid;
import Creatures.Knight;

import java.util.Arrays;

public class Board {
    public static Object[][] generateObjectBoard(Land l,int row, int column, Knight k, Goblin g){
         Object[][] out = new Object[column][row];
         for(Object[] land:out){
             Arrays.fill(land,l);
         }
        out[k.getPosRow()][k.getPosColumn()]=k;
        out[g.getPosRow()][g.getPosColumn()]=g;
        return out;
    }

    public static void openingMessage(){
        System.out.println("-----Knights vs. Goblins-----");
        System.out.println("The knight's village is broke, so the noble knight must fight goblins to the death to get as much treasure as possible!");
    }
    public static String testOpeningMessage(){
        return"-----Knights vs. Goblins-----\n"+
                "The knight's village is broke, so the noble knight must fight goblins to the death to get as much treasure as possible!";
    }

    public static void displayObjectBoard(Object[][] board){
         int counter =0;
         for(Object[] x: board){
             for(Object y: x){
                 System.out.print(y.toString());
                 counter++;
                 if(counter%8==0){
                     System.out.println();
                 }
             }
         }
    }

    public static String displayObjectBoardGUI(Object[][] board){
        int counter =0;
        String out = "";
        for(Object[] x: board){
            for(Object y: x){
                out +=y.toString();
                counter++;
                if(counter%8==0){
                    out += "\n";
                }
            }
        }
        return out;
    }

    public static boolean startBattle(Knight k,Goblin g){
        return(k.getPosColumn() == g.getPosColumn() && k.getPosRow() == g.getPosRow());
    }

    public static boolean openTreasureChest(Humanoid h,Chest c){
        int range = (h.getPosRow() - c.getChestRow()) + (h.getPosColumn() - c.getChestColumn());
        if(h.getClass().getSimpleName().equals("Knight") && range ==0){
            System.out.println("You have reached the treasure chest");
            c.lootChest((Knight)h);
            return true;
        }else if(h.getClass().getSimpleName().equals("Goblin") && range ==0){
            System.out.println("The goblin has destroyed the chest!");
            return false;
        }
        return false;
    }

    public static void setPosition(Object[][] gameBoard,Humanoid h){
        gameBoard[h.getPosRow()][h.getPosColumn()]=h;
    }

    public static void setChest(Object[][] gameBoard,Chest c){
        gameBoard[c.getChestRow()][c.getChestColumn()]=c;
    }

    public static void goblinMove(Object[][]gameBoard,Goblin g,Knight k){
        int gobCol = g.getPosColumn();
        int gobRow = g.getPosRow();
        int kCol = k.getPosColumn();
        int kRow = k.getPosRow();
        boolean getMove = true;
        gameBoard[gobRow][gobCol] = new Land();
        System.out.println("The Goblin Advances.");
        while(getMove){
            if(gobCol>kCol){
                g.setPosColumn(gobCol-1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            } else if (gobCol<kCol) {
                g.setPosColumn(gobCol+1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            }else if(gobRow>kRow){
                g.setPosRow(gobRow-1);
                Board.setPosition(gameBoard,g);
                getMove = false;
                break;
            } else{
                g.setPosRow(gobRow+1);
                Board.setPosition(gameBoard,g);
                getMove = false;
            }
        }
    }

    public static void movePiece(Object[][] gameBoard,Knight k){
        int tempRow = k.getPosRow();
        int tempColumn = k.getPosColumn();
        boolean valid = false;
        k.getPlayerMove();
        while(!valid){
            if(k.getPosColumn()<0 ||k.getPosColumn()>7||k.getPosRow()<0||k.getPosRow()>7) {
                System.out.println("Out of bounds!");
                k.setPosRow(tempRow);
                k.setPosColumn(tempColumn);
                k.getPlayerMove();
            }
            else{
                gameBoard[tempRow][tempColumn] = new Land();
                gameBoard[k.getPosRow()][k.getPosColumn()] = k;
                valid = true;
            }
        }
    }

}
