package models;

import java.util.Scanner;

public class Player {
    private String playerName;
    private Symbol symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public Player(String playerName, Symbol symbol, PlayerType playerType) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    // Each player will make move so lets create a method
    // this move will be on Board
    // to make move player need to put row and column
     public Move makeMove(Board board){
         System.out.println(playerName+":" +"Please enter the row");
         int row = scanner.nextInt();
         System.out.println(playerName+":" +"Please enter the column");
         int column = scanner.nextInt();
         return new Move(new Cell(row,column,this),this);
     }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
