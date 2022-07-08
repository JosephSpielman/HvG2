package com.example.hvg2;

import Creatures.Goblin;
import Creatures.Knight;
import Game.Board;
import Game.Chest;
import Game.Land;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Scanner;


public class HelloController {
    Knight player = new Knight();
    Goblin enemy = new Goblin();
    int row = 8;
    int column = 8;
    Object[][] objectBoard = new Object[row][column];
    @FXML
    private Button btnSouth;
    @FXML
    private Button btnNorth;
    @FXML
    private Button btnWest;
    @FXML
    private Button btnEast;
    @FXML
    private Button btnStart;
    @FXML
    private Pane pnMain;
    @FXML
    private Label lblBoard;


    @FXML
    protected void fillGameBoard(){
        objectBoard = Board.generateObjectBoard(new Land(), row, column, player, enemy);
        Board.setPosition(objectBoard,enemy);

        lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));
        btnNorth.setDisable(false);
        btnSouth.setDisable(false);
        btnEast.setDisable(false);
        btnWest.setDisable(false);
    }

    @FXML
    protected void movePlayerNorth(){
        int tempRow = player.getPosRow();
        int tempCol = player.getPosColumn();
        player.setPosRow((player.getPosRow())-1);
        objectBoard[tempRow][tempCol] = new Land();
        Board.setPosition(objectBoard,player);
        //lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));

        if(Board.startBattle(player,enemy)){
            handleBattle();
        }else{
           moveGoblin();
    }
    }

    @FXML
    protected void playerMovement(Button btn){
        String pressed = btn.getId();

        lblBoard.setText(pressed);

    }

    @FXML
    protected void movePlayerSouth(){
        int tempRow = player.getPosRow();
        int tempCol = player.getPosColumn();
        player.setPosRow((player.getPosRow())+1);
        objectBoard[tempRow][tempCol] = new Land();
        Board.setPosition(objectBoard,player);
        lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));
        Board.goblinMove(objectBoard,enemy,player);

    }
    @FXML
    protected void movePlayerWest(){
        int tempRow = player.getPosRow();
        int tempCol = player.getPosColumn();
        player.setPosColumn((player.getPosColumn())-1);
        objectBoard[tempRow][tempCol] = new Land();
        Board.setPosition(objectBoard,player);

        if(Board.startBattle(player,enemy)){
            while(!player.isDead()&&!enemy.isDead()){
                player.attack(enemy);
                enemy.attack(player);
            }
            lblBoard.setText("Enemy Defeated!");
        }else{
            Board.goblinMove(objectBoard,enemy,player);
            lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));}
    }
    @FXML
    protected void movePlayerEast(){
        int tempRow = player.getPosRow();
        int tempCol = player.getPosColumn();
        player.setPosColumn((player.getPosColumn())+1);
        objectBoard[tempRow][tempCol] = new Land();
        Board.setPosition(objectBoard,player);

        if(Board.startBattle(player,enemy)){
            while(!player.isDead()&&!enemy.isDead()){
                player.attack(enemy);
                enemy.attack(player);
            }
            lblBoard.setText("Enemy Defeated!");
        }else{
            Board.goblinMove(objectBoard,enemy,player);
            lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));}
    }
    EventHandler<ActionEvent> buttonEventHandler(){
        return event ->{
            Button pressed = (Button) event.getTarget();
        };
    }

    protected void handleBattle(){
        while(!player.isDead()&&!enemy.isDead()){
            player.attack(enemy);
            enemy.attack(player);
        }
        lblBoard.setText("Enemy Defeated!");
    }

    protected void moveGoblin(){
        Board.goblinMove(objectBoard,enemy,player);
        lblBoard.setText(Board.displayObjectBoardGUI(objectBoard));
    }

}